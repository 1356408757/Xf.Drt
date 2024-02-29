package com.trust.xfyl.controller;

import com.trust.xfyl.dao.DictionaryMapper;
import com.trust.xfyl.dao.TrustFileMapper;
import com.trust.xfyl.dao.TrustRelationFileMapper;
import com.trust.xfyl.entity.Dictionary;
import com.trust.xfyl.entity.*;
import com.trust.xfyl.enums.PhotoEnum;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.service.DictionaryService;
import com.trust.xfyl.service.FileService;
import com.trust.xfyl.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Author djj
 * @Description //TODO
 * @Date 17:52 2024/1/25
 * @Param
 * @return
 **/
@Api(value = "字典表", description = "字典表", tags = "字典表")
@RestController
@RequestMapping("/Dictionary")
public class DictionaryController {
    private final DictionaryMapper dictionaryMapper;
    private final DictionaryService dictionaryService;
    private final FileService fileService;
    private final TrustRelationFileMapper trustRelationFileMapper;
    private final TrustFileMapper trustFileMapper;

    public DictionaryController(DictionaryMapper dictionaryMapper, DictionaryService dictionaryService, FileService fileService, TrustRelationFileMapper trustRelationFileMapper, TrustFileMapper trustFileMapper) {
        this.dictionaryMapper = dictionaryMapper;
        this.dictionaryService = dictionaryService;
        this.fileService = fileService;
        this.trustRelationFileMapper = trustRelationFileMapper;
        this.trustFileMapper = trustFileMapper;
    }

    /**
     * @return com.trust.xfyl.entity.ResultVO
     * @Author djj
     * @Description //TODO
     * @Date 17:53 2024/1/25
     * @Param [surgicalName]
     **/
    @ApiOperation(value = "获取列表", nickname = "selectDictionaryAll", notes = "获取列表")
    @PostMapping("/selectDictionaryAll")
    public ResultVO selectDictionaryAll(@ApiParam(value = "字典表对象", required = true) @RequestBody Dictionary dictionary) {
        try {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            DictionaryExample dictionaryExample = new DictionaryExample();
            if (dictionary.getTyoe() != null) {
                dictionaryExample.createCriteria().andTyoeEqualTo(dictionary.getTyoe());
            }
            List<Dictionary> dictionaries = dictionaryMapper.selectByExample(dictionaryExample);
            returnMap.put("msg", "success");
            returnMap.put("data", dictionaries);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }

    }

    @ApiOperation(value = "保存一条数据", nickname = "saveDictionary", notes = "保存一条数据")
    @PostMapping("/saveDictionary")
    public ResultVO saveDictionary(@ApiParam(value = "字典表对象", required = true) @RequestBody Dictionary dictionary) {
        try {
            if (dictionary.getId() != null) {
                dictionary.setUpdateTime(new Date());
                int i = dictionaryService.updateByPrimaryKeySelective(dictionary);
                if (i > 0 && (dictionary.getFileId() != null)) {
                    Integer id = dictionary.getId();
                    TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
                    trustRelationFileExample.createCriteria().andBusiTypeEqualTo("dictionary").andBusiIdEqualTo(String.valueOf(id));
                    List<TrustRelationFile> trustRelationFiles = trustRelationFileMapper.selectByExample(trustRelationFileExample);
                    if (trustRelationFiles.size() > 0) {
                        for (int i1 = 0; i1 < trustRelationFiles.size(); i1++) {
                            TrustRelationFile trustRelationFile = trustRelationFiles.get(i1);
                            TrustRelationFileExample trustRelationFileExample1 = new TrustRelationFileExample();
                            trustRelationFileExample1.createCriteria().andBusiIdEqualTo(trustRelationFile.getBusiId())
                                    .andBusiTypeEqualTo("dictionary");
                            trustRelationFileMapper.deleteByExample(trustRelationFileExample1);
                        }
                    }
                    TrustRelationFile trustRelationFile = new TrustRelationFile();
                    trustRelationFile.setFileId(dictionary.getFileId());
                    trustRelationFile.setBusiType("dictionary");
                    trustRelationFile.setBusiId(i + "");
                    trustRelationFile.setPhotoType(PhotoEnum.Fourteen.getMessage());
                    boolean b = fileService.addFileRela(trustRelationFile);
                }
                if (i > 0) {
                    return ResultVOUtil.success("保存成功");
                } else {
                    return ResultVOUtil.error("保存失败");
                }
            } else {
                dictionary.setCreateTime(new Date());
                dictionary.setIsDelete(0);
                int i = dictionaryService.insertSelective(dictionary);
                if (i > 0 && (dictionary.getFileId() != null)) {
                    TrustRelationFile trustRelationFile = new TrustRelationFile();
                    trustRelationFile.setFileId(dictionary.getFileId());
                    trustRelationFile.setBusiType("dictionary");
                    trustRelationFile.setBusiId(i + "");
                    trustRelationFile.setPhotoType(PhotoEnum.Fourteen.getMessage());
                    fileService.addFileRela(trustRelationFile);
                }
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


    @ApiOperation(value = "批量删除", nickname = "deleteDictionary", notes = "批量删除")
    @GetMapping("/deleteDictionary")
    public ResultVO deleteDictionary(@ApiParam(name = "ids", value = "主键字符串的形式", required = true) @RequestParam("ids") String ids) {
        try {
            int i1 = 0;
            String[] Split = ids.split(",");
            for (int i = 0; i < Split.length; i++) {
                String s = Split[i];
                DictionaryExample dictionaryExample = new DictionaryExample();
                dictionaryExample.createCriteria().andIdEqualTo(Integer.valueOf(s));
                i1 = dictionaryMapper.deleteByExample(dictionaryExample);
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
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            return ResultVOUtil.error(-1, e.getMessage());
        }
    }


    @ApiOperation(value = "根据id查询一条数据", nickname = "selectSurgicalNameById", notes = "根据id查询一条数据")
    @GetMapping("selectSurgicalNameById")
    public ResultVO selectSurgicalNameById(@ApiParam(name = "id", value = "主键", required = true) @RequestParam("id") Integer id) {
        try {
            List<TrustFile> list = new ArrayList<TrustFile>();
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Dictionary dictionary1 = dictionaryMapper.selectByPrimaryKey(id);
            TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
            trustRelationFileExample.createCriteria().andBusiIdEqualTo(String.valueOf(id))
                    .andBusiTypeEqualTo("dictionary");
            List<TrustRelationFile> tlRelationFiles = trustRelationFileMapper.selectByExample(trustRelationFileExample);
            if (tlRelationFiles.size() > 0) {
                for (int i = 0; i < tlRelationFiles.size(); i++) {
                    TrustRelationFile trustRelationFile = tlRelationFiles.get(i);
                    String fileId = trustRelationFile.getFileId();
                    TrustFile trustFile = trustFileMapper.selectByPrimaryKey(Integer.valueOf(fileId));
                    list.add(trustFile);
                }
            }

            returnMap.put("dictionary", dictionary1);
            returnMap.put("tlRelationFiles", tlRelationFiles);
            returnMap.put("trustFile", list);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }
    }
}
