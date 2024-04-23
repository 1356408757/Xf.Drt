package com.trust.xfyl.dao;

import com.trust.xfyl.entity.WoundOrders;
import com.trust.xfyl.entity.WoundOrdersExample;
import com.trust.xfyl.entity.vo.WoundOrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * TODO 伤口订单数据访问接口
 *
 * @description
 * @author Bay-max
 * @date 2024/4/22 15:10
 **/

public interface WoundOrdersMapper {
    /**
     * 根据条件统计订单数量
     * @param example 查询条件
     * @return 订单数量
     **/
    int countByExample(WoundOrdersExample example);

    /**
     * 根据条件删除订单数据
     * @param example 查询条件
     * @return 影响行数
     **/
    int deleteByExample(WoundOrdersExample example);

    /**
     * 根据订单ID删除订单数据
     * @param id 订单ID
     * @return 影响行数
     **/
    int deleteByPrimaryKey(Long id);

    /**
     * 插入订单数据，不过滤空值
     * @param record 订单记录
     * @return 影响行数
     **/
    int insert(WoundOrders record);

    /**
     * 插入订单数据，返回生成的主键，过滤空值
     * @param record 订单记录
     * @return 生成的主键
     **/
    int insertSelective(WoundOrders record);

    /**
     * 根据条件查询订单列表
     * @param example 查询条件
     * @return 订单列表
     **/
    List<WoundOrders> selectByExample(WoundOrdersExample example);

    /**
     * 根据订单ID查询订单详情
     * @param id 订单ID
     * @return 订单详情
     **/
    WoundOrders selectByPrimaryKey(Long id);

    /**
     * 根据条件更新订单数据，选择性更新非空字段
     * @param record 订单记录
     * @param example 查询条件
     * @return 影响行数
     **/
    int updateByExampleSelective(@Param("record") WoundOrders record, @Param("example") WoundOrdersExample example);

    /**
     * 根据条件更新订单数据
     * @param record 订单记录
     * @param example 查询条件
     * @return 影响行数
     **/
    int updateByExample(@Param("record") WoundOrders record, @Param("example") WoundOrdersExample example);

    /**
     * 根据订单ID选择性更新订单数据，过滤空值
     * @param record 订单记录
     * @return 影响行数
     **/
    int updateByPrimaryKeySelective(WoundOrders record);

    /**
     * 根据订单ID更新订单数据
     * @param record 订单记录
     * @return 影响行数
     **/
    int updateByPrimaryKey(WoundOrders record);

    /**
     * 自定义查询订单总数的方法，与下面的查询列表方法相匹配
     * @param woundOrders 查询条件
     * @return 订单总数
     **/
    Long count(WoundOrders woundOrders);

    /**
     * 自定义查询订单列表的方法，返回带有订单关联的医生、患者、图片等数据，包含分页信息
     * @param woundOrders 查询条件
     * @return 订单列表
     **/
    List<WoundOrderVo> selectAll(WoundOrders woundOrders);

    /**
     * 根据订单ID获取该订单关联的医生、患者、图片等信息
     * @param id 订单ID
     * @return 订单关联信息
     **/
    WoundOrderVo selectWoundOrdersById(Long id);
}
