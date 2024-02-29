package com.trust.xfyl.controller;

import com.trust.xfyl.dao.TrackingPersonnelMapper;
import com.trust.xfyl.dao.TrustFileMapper;
import com.trust.xfyl.dao.TrustRelationFileMapper;
import com.trust.xfyl.entity.*;
import com.trust.xfyl.enums.PhotoEnum;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.service.FileService;
import com.trust.xfyl.service.TrackingPersonnelService;
import com.trust.xfyl.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author LENOVO
 */
@Api(value = "跟踪人员档案建立", description = "跟踪人员档案建立", tags = "跟踪人员档案建立")
@RestController
@RequestMapping("/trackingPersonnel")
public class TrackingPersonnelController {

    private final TrackingPersonnelMapper trackingPersonnelMapper;
    private final TrackingPersonnelService trackingPersonnelService;
    private final FileService fileService;
    private final TrustFileMapper trustFileMapper;
    private final TrustRelationFileMapper trustRelationFileMapper;


    public TrackingPersonnelController(TrackingPersonnelMapper trackingPersonnelMapper, TrackingPersonnelService trackingPersonnelService, FileService fileService, TrustFileMapper trustFileMapper, TrustRelationFileMapper trustRelationFileMapper) {
        this.trackingPersonnelMapper = trackingPersonnelMapper;
        this.trackingPersonnelService = trackingPersonnelService;
        this.fileService = fileService;
        this.trustFileMapper = trustFileMapper;
        this.trustRelationFileMapper = trustRelationFileMapper;

    }


    @ApiOperation(value = "所有患者档案查询", notes = "所有患者档案查询")
    @PostMapping("/selectTrackingPersonnelAll")
    public ResultVO selectTrackingPersonnelAll(@ApiParam(value = "患者档案对象", required = true) @RequestBody TrackingPersonnel trackingPersonnel) {
        try {
            JSONObject returnPage = new JSONObject();
            Map<String, Object> returnMap = new HashMap<String, Object>();
            TrackingPersonnelExample trackingPersonnelExample = new TrackingPersonnelExample();
            if (!"null".equals(trackingPersonnel.getName()) && trackingPersonnel.getName() != null) {
                trackingPersonnelExample.createCriteria().andNameLike(trackingPersonnel.getName());
            }
            if (!"null".equals(trackingPersonnel.getOperationName()) && trackingPersonnel.getOperationName() != null) {
                trackingPersonnelExample.createCriteria().andOperationNameLike(trackingPersonnel.getOperationName());
            }
            trackingPersonnelExample.setStart((trackingPersonnel.getPage() - 1) * trackingPersonnel.getCount());
            trackingPersonnelExample.setEnd(trackingPersonnel.getCount());
            Long count1 = trackingPersonnelMapper.count(trackingPersonnelExample);
            List<TrackingPersonnel> trackingPersonnels = trackingPersonnelMapper.selectByExample(trackingPersonnelExample);
            returnPage.put("totalCount", count1);
            returnPage.put("page", trackingPersonnel.getPage());
            returnPage.put("count", trackingPersonnel.getCount());
            returnMap.put("page", returnPage);
            returnMap.put("msg", "success");
            returnMap.put("data", trackingPersonnels);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }

    }

    @ApiOperation(value = "保存一条患者的信息", nickname = "saveTrackingPersonnel", notes = "保存一条患者的信息")
    @PostMapping("/saveTrackingPersonnel")
    public ResultVO saveTrackingPersonnel(@ApiParam(value = "患者档案对象", required = true) @RequestBody TrackingPersonnel trackingPersonnel) {
        try {
            if (trackingPersonnel.getId() != null) {
                Long updateByPrimaryKey = trackingPersonnelService.updateByPrimaryKeySelective(trackingPersonnel);
                if (updateByPrimaryKey > 0 && (trackingPersonnel.getFileId() != null)) {
                    Long id = trackingPersonnel.getId();
                    TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
                    trustRelationFileExample.createCriteria().andBusiTypeEqualTo("trackingPersonne").andBusiIdEqualTo(String.valueOf(id));
                    List<TrustRelationFile> trustRelationFiles = trustRelationFileMapper.selectByExample(trustRelationFileExample);
                    if (trustRelationFiles.size() > 0) {
                        for (int i1 = 0; i1 < trustRelationFiles.size(); i1++) {
                            TrustRelationFile trustRelationFile = trustRelationFiles.get(i1);
                            TrustRelationFileExample trustRelationFileExample1 = new TrustRelationFileExample();
                            trustRelationFileExample1.createCriteria().andBusiIdEqualTo(trustRelationFile.getBusiId()).andBusiTypeEqualTo("trackingPersonne");
                            trustRelationFileMapper.deleteByExample(trustRelationFileExample1);
                        }
                    }
                    TrustRelationFile trustRelationFile = new TrustRelationFile();
                    trustRelationFile.setFileId(trackingPersonnel.getFileId());
                    trustRelationFile.setBusiType("trackingPersonne");
                    trustRelationFile.setBusiId(updateByPrimaryKey + "");
                    trustRelationFile.setPhotoType(PhotoEnum.One.getMessage());
                    boolean b = fileService.addFileRela(trustRelationFile);

                }
                if (updateByPrimaryKey > 0) {
                    return ResultVOUtil.success();
                } else {
                    return ResultVOUtil.error("修改失败");
                }
            } else {
                trackingPersonnel.setCreatTime(new Date());
                Long insert = trackingPersonnelService.insertSelective(trackingPersonnel);
                if (insert != null && (trackingPersonnel.getFileId() != null)) {
                    TrustRelationFile trustRelationFile = new TrustRelationFile();
                    trustRelationFile.setFileId(trackingPersonnel.getFileId());
                    trustRelationFile.setBusiType("trackingPersonne");
                    trustRelationFile.setBusiId(insert + "");
                    trustRelationFile.setPhotoType(PhotoEnum.One.getMessage());
                    fileService.addFileRela(trustRelationFile);
                }
                if (insert != null) {
                    return ResultVOUtil.success();
                } else {
                    return ResultVOUtil.error("添加失败");
                }

            }

        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            return ResultVOUtil.error(-1, e.getMessage());
        }
    }


    @ApiOperation(value = "批量删除", nickname = "deleteTrackingPersonnel", notes = "批量删除")
    @GetMapping("/deleteTrackingPersonnel")
    public ResultVO deleteTrackingPersonnel(@ApiParam(name = "ids", value = "主键字符串的形式", required = true) @RequestParam("ids") String ids) {
        try {
            int i1 = 0;
            String[] Split = ids.split(",");
            for (int i = 0; i < Split.length; i++) {
                String s = Split[i];
                Long aLong = Long.valueOf(s);
                i1 = trackingPersonnelMapper.deleteByPrimaryKey(aLong);
                TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
                trustRelationFileExample.createCriteria().andBusiIdEqualTo(s).andBusiTypeEqualTo("trackingPersonne");
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

    @ApiOperation(value = "查询一条患者的信息根据主键or病例号", nickname = "selectTrackingPersonnelById", notes = "查询一条患者的信息根据主键or病例号")
    @PostMapping("selectTrackingPersonnelById")
    public ResultVO selectTrackingPersonnelById(@ApiParam(value = "患者档案对象", required = true) @RequestBody TrackingPersonnel trackingPersonnel) {
        try {
            List<TrustFile> trustFiles = new ArrayList<TrustFile>();
            TrackingPersonnel trackingPersonnel1 = null;
            Map<String, Object> returnMap = new HashMap<>();
            if (!"null".equals(trackingPersonnel.getMedicalNumber()) && trackingPersonnel.getMedicalNumber() != null) {
                TrackingPersonnelExample trackingPersonnelExample = new TrackingPersonnelExample();
                trackingPersonnelExample.createCriteria().andMedicalNumberEqualTo(trackingPersonnel.getMedicalNumber());
                List<TrackingPersonnel> trackingPersonnels = trackingPersonnelMapper.selectByExample(trackingPersonnelExample);
                trackingPersonnel1 = trackingPersonnels.get(0);
            } else {
                trackingPersonnel1 = trackingPersonnelMapper.selectByPrimaryKey(Long.valueOf(trackingPersonnel.getId()));
            }
            TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
            trustRelationFileExample.createCriteria().andBusiIdEqualTo(String.valueOf(trackingPersonnel1.getId()))
                    .andBusiTypeEqualTo("trackingPersonne");
            List<TrustRelationFile> tlRelationFiles = trustRelationFileMapper.selectByExample(trustRelationFileExample);
            if (tlRelationFiles.size() > 0) {
                for (int i = 0; i < tlRelationFiles.size(); i++) {
                    TrustFile trustFile = trustFileMapper.selectByPrimaryKey(Integer.valueOf(tlRelationFiles.get(i).getFileId()));
                    trustFiles.add(trustFile);
                }
            }

            returnMap.put("file", trustFiles);
            returnMap.put("tlRelationFiles", tlRelationFiles);
            returnMap.put("trackingPersonnel", trackingPersonnel1);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }
    }


}
