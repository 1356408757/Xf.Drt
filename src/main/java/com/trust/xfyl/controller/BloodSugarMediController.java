package com.trust.xfyl.controller;

import com.trust.xfyl.dao.BloodSugarMedicationsMapper;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.model.ResultVO;
import com.trust.xfyl.model.ResultVOUtil;
import com.trust.xfyl.model.po.BloodSugarMedications;
import com.trust.xfyl.model.po.BloodSugarMedicationsExample;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 血糖用药控制器
 *
 * @author Bay-max
 * @title BloodSugarMediController
 * @date 2024/5/15 18:23
 * @description 血糖用药相关的API处理
 */
@Api(value = "血糖用药控制器", description = "血糖用药控制器", tags = "血糖用药控制器")
@RestController
@RequestMapping("/sugarMedi")
public class BloodSugarMediController {
    private final static Logger logger = LoggerFactory.getLogger(BloodSugarMediController.class);
    private final BloodSugarMedicationsMapper bloodSugarMedicationsMapper;

    /**
     * 血糖用药控制器构造函数
     *
     * @param bloodSugarMedicationsMapper 血糖用药数据访问对象
     */
    public BloodSugarMediController(BloodSugarMedicationsMapper bloodSugarMedicationsMapper) {
        this.bloodSugarMedicationsMapper = bloodSugarMedicationsMapper;
    }

    /**
     * 获取血糖用药列表
     *
     * @param bloodSugarMedications 血糖用药对象，用于过滤条件
     * @param request               HTTP请求对象
     * @return 血糖用药列表的结果对象
     */
    @PostMapping("/selectSugarMedis")
    @ApiOperation(value = "获取血糖用药列表", nickname = "selectSugarMedis", notes = "根据条件获取血糖用药列表")
    public ResultVO selectSugarMedis(@ApiParam(value = "bloodSugarMedications", required = true) @RequestBody @Valid BloodSugarMedications bloodSugarMedications, HttpServletRequest request) {
        try {
            BloodSugarMedicationsExample bloodSugarMedicationsExample = new BloodSugarMedicationsExample();
            bloodSugarMedicationsExample.createCriteria().andIsDeleteEqualTo("0");

            List<BloodSugarMedications> bloodSugarMedicationsList = bloodSugarMedicationsMapper.selectByExample(bloodSugarMedicationsExample);
            return ResultVOUtil.success(bloodSugarMedicationsList);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }


    /**
     * 保存或更新一条药品记录
     *
     * @param bloodSugarMedications 药品对象
     * @return 返回保存或更新结果
     */
    @ApiOperation(value = "保存一条时间段的记录", nickname = "saveSugarTime", notes = "保存或更新一条血糖用药记录")
    @PostMapping("/saveSugarTime")
    public ResultVO saveSugarTime(@ApiParam(value = "药品对象", required = true) @RequestBody BloodSugarMedications bloodSugarMedications) {
        try {
            // 根据套餐ID判断是更新还是保存
            return (bloodSugarMedications.getId() != null) ? updateCreditPackage(bloodSugarMedications) : insertCreditPackage(bloodSugarMedications);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }

    /**
     * 更新一条药品记录
     *
     * @param bloodSugarMedications 药品对象
     * @return 返回更新结果
     */
    private ResultVO updateCreditPackage(BloodSugarMedications bloodSugarMedications) {
        bloodSugarMedications.setCreateTime(new Date());
        int i = bloodSugarMedicationsMapper.updateByPrimaryKeySelective(bloodSugarMedications);
        return (i > 0) ? ResultVOUtil.success("修改成功") : ResultVOUtil.error("修改失败");
    }

    /**
     * 保存一条血糖药品
     *
     * @param bloodSugarMedications 药品对象
     * @return 返回保存结果
     */
    private ResultVO insertCreditPackage(BloodSugarMedications bloodSugarMedications) {
        bloodSugarMedications.setIsDelete("0");
        bloodSugarMedications.setCreateTime(new Date());
        int i = bloodSugarMedicationsMapper.insertSelective(bloodSugarMedications);
        return (i > 0) ? ResultVOUtil.success("保存成功") : ResultVOUtil.error("保存失败");
    }


    /**
     * 根据ID查询一条药品记录
     *
     * @param id 药品主键ID
     * @return 返回查询结果，如果查询成功，返回血糖时段记录；如果查询失败，返回错误信息。
     */
    @ApiOperation(value = "根据id查询一条数据", nickname = "selectSugarTimeById", notes = "根据id查询一条数据")
    @GetMapping("selectSugarTimeById")
    public ResultVO selectSugarTimeById(@ApiParam(name = "id", value = "主键", required = true) @RequestParam("id") Integer id) {
        try {
            // ID合法性校验
            if (id == null || !isNumeric(id.toString())) {
                return ResultVOUtil.error("主键ID不合法");
            }
            BloodSugarMedications bloodSugarMedications = bloodSugarMedicationsMapper.selectByPrimaryKey(id);
            if (bloodSugarMedications == null) {
                return ResultVOUtil.error("记录不存在");
            }
            return ResultVOUtil.success(bloodSugarMedications);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }

    /**
     * 检查字符串是否是数字
     *
     * @param str 需要检查的字符串
     * @return 如果是数字返回true，否则返回false
     */
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    /**
     * 批量删除药品记录
     *
     * @param ids 待删除记录的主键ID序列，以字符串形式表示，各ID之间用逗号分隔。
     * @return 返回操作结果，如果操作成功，返回成功信息；如果操作失败，返回错误信息。
     */
    @ApiOperation(value = "批量删除", nickname = "deleteSugarTime", notes = "批量删除")
    @DeleteMapping("/deleteSugarTime")
    public ResultVO deleteSugarTime(@ApiParam(name = "ids", value = "主键字符串的形式", required = true) @RequestParam("ids") String ids) {
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
            totalDeleted += bloodSugarMedicationsMapper.deleteByPrimaryKey(id);
        }
        return totalDeleted;
    }

}
