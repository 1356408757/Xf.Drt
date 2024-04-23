package com.trust.xfyl.dao;

import com.trust.xfyl.entity.Dictionary;
import com.trust.xfyl.entity.DictionaryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典数据访问接口
 * @Author djj
 * @Date 9:41 2024/1/26
 **/
public interface DictionaryMapper {
    /**
     * 根据条件计算记录数
     * @param example 查询条件实例
     * @return 记录数
     * @Author djj
     * @Date 9:39 2024/1/26
     **/
    int countByExample(DictionaryExample example);

    /**
     * 根据条件删除记录
     * @param example 查询条件实例
     * @return 影响的记录数
     * @Author djj
     * @Date 9:39 2024/1/26
     **/
    int deleteByExample(DictionaryExample example);

    /**
     * 根据主键删除记录
     * @param id 主键ID
     * @return 影响的记录数
     * @Author djj
     * @Date 9:39 2024/1/26
     **/
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条记录
     * @param record 记录实例
     * @return 影响的记录数
     * @Author djj
     * @Date 9:40 2024/1/26
     **/
    int insert(Dictionary record);

    /**
     * 基于选择性字段插入一条记录
     * @param record 记录实例
     * @return 影响的记录数
     * @Author djj
     * @Date 9:40 2024/1/26
     **/
    int insertSelective(Dictionary record);

    /**
     * 根据条件查询记录列表
     * @param example 查询条件实例
     * @return 记录列表
     * @Author djj
     * @Date 9:40 2024/1/26
     **/
    List<Dictionary> selectByExample(DictionaryExample example);

    /**
     * 根据主键查询一条记录
     * @param id 主键ID
     * @return 记录实例
     * @Author djj
     * @Date 9:40 2024/1/26
     **/
    Dictionary selectByPrimaryKey(Integer id);

    /**
     * 基于选择性字段更新记录
     * @param record 记录实例
     * @param example 查询条件实例
     * @return 影响的记录数
     * @Author djj
     * @Date 9:40 2024/1/26
     **/
    int updateByExampleSelective(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    /**
     * 基于条件更新记录
     * @param record 记录实例
     * @param example 查询条件实例
     * @return 影响的记录数
     * @Author djj
     * @Date 9:40 2024/1/26
     **/
    int updateByExample(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    /**
     * 基于选择性字段更新一条记录
     * @param record 记录实例
     * @return 影响的记录数
     * @Author djj
     * @Date 9:40 2024/1/26
     **/
    int updateByPrimaryKeySelective(Dictionary record);

    /**
     * 根据主键更新记录
     * @param record 记录实例
     * @return 影响的记录数
     * @Author djj
     * @Date 9:40 2024/1/26
     **/
    int updateByPrimaryKey(Dictionary record);
}
