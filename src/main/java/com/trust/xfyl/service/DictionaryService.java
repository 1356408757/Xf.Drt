package com.trust.xfyl.service;

import com.trust.xfyl.dao.DictionaryMapper;
import com.trust.xfyl.entity.Dictionary;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {
    private final DictionaryMapper dictionaryMapper;

    public DictionaryService(DictionaryMapper dictionaryMapper) {
        this.dictionaryMapper = dictionaryMapper;
    }

    public Integer insertSelective(Dictionary dictionary) {
        dictionaryMapper.insertSelective(dictionary);
        return dictionary.getId();
    }

    public Integer updateByPrimaryKeySelective(Dictionary dictionary) {
        dictionaryMapper.updateByPrimaryKeySelective(dictionary);
        return dictionary.getId();
    }
}
