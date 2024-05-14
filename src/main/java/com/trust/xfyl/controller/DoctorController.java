package com.trust.xfyl.controller;

import com.trust.xfyl.dao.DoctorMapper;
import com.trust.xfyl.dao.TrustFileMapper;
import com.trust.xfyl.dao.TrustRelationFileMapper;
import com.trust.xfyl.enums.PhotoEnum;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.model.ResultVO;
import com.trust.xfyl.model.ResultVOUtil;
import com.trust.xfyl.model.po.*;
import com.trust.xfyl.service.impl.DoctorService;
import com.trust.xfyl.service.impl.FileService;
import com.trust.xfyl.util.ScExceptionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * TODO
 *
 * @author Bay-max
 * @Description
 * @date 2024/5/20 14:42
 **/

@Api(value = "医生控制器", description = "医生控制器", tags = "医生控制器")
@RestController
@RequestMapping("/Doctor")
public class DoctorController {
    private final static Logger logger = LoggerFactory.getLogger(DoctorController.class);
    private final DoctorMapper doctorMapper;
    private final DoctorService doctorService;
    private final FileService fileService;
    private final TrustRelationFileMapper trustRelationFileMapper;
    private final TrustFileMapper trustFileMapper;

    public DoctorController(DoctorMapper doctorMapper, DoctorService doctorService, FileService fileService, TrustRelationFileMapper trustRelationFileMapper, TrustFileMapper trustFileMapper) {
        this.doctorMapper = doctorMapper;
        this.doctorService = doctorService;
        this.fileService = fileService;
        this.trustRelationFileMapper = trustRelationFileMapper;
        this.trustFileMapper = trustFileMapper;
    }

    /**
     * @return com.trust.xfyl.entity.ResultVO
     * @author Bay-max
     * @date 2024/4/22 14:01
     * @Param [surgicalName]
     **/
    @ApiOperation(value = "获取列表", nickname = "selectDoctorAll", notes = "获取列表")
    @PostMapping("/selectDoctorAll")
    public ResultVO selectDoctorAll(@ApiParam(value = "医生对象", required = true) @RequestBody Doctor doctor) {
        try {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            DoctorExample dictionaryExample = new DoctorExample();
            if (doctor.getDoctorName() != null) {
                dictionaryExample.createCriteria().andDoctorNameEqualTo(doctor.getDoctorName());
            }
            dictionaryExample.setStart((doctor.getPage() - 1) * doctor.getCount());
            dictionaryExample.setEnd(doctor.getCount());
            List<Doctor> doctors = doctorMapper.selectByExample(dictionaryExample);
            returnMap.put("msg", "success");
            returnMap.put("data", doctors);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching doctor: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }

    }

    @ApiOperation(value = "保存一条数据", nickname = "saveDoctor", notes = "保存一条数据")
    @PostMapping("/saveDoctor")
    public ResultVO saveDoctor(@ApiParam(value = "医生对象", required = true) @RequestBody Doctor doctor) {
        try {
            if (doctor.getId() != null) {
                doctor.setUpdateTime(new Date());
                Long i = doctorService.updateByPrimaryKeySelective(doctor);
                if (i > 0 && (doctor.getFileId() != null)) {
                    Long id = doctor.getId();
                    TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
                    trustRelationFileExample.createCriteria().andBusiTypeEqualTo("doctor").andBusiIdEqualTo(String.valueOf(id));
                    List<TrustRelationFile> trustRelationFiles = trustRelationFileMapper.selectByExample(trustRelationFileExample);
                    if (trustRelationFiles.size() > 0) {
                        for (int i1 = 0; i1 < trustRelationFiles.size(); i1++) {
                            TrustRelationFile trustRelationFile = trustRelationFiles.get(i1);
                            TrustRelationFileExample trustRelationFileExample1 = new TrustRelationFileExample();
                            trustRelationFileExample1.createCriteria().andBusiIdEqualTo(trustRelationFile.getBusiId())
                                    .andBusiTypeEqualTo("doctor");
                            trustRelationFileMapper.deleteByExample(trustRelationFileExample1);
                        }
                    }
                    TrustRelationFile trustRelationFile = new TrustRelationFile();
                    trustRelationFile.setFileId(doctor.getDoctorPhoto());
                    trustRelationFile.setBusiType("doctor");
                    trustRelationFile.setBusiId(i + "");
                    trustRelationFile.setPhotoType("医生图片");
                    boolean b = fileService.addFileRela(trustRelationFile);
                }
                if (i > 0) {
                    return ResultVOUtil.success("保存成功");
                } else {
                    return ResultVOUtil.error("保存失败");
                }
            } else {
                doctor.setCreateTime(new Date());
                doctor.setIsDelete("0");
                Long i = doctorService.insertSelective(doctor);
                if (i > 0 && (doctor.getDoctorPhoto() != null)) {
                    TrustRelationFile trustRelationFile = new TrustRelationFile();
                    trustRelationFile.setFileId(doctor.getDoctorPhoto());
                    trustRelationFile.setBusiType("doctor");
                    trustRelationFile.setBusiId(i + "");
                    trustRelationFile.setPhotoType("医生图片");
                    fileService.addFileRela(trustRelationFile);
                }
                if (i > 0) {
                    return ResultVOUtil.success("保存成功");
                } else {
                    return ResultVOUtil.error("保存失败");
                }
            }
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching doctor: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }


    @ApiOperation(value = "批量删除", nickname = "deleteDoctor", notes = "批量删除")
    @GetMapping("/deleteDoctor")
    public ResultVO deleteDoctor(@ApiParam(name = "ids", value = "主键字符串的形式", required = true) @RequestParam("ids") String ids) {
        try {
            int i1 = 0;
            String[] Split = ids.split(",");
            for (int i = 0; i < Split.length; i++) {
                String s = Split[i];
                DoctorExample doctorExample = new DoctorExample();
                doctorExample.createCriteria().andIdEqualTo(Long.valueOf(s));
                i1 = doctorMapper.deleteByExample(doctorExample);
                TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
                trustRelationFileExample.createCriteria().andBusiIdEqualTo(s).andBusiTypeEqualTo("dictionary").andPhotoTypeEqualTo(PhotoEnum.Fourteen.getMessage());
                int i2 = trustRelationFileMapper.countByExample(trustRelationFileExample);
                if (i2 > 0) {
                    for (int j = 0; j < i2; j++) {
                        int i3 = trustRelationFileMapper.deleteByExample(trustRelationFileExample);
                    }
                }
            }
            if (i1 > 0) {
                return ResultVOUtil.success("操作成功");
            } else {
                return ResultVOUtil.error("失败");
            }
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching doctor: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }

    @ApiOperation(value = "根据id查询一条数据", nickname = "selectDoctorById", notes = "根据id查询一条数据")
    @GetMapping("selectDoctorById")
    public ResultVO selectDoctorById(@ApiParam(name = "id", value = "主键", required = true) @RequestParam("id") Long id) {
        try {
            List list = new ArrayList();
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Doctor doctor = doctorMapper.selectByPrimaryKey(id);
            TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
            trustRelationFileExample.createCriteria().andBusiIdEqualTo(String.valueOf(id))
                    .andBusiTypeEqualTo("doctor").andPhotoTypeEqualTo("医生图片");
            List<TrustRelationFile> tlRelationFiles = trustRelationFileMapper.selectByExample(trustRelationFileExample);
            for (int i = 0; i < tlRelationFiles.size(); i++) {
                TrustRelationFile trustRelationFile = tlRelationFiles.get(i);
                String fileId = trustRelationFile.getFileId();
                TrustFile trustFile = trustFileMapper.selectByPrimaryKey(Integer.valueOf(fileId));
                list.add(trustFile);
            }
            returnMap.put("file", list);
            returnMap.put("doctor", doctor);
            returnMap.put("tlRelationFiles", tlRelationFiles);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            logger.error("Service Exception: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(e.getStatus(), ScExceptionUtils.sanitizeErrorMessage(e.getMessage()));
        } catch (Exception e) {
            logger.error("Error fetching doctor: {}", ScExceptionUtils.sanitizeErrorMessage(e.getMessage()), e);
            return ResultVOUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
        }
    }
}