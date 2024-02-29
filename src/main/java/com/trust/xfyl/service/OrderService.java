package com.trust.xfyl.service;

import com.trust.xfyl.dao.WoundOrdersMapper;
import com.trust.xfyl.entity.WoundOrders;
import org.springframework.stereotype.Service;

/**
 * @author LENOVO
 */
@Service
public class OrderService {
    private final WoundOrdersMapper woundOrdersMapper;

    public OrderService(WoundOrdersMapper woundOrdersMapper) {
        this.woundOrdersMapper = woundOrdersMapper;
    }

    public Long insertSelective(WoundOrders woundOrders) {
        woundOrdersMapper.insertSelective(woundOrders);
        return woundOrders.getId();
    }

    public Long updateByPrimaryKeySelective(WoundOrders woundOrders) {
        woundOrdersMapper.updateByPrimaryKeySelective(woundOrders);
        return woundOrders.getId();
    }
}
