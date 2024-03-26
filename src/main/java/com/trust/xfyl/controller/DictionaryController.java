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
 * 字典表控制器
 * 负责处理与字典表相关的HTTP请求
 *
 * @Author djj
 * @Date 17:52 2024/1/25
 **/
@Api(value = "字典表", description = "字典表接口", tags = "字典表")
@RestController
@RequestMapping("/Dictionary")
public class DictionaryController {
    // 数据库操作接口，用于字典表的增删改查
    private final DictionaryMapper dictionaryMapper;
    // 字典表服务层，封装了业务逻辑
    private final DictionaryService dictionaryService;
    // 文件服务，处理文件相关的操作
    private final FileService fileService;
    // 信任关系文件映射器，用于操作信任关系与文件的关联数据
    private final TrustRelationFileMapper trustRelationFileMapper;
    // 信任文件映射器，用于操作信任文件的数据
    private final TrustFileMapper trustFileMapper;

    /**
     * 构造函数
     * 依赖注入字典表相关的Mapper和Service
     *
     * @param dictionaryMapper        字典表数据库操作接口
     * @param dictionaryService       字典表服务层
     * @param fileService             文件服务
     * @param trustRelationFileMapper 信任关系文件映射器
     * @param trustFileMapper         信任文件映射器
     */
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
            // 检查字典ID是否为空，根据结果执行更新或插入操作
            if (dictionary.getId() != null) {
                return updateDictionary(dictionary);
            } else {
                return insertDictionary(dictionary);
            }
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            return ResultVOUtil.error(-1, e.getMessage());
        }
    }

    // 更新字典记录和相关文件关系
    private ResultVO updateDictionary(Dictionary dictionary) {
        dictionary.setUpdateTime(new Date());
        int affectedRows = dictionaryService.updateByPrimaryKeySelective(dictionary);

        if (affectedRows > 0 && dictionary.getFileId() != null) {
            handleFileRelation(dictionary.getId(), dictionary.getFileId());
        }

        return (affectedRows > 0) ? ResultVOUtil.success("保存成功") : ResultVOUtil.error("保存失败");
    }

    // 插入字典记录和相关文件关系
    private ResultVO insertDictionary(Dictionary dictionary) {
        dictionary.setCreateTime(new Date());
        dictionary.setIsDelete(0);
        int affectedRows = dictionaryService.insertSelective(dictionary);

        if (affectedRows > 0 && dictionary.getFileId() != null) {
            handleFileRelation(dictionary.getId(), dictionary.getFileId());
        }

        return (affectedRows > 0) ? ResultVOUtil.success("保存成功") : ResultVOUtil.error("保存失败");
    }

    // 处理文件关系的方法
    private void handleFileRelation(Integer dictionaryId, String fileId) {
        TrustRelationFileExample example = new TrustRelationFileExample();
        example.createCriteria().andBusiTypeEqualTo("dictionary").andBusiIdEqualTo(String.valueOf(dictionaryId));

        List<TrustRelationFile> trustRelationFiles = trustRelationFileMapper.selectByExample(example);

        // 删除旧的文件关系
        if (!trustRelationFiles.isEmpty()) {
            for (TrustRelationFile trustRelationFile : trustRelationFiles) {
                TrustRelationFileExample deleteExample = new TrustRelationFileExample();
                deleteExample.createCriteria().andBusiIdEqualTo(trustRelationFile.getBusiId()).andBusiTypeEqualTo("dictionary");
                trustRelationFileMapper.deleteByExample(deleteExample);
            }
        }

        // 添加新的文件关系
        TrustRelationFile trustRelationFile = new TrustRelationFile();
        trustRelationFile.setFileId(fileId);
        trustRelationFile.setBusiType("dictionary");
        trustRelationFile.setBusiId(dictionaryId.toString());
        trustRelationFile.setPhotoType(PhotoEnum.Fourteen.getMessage());
        fileService.addFileRela(trustRelationFile);
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
