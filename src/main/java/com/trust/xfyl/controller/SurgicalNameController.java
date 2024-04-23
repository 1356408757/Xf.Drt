package com.trust.xfyl.controller;


import com.trust.xfyl.dao.SurgicalNameMapper;
import com.trust.xfyl.entity.ResultVO;
import com.trust.xfyl.entity.SurgicalName;
import com.trust.xfyl.entity.SurgicalNameExample;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @Description
 * @author Bay-max
 * @date 2024/4/22 15:19
 **/

@Api(value = "手术名称和围手术名称模板", description = "手术名称和围手术名称模板", tags = "手术名称和围手术名称模板")
@RestController
@RequestMapping("/SurgicalName")
public class SurgicalNameController {
    private final SurgicalNameMapper surgicalNameMapper;

    public SurgicalNameController(SurgicalNameMapper surgicalNameMapper) {
        this.surgicalNameMapper = surgicalNameMapper;
    }

    /**
     * @return com.trust.xfyl.entity.ResultVO
     * @Author djj
     * @Description 根据级别获取手术名称活围手术名称模板的数据
     * @Date 15:19 2024/1/25
     * @Param [surgicalName]
     **/
    @ApiOperation(value = "获取列表", nickname = "selectSurgicalNameAll", notes = "获取列表")
    @PostMapping("/selectSurgicalNameAll")
    public ResultVO selectSurgicalNameAll(@ApiParam(value = "手术名称和围手术名称模板对象", required = true) @RequestBody SurgicalName surgicalName) {
        try {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            SurgicalNameExample surgicalNameExample = new SurgicalNameExample();
            if (surgicalName.getLevel() != null) {
                surgicalNameExample.createCriteria().andLevelEqualTo(surgicalName.getLevel());
            }
            List<SurgicalName> surgicalNames = surgicalNameMapper.selectByExample(surgicalNameExample);
            returnMap.put("msg", "success");
            returnMap.put("data", surgicalNames);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }

    }

    /**
     * @return com.trust.xfyl.entity.ResultVO
     * @Author djj
     * @Description 根据前端传过来的id是否为null来判断是新增还是修改。
     * @Date 15:41 2024/1/25
     * @Param [surgicalName]
     **/
    @ApiOperation(value = "保存一条手术名称和围手术名称的数据", nickname = "saveSurgicalName", notes = "保存一条手术名称和围手术名称的数据")
    @PostMapping("/saveSurgicalName")
    public ResultVO saveSurgicalName(@ApiParam(value = "手术名称和围手术名称模板对象", required = true) @RequestBody SurgicalName surgicalName) {
        try {
            if (surgicalName.getId() != null) {
                surgicalName.setUpdateTime(new Date());
                int i = surgicalNameMapper.updateByPrimaryKeySelective(surgicalName);
                if (i > 0) {
                    return ResultVOUtil.success("保存成功");
                } else {
                    return ResultVOUtil.error("保存失败");
                }
            } else {
                surgicalName.setCreateTime(new Date());
                surgicalName.setIsDelete(0);
                int i = surgicalNameMapper.insertSelective(surgicalName);
                if (i > 0) {
                    return ResultVOUtil.success("保存成功");
                } else {
                    return ResultVOUtil.error("保存失败");
                }
            }
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            return ResultVOUtil.error(-1, e.getMessage());
        }
    }

    /**
     * @return com.trust.xfyl.entity.ResultVO
     * @Author djj
     * @Description 批量删除，根据传过来的ids来删除数据。
     * @Date 15:51 2024/1/25
     * @Param [surgicalName]
     **/

    @ApiOperation(value = "批量删除", nickname = "deleteSurgicalName", notes = "批量删除")
    @GetMapping("/deleteSurgicalName")
    public ResultVO deleteSurgicalName(@ApiParam(name = "ids", value = "主键字符串的形式", required = true) @RequestParam("ids") String ids) {
        try {
            int i2 = 0;
            String[] Split = ids.split(",");
            for (int i = 0; i < Split.length; i++) {
                String s = Split[i];
                i2 = surgicalNameMapper.deleteByPrimaryKey(Long.valueOf(s));
            }
            if (i2 > 0) {
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


    @ApiOperation(value = "根据id查询一条数据", nickname = "selectSurgicalNameById", notes = "根据id查询一条数据")
    @GetMapping("selectSurgicalNameById")
    public ResultVO selectSurgicalNameById(@ApiParam(name = "id", value = "主键", required = true) @RequestParam("id") Long id) {
        try {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            SurgicalName surgicalName1 = surgicalNameMapper.selectByPrimaryKey(id);
            returnMap.put("SurgicalName", surgicalName1);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }
    }
}
