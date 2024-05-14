package com.trust.xfyl.service.impl;

import com.trust.xfyl.dao.WoundOrdersMapper;
import com.trust.xfyl.model.po.WoundOrders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单服务类
 * 提供订单的插入和更新操作
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService {
    // 订单数据访问对象
    private final WoundOrdersMapper woundOrdersMapper;

    /**
     * 构造函数
     * @param woundOrdersMapper 订单数据访问接口
     */
    public OrderService(WoundOrdersMapper woundOrdersMapper) {
        this.woundOrdersMapper = woundOrdersMapper;
    }

    /**
     * 插入订单信息
     * @param woundOrders 订单对象
     * @return 返回插入订单后的ID
     */
    public Long insertSelective(WoundOrders woundOrders) {
        woundOrdersMapper.insertSelective(woundOrders);
        return woundOrders.getId();
    }

    /**
     * 根据主键更新订单信息
     * @param woundOrders 订单对象
     * @return 返回更新后的订单ID
     */
    public Long updateByPrimaryKeySelective(WoundOrders woundOrders) {
        woundOrdersMapper.updateByPrimaryKeySelective(woundOrders);
        return woundOrders.getId();
    }
}
