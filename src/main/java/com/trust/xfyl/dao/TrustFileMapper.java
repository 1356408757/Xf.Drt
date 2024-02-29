package com.trust.xfyl.dao;


import com.trust.xfyl.entity.TrustFile;
import com.trust.xfyl.entity.TrustFileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author LENOVO
 * @Date: 2014-01-24
 */

public interface TrustFileMapper {
    /**
     * 查询总数
     *
     * @param example
     * @return int
     */
    int countByExample(TrustFileExample example);

    /**
     * 根据条件删除数据
     *
     * @param example
     * @return int
     */
    int deleteByExample(TrustFileExample example);

    /**
     * 根据条件删除数据
     *
     * @param fileId
     * @return int
     */
    int deleteByPrimaryKey(Integer fileId);

    /**
     * 添加一条数据
     *
     * @param record
     * @return int
     */
    int insert(TrustFile record);

    /**
     * 添加一条数据
     *
     * @param record
     * @return int
     */
    int insertSelective(TrustFile record);

    /**
     * 根据条件查询列表
     *
     * @param example
     * @return List<TrustFile>
     */
    List<TrustFile> selectByExample(TrustFileExample example);

    /**
     * 根据id查询数据
     *
     * @param fileId
     * @return TrustFile
     */
    TrustFile selectByPrimaryKey(Integer fileId);

    /**
     * 根据条件修改数据
     *
     * @param record
     * @param example
     * @return int
     */
    int updateByExampleSelective(@Param("record") TrustFile record, @Param("example") TrustFileExample example);

    /**
     * 根据条件修改数据
     *
     * @param record
     * @param example
     * @return int
     */
    int updateByExample(@Param("record") TrustFile record, @Param("example") TrustFileExample example);

    /**
     * 根据条件修改数据
     *
     * @param record
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(TrustFile record);

    /**
     * 根据条件修改数据
     *
     * @param record
     * @param record
     * @return int
     */
    int updateByPrimaryKey(TrustFile record);

    /**
     * 获取总数
     *
     * @param trustFileExample
     * @return Long
     */
    Long count(TrustFileExample trustFileExample);

    int afterInsertFile(@Param("list")List list);
}