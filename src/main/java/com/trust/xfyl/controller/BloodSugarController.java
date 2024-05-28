package com.trust.xfyl.controller;

import com.trust.xfyl.dao.BloodSugarMapper;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.model.ResultVO;
import com.trust.xfyl.model.ResultVOUtil;
import com.trust.xfyl.model.po.BloodSugar;
import com.trust.xfyl.model.po.BloodSugarExample;
import com.trust.xfyl.util.ScExceptionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

/**
 * @author Bay-max
 * @title BloodSugarController
 * @date 2024/5/15 9:25
 * @description TODO
 */
@Api(value = "血糖控制器", description = "血糖控制器", tags = "血糖控制器")
@RestController
@RequestMapping("/bloodSugar")
public class BloodSugarController {
    private final static Logger logger = LoggerFactory.getLogger(BloodSugarController.class);
    private final BloodSugarMapper bloodSugarMapper;
    public BloodSugarController(BloodSugarMapper bloodSugarMapper) {
        this.bloodSugarMapper = bloodSugarMapper;
    }
    /**
     * 获取食物糖分列表
     *
     * @param bloodSugar 包含查询条件和分页信息的食物糖分对象
     * @param request    HTTP请求对象
     * @return 返回查询结果的ResultVO对象
     */
    @PostMapping("/selectBloodSugar")
    @ApiOperation(value = "获取血糖记录列表", nickname = "selectBloodSugar", notes = "获取血糖记录列表")
    public ResultVO selectBloodSugar(@ApiParam(value = "查询条件和分页信息", required = true) @RequestBody @Valid BloodSugar bloodSugar, HttpServletRequest request) {
        try {
            // 校验分页参数
            if (bloodSugar.getPage() == null || bloodSugar.getCount() == null || bloodSugar.getPage() <= 0 || bloodSugar.getCount() <= 0) {
                return ResultVOUtil.error("分页参数不合法");
            }
            Map<String, Object> returnMap = new HashMap<>();
            BloodSugarExample bloodSugarExample = new BloodSugarExample();
            // 设置查询条件
            if (bloodSugar.getUserId() != null) {
                bloodSugarExample.createCriteria().andUserIdEqualTo(bloodSugar.getUserId());
            }
            bloodSugarExample.createCriteria().andIsDeleteEqualTo("0");
            // 设置分页参数
            bloodSugarExample.setStart((bloodSugar.getPage() - 1) * bloodSugar.getCount());
            // 执行查询
            List<BloodSugar> bloodSugarList = bloodSugarMapper.selectByExample(bloodSugarExample);
            Long count = bloodSugarMapper.count(bloodSugarExample);
            Map<String, Object> returnPage = new HashMap<>();
            returnPage.put("totalCount", count);
            returnPage.put("page", bloodSugar.getPage());
            returnPage.put("count", bloodSugar.getCount());
            returnMap.put("returnPage", returnPage);
            returnMap.put("msg", "success");
            returnMap.put("bloodSugars", bloodSugarList);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching blood sugar list: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }
    @ApiOperation(value = "保存一条血糖记录", nickname = "saveBloodSugar", notes = "保存一条血糖记录")
    @PostMapping("/saveBloodSugar")
    public ResultVO saveBloodSugar(@ApiParam(value = "血糖对象", required = true) @RequestBody BloodSugar bloodSugar) {
        try {
            // 验证和清洗BloodSugar对象
            validateAndCleanBloodSugar(bloodSugar);

            // 设置公共字段
            setCommonFields(bloodSugar);

            // 根据bloodId判断是更新还是保存
            if (bloodSugar.getBloodId() != null) {
                return updateBloodSugar(bloodSugar);
            } else {
                return saveNewBloodSugar(bloodSugar);
            }

        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }
    /**
     * 验证和清洗BloodSugar对象
     *
     * @param bloodSugar 需要验证和清洗的BloodSugar对象
     * @return 清洗后的BloodSugar对象
     * @throws IllegalArgumentException 如果bloodSugar对象或其属性不符合验证规则
     */
    private BloodSugar validateAndCleanBloodSugar(BloodSugar bloodSugar) throws IllegalArgumentException {
        if (bloodSugar == null) {
            throw new IllegalArgumentException("BloodSugar对象不能为空");
        }
        if (bloodSugar.getSugarLevel() == null) {
            throw new IllegalArgumentException("BloodSugar的level值不能为空");
        }
        // 假设血糖水平应介于一定范围内
        int minLevel = 0;
        int maxLevel = 200;
        if (bloodSugar.getSugarLevel() < minLevel || bloodSugar.getSugarLevel() > maxLevel) {
            throw new IllegalArgumentException("BloodSugar的level值不合法，应介于" + minLevel + "和" + maxLevel + "之间");
        }
        return bloodSugar;
    }
    /**
     * 设置公共字段
     */
    private void setCommonFields(BloodSugar bloodSugar) {
        bloodSugar.setCreateTime(new Date());
        bloodSugar.setIsDelete("0");
    }
    /**
     * 更新血糖记录
     */
    private ResultVO updateBloodSugar(BloodSugar bloodSugar) {
        int i = bloodSugarMapper.updateByPrimaryKeySelective(bloodSugar);
        if (i > 0) {
            return ResultVOUtil.success("更新成功");
        } else {
            return ResultVOUtil.error("更新失败");
        }
    }
    /**
     * 保存新血糖记录
     */
    private ResultVO saveNewBloodSugar(BloodSugar bloodSugar) {
        int i = bloodSugarMapper.insertSelective(bloodSugar);
        if (i > 0) {
            return ResultVOUtil.success("保存成功");
        } else {
            return ResultVOUtil.error("保存失败");
        }
    }

    /**
     * 批量删除药品记录
     *
     * @param ids 待删除记录的主键ID序列，以字符串形式表示，各ID之间用逗号分隔。
     * @return 返回操作结果，如果操作成功，返回成功信息；如果操作失败，返回错误信息。
     */
    @ApiOperation(value = "批量删除", nickname = "deleteBloodSugar", notes = "批量删除")
    @DeleteMapping("/deleteBloodSugar")
    public ResultVO deleteBloodSugar(@ApiParam(name = "ids", value = "主键字符串的形式", required = true) @RequestParam("ids") String ids) {
        try {
            // 判断传入的待删除ID是否为空并进行格式校验
            if (ids == null || ids.isEmpty() || !ids.matches("\\d+(,\\d+)*")) {
                return ResultVOUtil.error("待删除ID不能为空且必须为整数序列(如1,2,3)");
            }

            // 将待删除ID转换为整型数组
            int[] idsArray = Arrays.stream(ids.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 执行批量删除操作
            int totalDeleted = deleteByIds(idsArray);

            // 根据删除成功的记录数，返回对应的操作结果
            return (totalDeleted > 0) ? ResultVOUtil.success("操作成功") : ResultVOUtil.error("操作失败");
        } catch (NumberFormatException e) {
            // 处理输入格式异常
            return ResultVOUtil.error("待删除ID格式错误，必须为整数序列(如1,2,3)");
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }

    /**
     * 执行批量删除操作
     *
     * @param idsArray 待删除记录的ID数组
     * @return 成功删除的记录数
     */
    private int deleteByIds(int[] idsArray) {
        int totalDeleted = 0;
        // 执行批量删除逻辑
        for (int id : idsArray) {
            totalDeleted += bloodSugarMapper.deleteByPrimaryKey(id);
        }
        return totalDeleted;
    }


}
