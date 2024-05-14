package com.trust.xfyl.controller;

import com.trust.xfyl.dao.CreditPackagesMapper;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.model.ResultVO;
import com.trust.xfyl.model.ResultVOUtil;
import com.trust.xfyl.model.po.CreditPackages;
import com.trust.xfyl.model.po.CreditPackagesExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 套餐卡的CRUD操作控制器
 *
 * @author Bay-max
 * @date 2024/4/23 10:32
 **/
@Api(value = "次卡管理", description = "次卡管理", tags = "次卡管理")
@RestController
@RequestMapping("/cre")
public class CreditPackageController {
    private final static Logger logger = LoggerFactory.getLogger(CreditPackageController.class);
    private final CreditPackagesMapper creditPackagesMapper;

    /**
     * 构造函数，初始化套餐卡数据操作接口
     *
     * @param creditPackagesMapper 套餐卡数据操作接口
     */
    public CreditPackageController(CreditPackagesMapper creditPackagesMapper) {
        this.creditPackagesMapper = creditPackagesMapper;
    }

    /**
     * 获取套餐列表
     *
     * @param creditPackages 套餐参数对象，包含分页信息和查询条件
     * @return 返回套餐列表查询结果
     */
    @ApiOperation(value = "获取套餐列表", nickname = "v1", notes = "获取套餐列表")
    @PostMapping("/v1")
    public ResultVO selectCreditPackagesList(@ApiParam(value = "套餐对象", required = true) @RequestBody @Valid CreditPackages creditPackages) {
        try {
            // 分页参数校验
            if (creditPackages.getPage() == null || creditPackages.getCount() == null || creditPackages.getPage() <= 0 || creditPackages.getCount() <= 0) {
                return ResultVOUtil.error("分页参数不合法");
            }

            // 查询并返回套餐列表
            Map<String, Object> returnMap = new HashMap<>();
            CreditPackagesExample creditPackagesExample = new CreditPackagesExample();
            if (creditPackages.getPackageName() != null) {
                creditPackagesExample.createCriteria().andPackageNameEqualTo(creditPackages.getPackageName());
            }
            creditPackagesExample.createCriteria().andIsDeleteEqualTo(0);
            creditPackagesExample.setStart((creditPackages.getPage() - 1) * creditPackages.getCount());
            creditPackagesExample.setEnd(creditPackages.getCount());
            List<CreditPackages> creditPackagesLists = creditPackagesMapper.selectByExample(creditPackagesExample);
            System.out.println(creditPackagesLists.get(0).getPrice());
            Long count = creditPackagesMapper.count(creditPackagesExample);
            Map<String, Object> returnPage = new HashMap<>();
            returnPage.put("totalCount", count);
            returnPage.put("page", creditPackages.getPage());
            returnPage.put("count", creditPackages.getCount());
            returnMap.put("returnPage", returnPage);
            returnMap.put("msg", "success");
            returnMap.put("cardPackages", creditPackagesLists);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching credit packages: {}", sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }
    /**
     * 清理错误信息，将错误信息分为错误类型和堆栈信息，并对堆栈信息进行简化和敏感信息替换。
     *
     * @param errorMessage 原始错误信息，格式为“错误类型: 堆栈信息”。
     * @return 清理后的错误信息，包含错误类型和简化、脱敏后的堆栈信息。
     */
    private String sanitizeErrorMessage(String errorMessage) {
        // 分割错误信息为错误类型和堆栈信息
        String[] errorParts = errorMessage.split(": ", 2);
        String errorType = errorParts[0];
        String stackTrace = errorParts.length > 1 ? errorParts[1] : "";
        // 初始化用于存储清理后的堆栈信息的StringBuilder
        // 定义最大堆栈行数
        int maxStackTraceLines = 5;
        String[] stackTraceLines = stackTrace.split("\n");
        StringBuilder sanitizedStackTrace = new StringBuilder();
        for (int i = 0; i < Math.min(stackTraceLines.length, maxStackTraceLines); i++) {
            // 对每行堆栈信息进行敏感信息替换
            String line = stackTraceLines[i];
            sanitizedStackTrace.append(line.replaceAll("(?i)jdbc:mysql://.*@", "jdbc:mysql://****@"))
                    .append("\n");
        }
        // 如果堆栈信息超过最大行数，追加省略号
        if (stackTraceLines.length > maxStackTraceLines) {
            sanitizedStackTrace.append("...\n");
        }
        // 返回错误类型和清理后的堆栈信息
        return errorType + ": " + sanitizedStackTrace;
    }
    /**
     * 保存或更新一条套餐信息
     *
     * @param creditPackages 套餐信息对象
     * @return 返回保存或更新结果
     */
    @ApiOperation(value = "保存一条数据", nickname = "saveCre", notes = "保存一条数据")
    @PostMapping("/saveCre")
    public ResultVO saveCre(@ApiParam(value = "套餐对象", required = true) @RequestBody CreditPackages creditPackages) {
        try {
            // 根据套餐ID判断是更新还是保存
            return (creditPackages.getPackageId() != null) ? updateCreditPackage(creditPackages) : insertCreditPackage(creditPackages);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            logger.error("Error saving credit package: {}", e.getMessage());
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }

    /**
     * 更新一条套餐信息
     *
     * @param creditPackages 套餐信息对象
     * @return 返回更新结果
     */
    private ResultVO updateCreditPackage(CreditPackages creditPackages) {
        int i = creditPackagesMapper.updateByPrimaryKeySelective(creditPackages);
        return (i > 0) ? ResultVOUtil.success("修改成功") : ResultVOUtil.error("修改失败");
    }

    /**
     * 保存一条新的套餐信息
     *
     * @param creditPackages 套餐信息对象
     * @return 返回保存结果
     */
    private ResultVO insertCreditPackage(CreditPackages creditPackages) {
        creditPackages.setIsDelete(0);
        creditPackages.setCreateTime(new Date());
        int i = creditPackagesMapper.insertSelective(creditPackages);
        return (i > 0) ? ResultVOUtil.success("保存成功") : ResultVOUtil.error("保存失败");
    }

    /**
     * 根据ID查询一条套餐信息
     *
     * @param packageId 套餐的主键ID
     * @return 返回查询结果
     */
    @ApiOperation(value = "根据id查询一条数据", nickname = "selectCre", notes = "根据id查询一条数据")
    @GetMapping("selectCre")
    public ResultVO selectCre(@ApiParam(name = "packageId", value = "主键", required = true) @RequestParam("packageId") Integer packageId) {
        try {
            // ID合法性校验
            if (packageId == null) {
                return ResultVOUtil.error("主键ID不能为空");
            }
            CreditPackages creditPackages = creditPackagesMapper.selectByPrimaryKey(packageId);
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("creditPackages", creditPackages);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        } catch (Exception e) {
            logger.error("Error fetching credit package by ID: {}", e.getMessage());
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }

    /**
     * 批量删除信用套餐
     *
     * @param ids 主键字符串的形式，需传入待删除记录的主键ID，多个ID之间用逗号分隔，不能为空
     * @return 返回操作结果，成功则返回操作成功的消息，失败则返回错误消息；如果出现异常，返回对应的错误信息或服务器内部错误信息
     */
    @ApiOperation(value = "批量删除", nickname = "deleteCreditPackages", notes = "批量删除")
    @DeleteMapping("/deleteCreditPackages")
    public ResultVO deleteCreditPackages(@ApiParam(name = "ids", value = "主键字符串的形式", required = true) @RequestParam("ids") String ids) {
        try {
            // 判断传入的待删除ID是否为空
            if (ids == null || ids.isEmpty()) {
                return ResultVOUtil.error("待删除ID不能为空");
            }
            // 记录总共删除成功的记录数
            int totalDeleted = 0;
            // 按逗号分割待删除的ID字符串
            String[] split = ids.split(",");

            // 遍历分割后的ID数组，验证并尝试删除每个ID对应的记录
            for (String s : split) {
                if (s.matches("\\d+")) {
                    totalDeleted += creditPackagesMapper.deleteByPrimaryKey(Integer.valueOf(s));
                }
            }

            // 根据删除成功的记录数，返回对应的操作结果
            return (totalDeleted > 0) ? ResultVOUtil.success("操作成功") : ResultVOUtil.error("操作失败");
        } catch (SCServiceException e) {
            // 处理业务层异常，返回对应的错误信息
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            // 记录未捕获的异常信息，并返回服务器内部错误信息
            logger.error("Error deleting credit packages: {}", e.getMessage());
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }
}
