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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


}
