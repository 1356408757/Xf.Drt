package com.trust.xfyl.controller;

import com.trust.xfyl.dao.SurgeryMapper;
import com.trust.xfyl.dao.TrustRelationFileMapper;
import com.trust.xfyl.entity.*;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.service.FileService;
import com.trust.xfyl.service.SurgeryService;
import com.trust.xfyl.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LENOVO
 */
@Api(value = "手术伤口照片上传", description = "伤口照片上传", tags = "手术伤口照片上传")
@RestController
@RequestMapping("/surgery")
public class SurgeryController {
    private final SurgeryMapper surgeryMapper;
    private final SurgeryService surgeryService;
    private final FileService fileService;
    private final TrustRelationFileMapper trustRelationFileMapper;

    public SurgeryController(SurgeryMapper surgeryMapper, SurgeryService surgeryService, FileService fileService, TrustRelationFileMapper trustRelationFileMapper) {
        this.surgeryMapper = surgeryMapper;
        this.surgeryService = surgeryService;
        this.fileService = fileService;
        this.trustRelationFileMapper = trustRelationFileMapper;
    }

    @ApiOperation(value = "获取列表", nickname = "selectSurgeryAll", notes = "获取列表")
    @PostMapping("/selectSurgeryAll")
    public ResultVO selectSurgeryAll(@ApiParam(value = "手术伤口照片上传的对象", required = true) @RequestBody Surgery surgery) {
        try {
            JSONObject returnPage = new JSONObject();
            Map<String, Object> returnMap = new HashMap<String, Object>();
            SurgeryExample surgeryExample = new SurgeryExample();
            if (!"".equals(surgery.getSurgeryName()) && surgery.getSurgeryName() != null) {
                surgeryExample.createCriteria().andSurgeryNameEqualTo(surgery.getSurgeryName());
            }
            if (!"".equals(surgery.getSurgeryType()) && surgery.getSurgeryType() != null) {
                surgeryExample.createCriteria().andSurgeryTypeEqualTo(surgery.getSurgeryType());
            }
            surgeryExample.setStart((surgery.getPage() - 1) * surgery.getCount());
            surgeryExample.setEnd(surgery.getCount());
            Long count1 = surgeryMapper.count(surgeryExample);
            List<Surgery> surgeries = surgeryMapper.selectByExample(surgeryExample);
            returnPage.put("totalCount", count1);
            returnPage.put("pag", surgery.getPage());
            returnPage.put("count", surgery.getCount());
            returnMap.put("page", returnPage);
            returnMap.put("msg", "success");
            returnMap.put("data", surgeries);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }

    }


    /**
     * @return com.trust.xfyl.entity.ResultVO
     * @Author djj
     * @Description 首先判断前端传过来的数据是否有surgery的主键，如果有那就修改，如果没有那就新增
     * 新增的时候 根据传过来的surgeryType以及患者的关联主键trackingPersonnelId判断该患者的节点照片是否已经上传过
     * 如果上传过那就返回状态。，如果没有那就新增，新增完成返回表主键，然后将主键，以及设置的图片类型以及上传节点保存到TrustRelationFile里面
     * 前端传过来的数据有主键的话 那就代表修改surgery的表的信息，首先更新surgery表的数据，然后判断传过来的是否有fileId如果有那就
     * 代表需要更换图片关联信息，也就是说要删除掉TrustRelationFile里面的跟当前Surgery_id所关联的数据然后将新的FileId重新保存到
     * 如果是新增的话 那就往订单里面新增一条数据。
     * TrustRelationFile里面即可。
     * @Date 15:54 2024/1/25
     * @Param [surgery]
     **/

    @ApiOperation(value = "保存一条上传伤口照片的记录", nickname = "saveSurgery", notes = "保存一条上传伤口照片的记录")
    @PostMapping("/saveSurgery")
    public ResultVO saveSurgery(@ApiParam(value = "手术伤口照片上传的对象", required = true) @RequestBody Surgery surgery) {
        try {
            if (surgery.getSurgeryId() != null) {
                Long aLong = surgeryService.updateByPrimaryKeySelective(surgery);
                if (aLong > 0 && (surgery.getFileId() != null)) {
                    Long surgeryId = surgery.getSurgeryId();
                    TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
                    trustRelationFileExample.createCriteria()
                            .andBusiTypeEqualTo("surgery")
                            .andBusiIdEqualTo(String.valueOf(surgeryId));
                    List<TrustRelationFile> trustRelationFiles = trustRelationFileMapper.selectByExample(trustRelationFileExample);
                    if (trustRelationFiles.size() > 0) {
                        for (int i1 = 0; i1 < trustRelationFiles.size(); i1++) {
                            TrustRelationFile trustRelationFile = trustRelationFiles.get(i1);
                            TrustRelationFileExample trustRelationFileExample1 = new TrustRelationFileExample();
                            trustRelationFileExample1.createCriteria()
                                    .andBusiIdEqualTo(trustRelationFile.getBusiId())
                                    .andBusiTypeEqualTo("surgery");
                            trustRelationFileMapper.deleteByExample(trustRelationFileExample1);
                        }
                    }
                    TrustRelationFile trustRelationFile = new TrustRelationFile();
                    trustRelationFile.setFileId(surgery.getFileId());
                    trustRelationFile.setBusiType("surgery");
                    trustRelationFile.setBusiId(aLong + "");
                    trustRelationFile.setPhotoType(surgery.getSurgeryType());
                    boolean b = fileService.addFileRela(trustRelationFile);
                }
                if (aLong > 0) {
                    return ResultVOUtil.success();
                } else {
                    return ResultVOUtil.error("修改失败");
                }
            } else {
                SurgeryExample surgeryExample = new SurgeryExample();
                surgeryExample.createCriteria().andSurgeryTypeEqualTo(surgery.getSurgeryType())
                        .andTrackingPersonnelIdEqualTo(surgery.getTrackingPersonnelId());
                List<Surgery> surgeries = surgeryMapper.selectByExample(surgeryExample);
                if (surgeries.size() > 0) {
                    return ResultVOUtil.error("已经上传过:" + surgery.getSurgeryType() + "请不要重复上传");
                } else {
                    if (surgery.getFileId() != null && !surgery.getFileId().equals("")) {
                        surgery.setWoundPhotoUpload(surgery.getFileId());
                    }
                    surgery.setCreatTime(new Date());
                    Long aLong = surgeryService.insertSelective(surgery);
                    if (aLong >0 && (surgery.getFileId() != null)) {
                        TrustRelationFile trustRelationFile = new TrustRelationFile();
                        trustRelationFile.setFileId(surgery.getFileId());
                        trustRelationFile.setBusiType("surgery");
                        trustRelationFile.setBusiId(aLong + "");
                        trustRelationFile.setPhotoType(surgery.getSurgeryType());
                        fileService.addFileRela(trustRelationFile);
                    }
                    if (aLong >0) {
                        return ResultVOUtil.success();
                    } else {
                        return ResultVOUtil.error("添加失败");
                    }
                }
            }

        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            return ResultVOUtil.error(-1, e.getMessage());
        }
    }


    @ApiOperation(value = "批量删除", nickname = "deleteSurgery", notes = "批量删除")
    @GetMapping("/deleteSurgery")
    public ResultVO deleteSurgery(@ApiParam(name = "ids", value = "主键字符串的形式", required = true) @RequestParam("ids") String ids) {
        try {
            int i1 = 0;
            String[] Split = ids.split(",");
            for (int i = 0; i < Split.length; i++) {
                String s = Split[i];
                SurgeryExample surgeryExample = new SurgeryExample();
                surgeryExample.createCriteria().andSurgeryIdEqualTo(Long.valueOf(s));
                i1 = surgeryMapper.deleteByExample(surgeryExample);
                TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
                trustRelationFileExample.createCriteria().andBusiIdEqualTo(s).andBusiTypeEqualTo("surgery");
                int i2 = trustRelationFileMapper.countByExample(trustRelationFileExample);
                if (i2 > 0) {
                    for (int j = 0; j < i2; j++) {
                        trustRelationFileMapper.deleteByExample(trustRelationFileExample);
                    }
                }
            }
            if (i1 > 0) {
                return ResultVOUtil.success("操作成功");
            } else {
                return ResultVOUtil.error("失败");
            }
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            return ResultVOUtil.error(-1, e.getMessage());
        }
    }


    @ApiOperation(value = "根据id查询一条数据", nickname = "selectSurgeryById", notes = "根据id查询一条数据")
    @GetMapping("selectSurgeryById")
    public ResultVO selectSurgeryById(@ApiParam(name = "id", value = "主键", required = true) @RequestParam("id") Long id) {
        try {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Surgery surgery1 = surgeryMapper.selectByPrimaryKey(id);
            returnMap.put("surgery", surgery1);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }
    }
}
