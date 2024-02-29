package com.trust.xfyl.controller;

import com.trust.xfyl.dao.TrustFileMapper;
import com.trust.xfyl.dao.TrustRelationFileMapper;
import com.trust.xfyl.dao.WoundFollowMapper;
import com.trust.xfyl.entity.*;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.service.FileService;
import com.trust.xfyl.service.WoundFollowService;
import com.trust.xfyl.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Author djj
 * @Description //TODO
 * @Date 11:15 2024/1/26
 **/
@Api(value = "患者随访", description = "患者随访", tags = "患者随访")
@RestController
@RequestMapping("/WoundFollow")
public class WoundFollowController {
    private final WoundFollowMapper woundFollowMapper;
    private final FileService fileService;
    private final TrustRelationFileMapper trustRelationFileMapper;
    private final WoundFollowService woundFollowService;
    private final TrustFileMapper trustFileMapper;

    public WoundFollowController(WoundFollowMapper woundFollowMapper, FileService fileService, TrustRelationFileMapper trustRelationFileMapper, WoundFollowService woundFollowService, TrustFileMapper trustFileMapper) {
        this.woundFollowMapper = woundFollowMapper;
        this.fileService = fileService;
        this.trustRelationFileMapper = trustRelationFileMapper;
        this.woundFollowService = woundFollowService;
        this.trustFileMapper = trustFileMapper;
    }


    @ApiOperation(value = "患者随访列表", nickname = "selectWoundFollowAll", notes = "患者随访列表")
    @PostMapping("/selectWoundFollowAll")
    public ResultVO selectWoundFollowAll(@ApiParam(value = "患者随访对象", required = true) @RequestBody WoundFollow woundFollow) {
        try {
            JSONObject returnPage = new JSONObject();
            Map<String, Object> returnMap = new HashMap<String, Object>();
            WoundFollowExample woundFollowExample = new WoundFollowExample();
            if (!"null".equals(woundFollow.getMedicalNumber()) && woundFollow.getMedicalNumber() != null) {
                woundFollowExample.createCriteria().andMedicalNumberEqualTo(woundFollow.getMedicalNumber());
            }
            if (!"null".equals(woundFollow.getDoctorName()) && woundFollow.getDoctorName() != null) {
                woundFollowExample.createCriteria().andDoctorNameEqualTo(woundFollow.getDoctorName());
            }
            if (woundFollow.getWoundShootingDate() != null) {
                woundFollowExample.createCriteria().andWoundShootingDateEqualTo(woundFollow.getWoundShootingDate());
            }
            if (!"null".equals(woundFollow.getPostoperativeStage()) && woundFollow.getPostoperativeStage() != null) {
                woundFollowExample.createCriteria().andPostoperativeStageEqualTo(woundFollow.getPostoperativeStage());
            }
            woundFollowExample.setStart((woundFollow.getPage() - 1) * woundFollow.getCount());
            woundFollowExample.setEnd(woundFollow.getCount());
            Long count1 = woundFollowMapper.count(woundFollowExample);
            List<WoundFollow> woundFollows = woundFollowMapper.selectByExample(woundFollowExample);
            returnPage.put("totalCount", count1);
            returnPage.put("page", woundFollow.getPage());
            returnPage.put("count", woundFollow.getCount());
            returnMap.put("page", returnPage);
            returnMap.put("msg", "success");
            returnMap.put("data", woundFollows);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }

    }

    @PostMapping
    @ApiOperation(value = "保存一条患者的信息", nickname = "saveWoundFollow", notes = "保存一条患者的信息")
    @RequestMapping("/saveWoundFollow")
    public ResultVO saveWoundFollow(@ApiParam(value = "患者随访对象", required = true) @RequestBody WoundFollow woundFollow) {
        try {
            if (woundFollow.getId() != null) {
                woundFollow.setUpdateTime(new Date());
                Long aLong = woundFollowService.updateByPrimaryKeySelective(woundFollow);
                if (aLong > 0 && (woundFollow.getFileId() != null)) {
                    Long woundFollowId = woundFollow.getId();
                    TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
                    trustRelationFileExample.createCriteria()
                            .andBusiTypeEqualTo("woundFollow")
                            .andBusiIdEqualTo(String.valueOf(woundFollowId));
                    List<TrustRelationFile> trustRelationFiles = trustRelationFileMapper.selectByExample(trustRelationFileExample);
                    if (trustRelationFiles.size() > 0) {
                        for (int i1 = 0; i1 < trustRelationFiles.size(); i1++) {
                            TrustRelationFile trustRelationFile = trustRelationFiles.get(i1);
                            TrustRelationFileExample trustRelationFileExample1 = new TrustRelationFileExample();
                            trustRelationFileExample1.createCriteria()
                                    .andBusiIdEqualTo(trustRelationFile.getBusiId())
                                    .andBusiTypeEqualTo("woundFollow");
                            trustRelationFileMapper.deleteByExample(trustRelationFileExample1);
                        }
                    }
                    TrustRelationFile trustRelationFile = new TrustRelationFile();
                    trustRelationFile.setFileId(woundFollow.getFileId());
                    trustRelationFile.setBusiType("woundFollow");
                    trustRelationFile.setBusiId(aLong + "");
                    trustRelationFile.setPhotoType(woundFollow.getPostoperativeStage());
                    boolean b = fileService.addFileRela(trustRelationFile);
                }
                if (aLong > 0) {
                    return ResultVOUtil.success();
                } else {
                    return ResultVOUtil.error("修改失败");
                }
            } else {
                WoundFollowExample woundFollowExample = new WoundFollowExample();
                if (woundFollow.getPostoperativeStage() != null) {
                    woundFollowExample.createCriteria().andPostoperativeStageEqualTo(woundFollow.getPostoperativeStage())
                            .andTrackingPersonnelIdEqualTo(woundFollow.getTrackingPersonnelId());
                }
                List<WoundFollow> woundFollows = woundFollowMapper.selectByExample(woundFollowExample);
                if (woundFollows.size() > 0) {
                    return ResultVOUtil.error("已经上传过:" + woundFollow.getPostoperativeStage() + "请不要重复上传");
                } else {
                    woundFollow.setCreateTime(new Date());
                    woundFollow.setIsDelete(0);
                    Long aLong = woundFollowService.insertSelective(woundFollow);
                    if (aLong != null && (woundFollow.getFileId() != null)) {
                        TrustRelationFile trustRelationFile = new TrustRelationFile();
                        trustRelationFile.setFileId(woundFollow.getFileId());
                        trustRelationFile.setBusiType("woundFollow");
                        trustRelationFile.setBusiId(aLong + "");
                        trustRelationFile.setPhotoType(woundFollow.getPostoperativeStage());
                        fileService.addFileRela(trustRelationFile);
                    }
                    if (aLong != null) {
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

    @ApiOperation(value = "批量删除", nickname = "deleteWoundFollow", notes = "批量删除")
    @GetMapping("/deleteWoundFollow")
    public ResultVO deleteWoundFollow(@ApiParam(name = "ids", value = "主键字符串的形式", required = true) @RequestParam("ids") String ids) {
        try {
            int i1 = 0;
            String[] Split = ids.split(",");
            for (int i = 0; i < Split.length; i++) {
                String s = Split[i];
                i1 = woundFollowMapper.deleteByPrimaryKey(Long.valueOf(s));
                TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
                trustRelationFileExample.createCriteria().andBusiIdEqualTo(s).andBusiTypeEqualTo("woundFollow");
                int i2 = trustRelationFileMapper.countByExample(trustRelationFileExample);
                if (i2 > 0) {
                    for (int j = 0; j < i2; j++) {
                        trustRelationFileMapper.deleteByExample(trustRelationFileExample);
                    }
                }
            }
            if (i1 > 0) {
                return ResultVOUtil.success();
            } else {
                return ResultVOUtil.error("失败");
            }
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            return ResultVOUtil.error(-1, e.getMessage());
        }
    }


    @ApiOperation(value = "获取患者随访详情", nickname = "selectWoundFollowById", notes = "获取患者随访详情")
    @GetMapping("selectWoundFollowById")
    public ResultVO selectWoundFollowById(@ApiParam(name = "id", value = "主键", required = true) @RequestParam("id") Long id) {
        try {
            List<TrustFile> list = new ArrayList<TrustFile>();
            Map<String, Object> returnMap = new HashMap<>();
            WoundFollow woundFollow1 = woundFollowMapper.selectByPrimaryKey(id);
            TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
            trustRelationFileExample.createCriteria().andBusiIdEqualTo(String.valueOf(id))
                    .andBusiTypeEqualTo("woundFollow");
            List<TrustRelationFile> tlRelationFiles = trustRelationFileMapper.selectByExample(trustRelationFileExample);
            if (tlRelationFiles.size() > 0) {
                for (int i = 0; i < tlRelationFiles.size(); i++) {
                    TrustFile trustFile = trustFileMapper.selectByPrimaryKey(Integer.valueOf(tlRelationFiles.get(i).getFileId()));
                    list.add(trustFile);
                }

            }
            returnMap.put("tlRelationFiles", tlRelationFiles);
            returnMap.put("file", list);
            returnMap.put("woundFollow", woundFollow1);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }
    }
}
