package com.trust.xfyl.controller;

import com.trust.xfyl.dao.DoctorMapper;
import com.trust.xfyl.dao.TrackingPersonnelMapper;
import com.trust.xfyl.dao.TrustRelationFileMapper;
import com.trust.xfyl.dao.WoundOrdersMapper;
import com.trust.xfyl.entity.*;
import com.trust.xfyl.entity.vo.WoundOrderVo;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.service.FileService;
import com.trust.xfyl.service.OrderService;
import com.trust.xfyl.util.ResultVOUtil;
import com.trust.xfyl.util.UuidUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author djj
 * @Description //TODO
 * @Date 11:14 2024/2/18
 **/
@Api(value = "订单", description = "订单", tags = "订单")
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final WoundOrdersMapper woundOrdersMapper;
    private final FileService fileService;
    private final TrustRelationFileMapper trustRelationFileMapper;
    private final DoctorMapper doctorMapper;
    private final TrackingPersonnelMapper trackingPersonnelMapper;

    public OrderController(OrderService orderService, WoundOrdersMapper woundOrdersMapper, FileService fileService, TrustRelationFileMapper trustRelationFileMapper, DoctorMapper doctorMapper, TrackingPersonnelMapper trackingPersonnelMapper) {
        this.orderService = orderService;
        this.woundOrdersMapper = woundOrdersMapper;
        this.fileService = fileService;
        this.trustRelationFileMapper = trustRelationFileMapper;
        this.doctorMapper = doctorMapper;
        this.trackingPersonnelMapper = trackingPersonnelMapper;
    }

    /**
     * @return com.trust.xfyl.entity.ResultVO
     * @Author djj
     * @Description //TODO 获取订单列表以及所关联的患者信息，医生信息，图片信息的列表集合。
     * @Date 17:04 2024/2/18
     * @Param [woundOrders]
     **/
    @ApiOperation(value = "获取列表", nickname = "selectOrderAll", notes = "获取列表")
    @PostMapping("/selectOrderAll")
    public ResultVO selectOrderAll(@ApiParam(value = "订单对象", required = true) @RequestBody WoundOrders woundOrders) {
        try {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            JSONObject returnPage = new JSONObject();
            woundOrders.setStart((woundOrders.getPage() - 1) * woundOrders.getCount());
            woundOrders.setEnd(woundOrders.getCount());
            Long count = woundOrdersMapper.count(woundOrders);
            List<WoundOrderVo> woundOrders1 = woundOrdersMapper.selectAll(woundOrders);
            returnPage.put("totalCount", count);
            returnPage.put("page", woundOrders.getPage());
            returnPage.put("count", woundOrders.getCount());
            returnMap.put("returnPage", returnPage);
            returnMap.put("woundOrders", woundOrders1);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }

    }

    @ApiOperation(value = "保存一条数据", nickname = "saveOrder", notes = "保存一条数据")
    @PostMapping("/saveOrder")
    public ResultVO saveOrder(@ApiParam(value = "订单对象", required = true) @RequestBody WoundOrders woundOrders) {
        try {
            // 判断是新增还是更新订单
            if (woundOrders.getId() != null) {
                // 更新订单逻辑
                return updateOrder(woundOrders);
            } else {
                // 新增订单逻辑
                return insertOrder(woundOrders);
            }
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            return ResultVOUtil.error(-1, "系统错误，请联系管理员");
        }
    }

    private ResultVO updateOrder(WoundOrders woundOrders) {
        woundOrders.setUpdateTime(new Date());
        Long i = orderService.updateByPrimaryKeySelective(woundOrders);
        if (i > 0 && woundOrders.getWoundPhotoIds() != null && !woundOrders.getWoundPhotoIds().isEmpty()) {
            updateWoundPhotos(woundOrders.getId(), woundOrders.getPerioperativeSurgery(), woundOrders.getWoundPhotoIds());
        }
        return i > 0 ? ResultVOUtil.success("保存成功") : ResultVOUtil.error("保存失败");
    }

    private ResultVO insertOrder(WoundOrders woundOrders) {
        // 校验是否已存在相同数据
        WoundOrdersExample woundOrdersExample = new WoundOrdersExample();
        woundOrdersExample.createCriteria().andPerioperativeSurgeryEqualTo(woundOrders.getPerioperativeSurgery())
                .andTaskIdEqualTo(woundOrders.getTaskId());
        List<WoundOrders> orderList = woundOrdersMapper.selectByExample(woundOrdersExample);
        if (orderList.size() > 0) {
            return ResultVOUtil.error("已经上传过:" + woundOrders.getPerioperativeSurgery() + "请不要重复上传");
        }

        setupNewOrder(woundOrders);
        Long integer = orderService.insertSelective(woundOrders);
        if (integer > 0 && woundOrders.getWoundPhotoIds() != null && !woundOrders.getWoundPhotoIds().isEmpty()) {
            addWoundPhotos(integer, woundOrders.getPerioperativeSurgery(), woundOrders.getWoundPhotoIds());
        }
        return integer > 0 ? ResultVOUtil.success("保存成功") : ResultVOUtil.error("保存失败");
    }

    private void updateWoundPhotos(Long orderId, String surgeryType, String photoIds) {
        TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
        trustRelationFileExample.createCriteria().andBusiTypeEqualTo("woundOrders").andBusiIdEqualTo(String.valueOf(orderId)).andPhotoTypeEqualTo(surgeryType);
        List<TrustRelationFile> trustRelationFiles = trustRelationFileMapper.selectByExample(trustRelationFileExample);
        if (!trustRelationFiles.isEmpty()) {
            trustRelationFiles.forEach(trustRelationFile -> {
                TrustRelationFileExample example = new TrustRelationFileExample();
                example.createCriteria().andBusiIdEqualTo(trustRelationFile.getBusiId()).andBusiTypeEqualTo("woundOrders");
                trustRelationFileMapper.deleteByExample(example);
            });
        }
        addWoundPhotos(orderId, surgeryType, photoIds);
    }

    private void addWoundPhotos(Long orderId, String surgeryType, String photoIds) {
        TrustRelationFile trustRelationFile = new TrustRelationFile();
        trustRelationFile.setFileId(photoIds);
        trustRelationFile.setBusiType("woundOrders");
        trustRelationFile.setBusiId(String.valueOf(orderId));
        trustRelationFile.setPhotoType(surgeryType);
        fileService.addFileRela(trustRelationFile);
    }

    private void setupNewOrder(WoundOrders woundOrders) {
        woundOrders.setCreateTime(new Date());
        woundOrders.setIsDelete(0);
        woundOrders.setOrderNumber(UuidUtil.getUUID());
        woundOrders.setOrderPrice(BigDecimal.valueOf(0.00));
        woundOrders.setOrderType("待服务");
        woundOrders.setAppointmentType("直接预约");
        woundOrders.setIsReservation("0");
    }

    /**
     * @return com.trust.xfyl.entity.ResultVO
     * @Author djj
     * @Description //TODO 获取该订单的信息，以及所关联的医生的信息，患者的信息，伤口照片的信息
     * @Date 17:55 2024/2/18
     * @Param [id]
     **/
    @ApiOperation(value = "根据id查询一条数据", nickname = "selectOrderById", notes = "根据id查询一条数据")
    @GetMapping("selectOrderById")
    public ResultVO selectOrderById(@ApiParam(name = "id", value = "主键", required = true) @RequestParam("id") Long id) {
        try {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            WoundOrderVo woundOrderVo = woundOrdersMapper.selectWoundOrdersById(id);
            returnMap.put("woundOrderVo", woundOrderVo);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }
    }

    /**
     * @return com.trust.xfyl.entity.ResultVO
     * @Author djj
     * @Description //TODO 这个方法主要更新的是订单的预约状态，是否同意隐私保护协议，是否删除，以及订单的状态。
     * @Date 2024/2/18
     * @Param [woundOrders]
     **/
    @ApiOperation(value = "更新订单信息", nickname = "UpdateReservation", notes = "更新订单信息")
    @PostMapping("UpdateReservation")
    public ResultVO UpdateReservation(@ApiParam(value = "订单对象", required = true) @RequestBody WoundOrders woundOrders) {
        try {
            woundOrders.setUpdateTime(new Date());
            int i = woundOrdersMapper.updateByPrimaryKeySelective(woundOrders);
            if (i > 0) {
                return ResultVOUtil.success("更新成功");
            } else {
                return ResultVOUtil.error("更新失败");
            }

        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            return ResultVOUtil.error(-1, e.getMessage());
        }
    }
}
