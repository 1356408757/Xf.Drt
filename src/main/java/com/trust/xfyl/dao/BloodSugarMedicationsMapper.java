/**
 * BloodSugarMedicationsMapper接口定义了与血糖药物治疗相关信息的数据库操作。
 * 它使用MyBatis注解，提供了CRUD操作以及基于样例的查询操作。
 */
package com.trust.xfyl.dao;

import com.trust.xfyl.model.po.BloodSugarMedications;
import com.trust.xfyl.model.po.BloodSugarMedicationsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * TODO
 *
 * @Description
 * @author Bay-max
 * @date 2024/5/20 13:44
 **/

public interface BloodSugarMedicationsMapper {
    /**
     * 根据样例查询符合条件的记录数。
     * 
     * @param example 包含查询条件的样例对象
     * @return 符合条件的记录数
     */
    int countByExample(BloodSugarMedicationsExample example);

    /**
     * 根据样例删除符合条件的所有记录。
     * 
     * @param example 包含删除条件的样例对象
     * @return 删除的记录数
     */
    int deleteByExample(BloodSugarMedicationsExample example);

    /**
     * 根据主键删除指定记录。
     * 
     * @param id 要删除记录的主键ID
     * @return 删除的记录数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条新的记录。
     * 
     * @param record 要插入的数据记录对象
     * @return 插入的记录数
     */
    int insert(BloodSugarMedications record);

    /**
     * 选择性插入一条新的记录，只会插入非null的字段。
     * 
     * @param record 要插入的数据记录对象
     * @return 插入的记录数
     */
    int insertSelective(BloodSugarMedications record);

    /**
     * 根据样例查询符合条件的所有记录。
     * 
     * @param example 包含查询条件的样例对象
     * @return 符合条件的记录列表
     */
    List<BloodSugarMedications> selectByExample(BloodSugarMedicationsExample example);

    /**
     * 根据主键查询指定记录。
     * 
     * @param id 要查询记录的主键ID
     * @return 指定ID的记录对象
     */
    BloodSugarMedications selectByPrimaryKey(Integer id);

    /**
     * 根据样例和更新记录，选择性更新符合条件的记录字段。
     * 
     * @param record 要更新的数据记录对象
     * @param example 包含更新条件的样例对象
     * @return 更新的记录数
     */
    int updateByExampleSelective(@Param("record") BloodSugarMedications record, @Param("example") BloodSugarMedicationsExample example);

    /**
     * 根据样例和更新记录，更新符合条件的所有记录字段。
     * 
     * @param record 要更新的数据记录对象
     * @param example 包含更新条件的样例对象
     * @return 更新的记录数
     */
    int updateByExample(@Param("record") BloodSugarMedications record, @Param("example") BloodSugarMedicationsExample example);

    /**
     * 根据主键选择性更新记录。
     * 
     * @param record 要更新的数据记录对象
     * @return 更新的记录数
     */
    int updateByPrimaryKeySelective(BloodSugarMedications record);

    /**
     * 根据主键更新记录。
     * 
     * @param record 要更新的数据记录对象
     * @return 更新的记录数
     */
    int updateByPrimaryKey(BloodSugarMedications record);
}
