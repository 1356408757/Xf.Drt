package com.trust.xfyl.dao;

import com.trust.xfyl.entity.TrustFile;
import com.trust.xfyl.entity.TrustFileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TrustFile数据访问接口
 */
public interface TrustFileMapper {
    /**
     * 根据条件查询记录总数
     *
     * @param example 查询条件
     * @return 记录总数
     */
    int countByExample(TrustFileExample example);

    /**
     * 根据条件删除记录
     *
     * @param example 查询条件
     * @return 影响的记录数
     */
    int deleteByExample(TrustFileExample example);

    /**
     * 根据主键删除记录
     *
     * @param fileId 主键
     * @return 影响的记录数
     */
    int deleteByPrimaryKey(Integer fileId);

    /**
     * 插入一条记录
     *
     * @param record 待插入的数据
     * @return 影响的记录数
     */
    int insert(TrustFile record);

    /**
     * 选择性插入一条记录
     *
     * @param record 待插入的数据
     * @return 影响的记录数
     */
    int insertSelective(TrustFile record);

    /**
     * 根据条件查询记录列表
     *
     * @param example 查询条件
     * @return 记录列表
     */
    List<TrustFile> selectByExample(TrustFileExample example);

    /**
     * 根据主键查询记录
     *
     * @param fileId 主键
     * @return 对应的记录
     */
    TrustFile selectByPrimaryKey(Integer fileId);

    /**
     * 根据条件选择性更新记录
     *
     * @param record 待更新的数据
     * @param example 查询条件
     * @return 影响的记录数
     */
    int updateByExampleSelective(@Param("record") TrustFile record, @Param("example") TrustFileExample example);

    /**
     * 根据条件更新记录
     *
     * @param record 待更新的数据
     * @param example 查询条件
     * @return 影响的记录数
     */
    int updateByExample(@Param("record") TrustFile record, @Param("example") TrustFileExample example);

    /**
     * 根据主键选择性更新记录
     *
     * @param record 待更新的数据
     * @return 影响的记录数
     */
    int updateByPrimaryKeySelective(TrustFile record);

    /**
     * 根据主键更新记录
     *
     * @param record 待更新的数据
     * @return 影响的记录数
     */
    int updateByPrimaryKey(TrustFile record);

    /**
     * 根据条件获取记录总数
     *
     * @param trustFileExample 查询条件
     * @return 记录总数
     */
    Long count(TrustFileExample trustFileExample);

    /**
     * 插入文件信息后处理
     *
     * @param list 文件信息列表
     * @return 影响的记录数
     */
    int afterInsertFile(@Param("list") List list);
}
