package com.trust.xfyl.dao;

import com.trust.xfyl.entity.WoundOrders;
import com.trust.xfyl.entity.WoundOrdersExample;
import com.trust.xfyl.entity.vo.WoundOrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author djj
 * @Description //TODO
 * @Date 11:32 2024/2/20
 **/
public interface WoundOrdersMapper {
    /**
     * @return int
     * @Author djj
     * @Description //TODO 获取数据量的数值
     * @Date 11:32 2024/2/20
     * @Param [example]
     **/
    int countByExample(WoundOrdersExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件删除数据
     * @Date 11:32 2024/2/20
     * @Param [example]
     **/

    int deleteByExample(WoundOrdersExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据id删除数据
     * @Date 11:32 2024/2/20
     * @Param [id]
     **/

    int deleteByPrimaryKey(Long id);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 保存数据 但是不过滤空值
     * @Date 11:33 2024/2/20
     * @Param [record]
     **/

    int insert(WoundOrders record);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 保存一条数据，返回主键 且过滤空值
     * @Date 11:34 2024/2/20
     * @Param [record]
     **/

    int insertSelective(WoundOrders record);

    /**
     * @return java.util.List<com.trust.xfyl.entity.WoundOrders>
     * @Author djj
     * @Description //TODO 根据条件查询列表
     * @Date 11:34 2024/2/20
     * @Param [example]
     **/

    List<WoundOrders> selectByExample(WoundOrdersExample example);

    /**
     * @return com.trust.xfyl.entity.WoundOrders
     * @Author djj
     * @Description //TODO 根据id查询单条数据
     * @Date 11:34 2024/2/20
     * @Param [id]
     **/

    WoundOrders selectByPrimaryKey(Long id);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件修改数据
     * @Date 11:35 2024/2/20
     * @Param [record, example]
     **/

    int updateByExampleSelective(@Param("record") WoundOrders record, @Param("example") WoundOrdersExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件修改数据
     * @Date 11:35 2024/2/20
     * @Param [record, example]
     **/

    int updateByExample(@Param("record") WoundOrders record, @Param("example") WoundOrdersExample example);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据条件修改数据 返回主键且过滤空值
     * @Date 11:35 2024/2/20
     * @Param [record]
     **/

    int updateByPrimaryKeySelective(WoundOrders record);

    /**
     * @return int
     * @Author djj
     * @Description //TODO 根据id修改数据
     * @Date 11:35 2024/2/20
     * @Param [record]
     **/

    int updateByPrimaryKey(WoundOrders record);

    /**
     * @return java.lang.Long
     * @Author djj
     * @Description //TODO 自定义查询总数的方法，跟下面的查询列表是匹配的
     * @Date 11:36 2024/2/20
     * @Param [woundOrders]
     **/

    Long count(WoundOrders woundOrders);

    /**
     * @return java.util.List<com.trust.xfyl.entity.vo.WoundOrderVo>
     * @Author djj
     * @Description //TODO 自定义查询列表的方法 跟上面查询总数是匹配的
     * //TODO 且返回带有该订单关联的医生的，患者的，图片等数据列 且包含分页 传值为 page:1 count:10;
     * @Date 11:37 2024/2/20
     * @Param [woundOrders]
     **/

    List<WoundOrderVo> selectAll(WoundOrders woundOrders);

    /**
     * @return com.trust.xfyl.entity.vo.WoundOrderVo
     * @Author djj
     * @Description //TODO 根据id获取该订单关联的医生，患者，图片等信息。
     * @Date 11:38 2024/2/20
     * @Param [id]
     **/
    WoundOrderVo selectWoundOrdersById(Long id);
}