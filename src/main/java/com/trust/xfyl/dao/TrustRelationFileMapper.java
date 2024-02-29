package com.trust.xfyl.dao;

import com.trust.xfyl.entity.TrustRelationFile;
import com.trust.xfyl.entity.TrustRelationFileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author : djj
 * @Date: 2014-01-24
 */

public interface TrustRelationFileMapper {
    /**
     * 查询总数
     *
     * @param example
     * @return int
     */
    int countByExample(TrustRelationFileExample example);

    /**
     * 根据条件删除数据
     *
     * @param example
     * @return int
     */
    int deleteByExample(TrustRelationFileExample example);

    /**
     * 添加一条数据
     *
     * @param record
     * @return int
     */
    int insert(TrustRelationFile record);

    /**
     * 添加一条数据
     *
     * @param record
     * @return int
     */
    int insertSelective(TrustRelationFile record);

    /**
     * 获取数据列表
     *
     * @param example
     * @return List
     */
    List<TrustRelationFile> selectByExample(TrustRelationFileExample example);

    /**
     * 根据条件修改数据
     *
     * @param record
     * @param example
     * @return List
     */
    int updateByExampleSelective(@Param("record") TrustRelationFile record, @Param("example") TrustRelationFileExample example);

    /**
     * 根据条件修改数据
     *
     * @param record
     * @param example
     * @return List
     */
    int updateByExample(@Param("record") TrustRelationFile record, @Param("example") TrustRelationFileExample example);
}