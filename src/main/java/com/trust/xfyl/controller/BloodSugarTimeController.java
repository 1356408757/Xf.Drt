package com.trust.xfyl.controller;

import com.trust.xfyl.dao.BloodSugarTimeMapper;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.model.ResultVO;
import com.trust.xfyl.model.ResultVOUtil;
import com.trust.xfyl.model.po.BloodSugarTime;
import com.trust.xfyl.model.po.BloodSugarTimeExample;
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
 * TODO
 *
 * @author Bay-max
 * @Description
 * @date 2024/5/14 16:28
 **/
@Api(value = "血糖时间段控制器", description = "血糖时间段控制器", tags = "血糖时间段控制器")
@RestController
@RequestMapping("/sugarTime")
public class BloodSugarTimeController {
    // 日志记录器
    private final static Logger logger = LoggerFactory.getLogger(BloodSugarTimeController.class);
    // 血糖时间数据映射器
    private final BloodSugarTimeMapper bloodSugarTimeMapper;

    /**
     * 血糖时间控制器构造函数
     *
     * @param bloodSugarTimeMapper 血糖时间数据映射器接口的实例
     */
    public BloodSugarTimeController(BloodSugarTimeMapper bloodSugarTimeMapper) {
        this.bloodSugarTimeMapper = bloodSugarTimeMapper;
    }

    /**
     * 获取血糖时间段列表
     *
     * @param bloodSugarTime 血糖时间段对象，包含查询条件
     * @param request        HTTP请求对象
     * @return 血糖时间段列表的结果对象
     */
    @PostMapping("/selectSugarTimes")
    @ApiOperation(value = "获取血糖时间段列表", nickname = "selectSugarTimes", notes = "获取血糖时间段列表")
    public ResultVO selectSugarTimes(@ApiParam(value = "bloodSugarTime", required = true) @RequestBody @Valid BloodSugarTime bloodSugarTime, HttpServletRequest request) {

        try {
            BloodSugarTimeExample bloodSugarTimeExample = new BloodSugarTimeExample();
            bloodSugarTimeExample.createCriteria().andIsDeleteEqualTo("0");

            List<BloodSugarTime> bloodSugarTimes = bloodSugarTimeMapper.selectByExample(bloodSugarTimeExample);
            return ResultVOUtil.success(bloodSugarTimes);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching blood sugar times: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }


    /**
     * 保存或更新一条血糖时段记录
     *
     * @param bloodSugarTime 血糖时段对象
     * @return 返回保存或更新结果
     */
    @ApiOperation(value = "保存一条时间段的记录", nickname = "saveSugarTime", notes = "保存一条时间段的记录")
    @PostMapping("/saveSugarTime")
    public ResultVO saveSugarTime(@ApiParam(value = "字典表对象", required = true) @RequestBody BloodSugarTime bloodSugarTime) {
        try {
            // 根据套餐ID判断是更新还是保存
            return (bloodSugarTime.getId() != null) ? updateCreditPackage(bloodSugarTime) : insertCreditPackage(bloodSugarTime);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", e.getMessage(), e);
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            logger.error("Error saving blood sugar time: {}", e.getMessage(), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }

    /**
     * 更新一条血糖时段记录
     *
     * @param bloodSugarTime 血糖时段对象
     * @return 返回更新结果
     */
    private ResultVO updateCreditPackage(BloodSugarTime bloodSugarTime) {
        bloodSugarTime.setCreateTime(new Date());
        int i = bloodSugarTimeMapper.updateByPrimaryKeySelective(bloodSugarTime);
        return (i > 0) ? ResultVOUtil.success("修改成功") : ResultVOUtil.error("修改失败");
    }

    /**
     * 保存一条血糖时段记录
     *
     * @param bloodSugarTime 血糖时段对象
     * @return 返回保存结果
     */
    private ResultVO insertCreditPackage(BloodSugarTime bloodSugarTime) {
        bloodSugarTime.setIsDelete("0");
        bloodSugarTime.setCreateTime(new Date());
        int i = bloodSugarTimeMapper.insertSelective(bloodSugarTime);
        return (i > 0) ? ResultVOUtil.success("保存成功") : ResultVOUtil.error("保存失败");
    }


    /**
     * 根据ID查询一条血糖时段记录
     *
     * @param id 血糖时段记录的主键ID
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
            BloodSugarTime bloodSugarTime = bloodSugarTimeMapper.selectByPrimaryKey(id);
            if (bloodSugarTime == null) {
                return ResultVOUtil.error("记录不存在");
            }
            return ResultVOUtil.success(bloodSugarTime);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", e.getMessage(), e);
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            logger.error("Error fetching blood sugar time by ID: {}", e.getMessage(), e);
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
     * 批量删除血糖时段记录
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
            // 处理业务层异常，返回对应的错误信息
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            // 记录未捕获的异常信息，并返回服务器内部错误信息
            logger.error("Error deleting sugar time records: {}", e.getMessage(), e);
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
            totalDeleted += bloodSugarTimeMapper.deleteByPrimaryKey(id);
        }
        return totalDeleted;
    }

}
