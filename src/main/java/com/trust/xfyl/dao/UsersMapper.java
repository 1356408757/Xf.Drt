package com.trust.xfyl.dao;

import com.trust.xfyl.entity.Users;
import com.trust.xfyl.entity.UsersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UsersMapper接口定义了用户数据访问的方法
 * @author  big-max
 */
public interface UsersMapper {
    /**
     * 根据条件查询用户数量
     * @param example 包含查询条件的UsersExample对象
     * @return 符合条件的用户数量
     */
    int countByExample(UsersExample example);

    /**
     * 根据条件删除用户
     * @param example 包含删除条件的UsersExample对象
     * @return 删除的用户数量
     */
    int deleteByExample(UsersExample example);

    /**
     * 根据用户ID删除用户
     * @param userId 要删除的用户的ID
     * @return 删除的用户数量
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 插入一个新的用户记录
     * @param record 要插入的Users对象
     * @return 插入的记录数
     */
    int insert(Users record);

    /**
     * 选择性插入一个新的用户记录
     * @param record 要插入的Users对象
     * @return 插入的记录数
     */
    int insertSelective(Users record);

    /**
     * 根据条件查询用户列表
     * @param example 包含查询条件的UsersExample对象
     * @return 符合条件的用户列表
     */
    List<Users> selectByExample(UsersExample example);

    /**
     * 根据用户ID查询用户信息
     * @param userId 要查询的用户的ID
     * @return 对应的Users对象
     */
    Users selectByPrimaryKey(Integer userId);

    /**
     * 根据条件选择性更新用户信息
     * @param record 要更新的Users对象
     * @param example 包含更新条件的UsersExample对象
     * @return 更新的记录数
     */
    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    /**
     * 根据条件更新用户信息
     * @param record 要更新的Users对象
     * @param example 包含更新条件的UsersExample对象
     * @return 更新的记录数
     */
    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    /**
     * 根据用户ID选择性更新用户信息
     * @param record 要更新的Users对象
     * @return 更新的记录数
     */
    int updateByPrimaryKeySelective(Users record);

    /**
     * 根据用户ID更新用户信息
     * @param record 要更新的Users对象
     * @return 更新的记录数
     */
    int updateByPrimaryKey(Users record);
}
