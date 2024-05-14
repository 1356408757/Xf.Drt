package com.trust.xfyl.controller;

import com.trust.xfyl.dao.FoodSugarMapper;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.model.ResultVO;
import com.trust.xfyl.model.ResultVOUtil;
import com.trust.xfyl.model.po.FoodSugar;
import com.trust.xfyl.model.po.FoodSugarExample;
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
 * 食物糖分基础数据控制器
 *
 * @author Bay-max
 * @Description
 * @date 2024/5/14 16:04
 */
@Api(value = "食物糖分基础数据", description = "食物糖分基础数据接口", tags = "食物糖分基础数据")
@RestController
@RequestMapping("/foodSugar")
public class FoodSugarController {
    private final static Logger logger = LoggerFactory.getLogger(FoodSugarController.class);
    private final FoodSugarMapper foodSugarMapper;

    /**
     * 构造函数
     *
     * @param foodSugarMapper 食物糖分数据访问对象
     */
    public FoodSugarController(FoodSugarMapper foodSugarMapper) {
        this.foodSugarMapper = foodSugarMapper;
    }

    /**
     * 获取食物糖分列表
     *
     * @param foodSugar 包含查询条件和分页信息的食物糖分对象
     * @param request   HTTP请求对象
     * @return 返回查询结果的ResultVO对象
     */
    @PostMapping("/selectFoodSugarList")
    @ApiOperation(value = "获取食物糖分列表", nickname = "selectFoodSugarList", notes = "根据条件获取食物糖分列表")
    public ResultVO selectFoodSugarList(@ApiParam(value = "查询条件和分页信息", required = true) @RequestBody @Valid FoodSugar foodSugar, HttpServletRequest request) {
        try {
            // 校验分页参数
            if (foodSugar.getPage() == null || foodSugar.getCount() == null || foodSugar.getPage() <= 0 || foodSugar.getCount() <= 0) {
                return ResultVOUtil.error("分页参数不合法");
            }
            Map<String, Object> returnMap = new HashMap<>();
            FoodSugarExample foodSugarExample = new FoodSugarExample();
            // 设置查询条件
            if (foodSugar.getFoodName() != null) {
                foodSugarExample.createCriteria().andFoodNameEqualTo(foodSugar.getFoodName());
            }

            foodSugarExample.createCriteria().andIsDeleteEqualTo("0");
            // 设置分页参数
            foodSugarExample.setStart((foodSugar.getPage() - 1) * foodSugar.getCount());
            foodSugarExample.setEnd(foodSugar.getCount());
            // 执行查询
            List<FoodSugar> foodSugarLists = foodSugarMapper.selectByExample(foodSugarExample);
            Long count = foodSugarMapper.count(foodSugarExample);
            Map<String, Object> returnPage = new HashMap<>();
            returnPage.put("totalCount", count);
            returnPage.put("page", foodSugar.getPage());
            returnPage.put("count", foodSugar.getCount());
            returnMap.put("returnPage", returnPage);
            returnMap.put("msg", "success");
            returnMap.put("foodSugarLists", foodSugarLists);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching food sugar: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }



    /**
     * 保存或更新一条食物糖分记录
     *
     * @param foodSugar 食物糖分对象
     * @return 返回保存或更新结果
     */
    @ApiOperation(value = "保存一条食物糖分记录", nickname = "saveFoodSugar", notes = "根据ID判断是更新还是保存食物糖分记录")
    @PostMapping("/saveFoodSugar")
    public ResultVO saveFoodSugar(@ApiParam(value = "食物糖分对象", required = true) @RequestBody FoodSugar foodSugar) {
        try {
            // 根据ID判断是更新还是保存
            return (foodSugar.getFoodId() != null) ? updateCreditPackage(foodSugar) : insertCreditPackage(foodSugar);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching doctor: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }

    /**
     * 更新一条食物糖分记录
     *
     * @param foodSugar 食物糖分对象
     * @return 返回更新结果
     */
    private ResultVO updateCreditPackage(FoodSugar foodSugar) {
        foodSugar.setCreateTime(new Date());
        int i = foodSugarMapper.updateByPrimaryKeySelective(foodSugar);
        return (i > 0) ? ResultVOUtil.success("修改成功") : ResultVOUtil.error("修改失败");
    }

    /**
     * 保存一条食物糖分记录
     *
     * @param foodSugar 食物糖分对象
     * @return 返回保存结果
     */
    private ResultVO insertCreditPackage(FoodSugar foodSugar) {
        foodSugar.setIsDelete("0");
        foodSugar.setCreateTime(new Date());
        int i = foodSugarMapper.insertSelective(foodSugar);
        return (i > 0) ? ResultVOUtil.success("保存成功") : ResultVOUtil.error("保存失败");
    }

    /**
     * 根据ID查询一条食物糖分记录
     *
     * @param id 食物糖分的主键
     * @return 返回查询结果
     */
    @ApiOperation(value = "根据id查询一条数据", nickname = "selectFoodSugarById", notes = "根据id查询一条数据")
    @GetMapping("selectFoodSugarById")
    public ResultVO selectFoodSugarById(@ApiParam(name = "id", value = "主键", required = true) @RequestParam("id") Integer id) {
        try {
            // ID合法性校验
            if (id == null || !isNumeric(id.toString())) {
                return ResultVOUtil.error("主键ID不合法");
            }
            FoodSugar foodSugar = foodSugarMapper.selectByPrimaryKey(id);
            if (foodSugar == null) {
                return ResultVOUtil.error("记录不存在");
            }
            return ResultVOUtil.success(foodSugar);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching doctor: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
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


    @ApiOperation(value = "批量删除", nickname = "deleteFoodSugar", notes = "批量删除")
    @DeleteMapping("/deleteFoodSugar")
    public ResultVO deleteFoodSugar(@ApiParam(name = "ids", value = "主键字符串的形式", required = true) @RequestParam("ids") String ids) {
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
            logger.error("Error fetching doctor: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
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
        // 假设这里有实现批量删除的逻辑
        for (int id : idsArray) {
            totalDeleted += foodSugarMapper.deleteByPrimaryKey(id);
        }
        return totalDeleted;
    }
}
