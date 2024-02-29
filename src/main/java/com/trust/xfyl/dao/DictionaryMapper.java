package com.trust.xfyl.dao;

import com.trust.xfyl.entity.Dictionary;
import com.trust.xfyl.entity.DictionaryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author djj
 * @Description //TODO
 * @Date 9:41 2024/1/26
 **/

public interface DictionaryMapper {
    /**
     * @return int
     * @author djj
     * @Description //TODO
     * @Date 9:39 2024/1/26
     * @Param [example]
     **/
    int countByExample(DictionaryExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:39 2024/1/26
     * @Param [example]
     **/

    int deleteByExample(DictionaryExample example);

    /**
     * @return int
     * @author djj
     * @Description //TODO
     * @Date 9:39 2024/1/26
     * @Param [id]
     **/

    int deleteByPrimaryKey(Integer id);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:40 2024/1/26
     * @Param [record]
     **/

    int insert(Dictionary record);

    /**
     * @return int
     * @author djj
     * @Description //TODO
     * @Date 9:40 2024/1/26
     * @Param [record]
     **/

    int insertSelective(Dictionary record);

    /**
     * @return java.util.List<com.trust.xfyl.entity.Dictionary>
     * @author djj
     * @Description //TODO
     * @Date 9:40 2024/1/26
     * @Param [example]
     **/

    List<Dictionary> selectByExample(DictionaryExample example);

    /**
     * @return com.trust.xfyl.entity.Dictionary
     * @author djj
     * @Description //TODO
     * @Date 9:40 2024/1/26
     * @Param [id]
     **/

    Dictionary selectByPrimaryKey(Integer id);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:40 2024/1/26
     * @Param [record, example]
     **/

    int updateByExampleSelective(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:40 2024/1/26
     * @Param [record, example]
     **/

    int updateByExample(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:40 2024/1/26
     * @Param [record]
     **/

    int updateByPrimaryKeySelective(Dictionary record);

    /**
     * @return int
     * @Author djj
     * @Description //TODO
     * @Date 9:40 2024/1/26
     * @Param [record]
     **/

    int updateByPrimaryKey(Dictionary record);
}