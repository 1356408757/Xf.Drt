package com.trust.xfyl.service.impl;

import com.trust.xfyl.dao.DictionaryMapper;
import com.trust.xfyl.model.po.Dictionary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 字典服务类，提供字典的插入和更新操作
 *
 * @Description 提供关于字典的CRUD操作服务
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class DictionaryService {
    private final DictionaryMapper dictionaryMapper;

    /**
     * 构造函数，依赖注入DictionaryMapper
     *
     * @param dictionaryMapper 字典映射器接口，用于数据库操作
     */
    public DictionaryService(DictionaryMapper dictionaryMapper) {
        this.dictionaryMapper = dictionaryMapper;
    }

    /**
     * 选择性插入字典信息
     *
     * @param dictionary 待插入的字典对象
     * @return 插入后字典的id
     */
    public Integer insertSelective(Dictionary dictionary) {
        dictionaryMapper.insertSelective(dictionary);
        return dictionary.getId();
    }

    /**
     * 选择性根据主键更新字典信息
     *
     * @param dictionary 待更新的字典对象
     * @return 更新后的字典id
     */
    public Integer updateByPrimaryKeySelective(Dictionary dictionary) {
        dictionaryMapper.updateByPrimaryKeySelective(dictionary);
        return dictionary.getId();
    }
}

