package com.trust.xfyl.dao;

import com.trust.xfyl.model.po.SkinInformation;
import com.trust.xfyl.model.po.SkinInformationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SkinInformationMapper接口定义了对SkinInformation表进行CRUD操作的方法
 *
 * @author Bay-max
 * @Description
 * @date 2024/5/14 15:31
 **/

public interface SkinInformationMapper {
    /**
     * 根据条件统计表中记录数量
     *
     * @param example 包含查询条件的对象
     * @return 符合条件的记录数
     */
    int countByExample(SkinInformationExample example);

    /**
     * 根据条件删除记录
     *
     * @param example 包含删除条件的对象
     * @return 删除的记录数
     */
    int deleteByExample(SkinInformationExample example);

    /**
     * 根据主键删除记录
     *
     * @param id 要删除的记录的主键
     * @return 删除的记录数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条新记录
     *
     * @param record 要插入的数据记录
     * @return 插入的记录数
     */
    int insert(SkinInformation record);

    /**
     * 选择性插入一条新记录
     *
     * @param record 要插入的数据记录
     * @return 插入的记录数
     */
    int insertSelective(SkinInformation record);

    /**
     * 根据条件查询记录
     *
     * @param example 包含查询条件的对象
     * @return 符合条件的记录列表
     */
    List<SkinInformation> selectByExample(SkinInformationExample example);

    /**
     * 根据主键查询一条记录
     *
     * @param id 要查询的记录的主键
     * @return 查询到的记录
     */
    SkinInformation selectByPrimaryKey(Integer id);

    /**
     * 根据条件选择性更新记录
     *
     * @param record  要更新的数据记录
     * @param example 包含更新条件的对象
     * @return 更新的记录数
     */
    int updateByExampleSelective(@Param("record") SkinInformation record, @Param("example") SkinInformationExample example);

    /**
     * 根据条件更新记录
     *
     * @param record  要更新的数据记录
     * @param example 包含更新条件的对象
     * @return 更新的记录数
     */
    int updateByExample(@Param("record") SkinInformation record, @Param("example") SkinInformationExample example);

    /**
     * 根据主键选择性更新记录
     *
     * @param record 要更新的数据记录
     * @return 更新的记录数
     */
    int updateByPrimaryKeySelective(SkinInformation record);

    /**
     * 根据主键更新记录
     *
     * @param record 要更新的数据记录
     * @return 更新的记录数
     */
    int updateByPrimaryKey(SkinInformation record);
}
