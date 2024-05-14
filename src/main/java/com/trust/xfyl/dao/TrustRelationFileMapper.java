package com.trust.xfyl.dao;

import com.trust.xfyl.model.po.TrustRelationFile;
import com.trust.xfyl.model.po.TrustRelationFileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 信任关系文件映射器接口，用于操作信任关系文件的数据访问层
 *
 * @Author : djj
 * @Date: 2014-01-24
 */

public interface TrustRelationFileMapper {
    /**
     * 根据条件查询记录总数
     *
     * @param example 查询条件实例
     * @return 记录总数
     */
    int countByExample(TrustRelationFileExample example);

    /**
     * 根据条件删除记录
     *
     * @param example 删除条件实例
     * @return 影响的记录数
     */
    int deleteByExample(TrustRelationFileExample example);

    /**
     * 插入一条记录
     *
     * @param record 要插入的记录
     * @return 影响的记录数
     */
    int insert(TrustRelationFile record);

    /**
     * 选择性插入一条记录
     *
     * @param record 要插入的记录
     * @return 影响的记录数
     */
    int insertSelective(TrustRelationFile record);

    /**
     * 根据条件查询记录列表
     *
     * @param example 查询条件实例
     * @return 记录列表
     */
    List<TrustRelationFile> selectByExample(TrustRelationFileExample example);

    /**
     * 根据条件选择性更新记录
     *
     * @param record  要更新的记录
     * @param example 更新条件实例
     * @return 影响的记录数
     */
    int updateByExampleSelective(@Param("record") TrustRelationFile record, @Param("example") TrustRelationFileExample example);

    /**
     * 根据条件更新记录
     *
     * @param record  要更新的记录
     * @param example 更新条件实例
     * @return 影响的记录数
     */
    int updateByExample(@Param("record") TrustRelationFile record, @Param("example") TrustRelationFileExample example);
}
