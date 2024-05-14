package com.trust.xfyl.service.impl;

import com.trust.xfyl.dao.WoundFollowMapper;
import com.trust.xfyl.model.po.WoundFollow;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 伤口跟进服务类
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class WoundFollowService {
    // 伤口跟进的DAO层接口
    private final WoundFollowMapper woundFollowMapper;

    /**
     * 构造函数
     * @param woundFollowMapper 伤口跟进的DAO层接口实例
     */
    public WoundFollowService(WoundFollowMapper woundFollowMapper) {
        this.woundFollowMapper = woundFollowMapper;
    }

    /**
     * 增加伤口跟进信息
     * @param woundFollow 待增加的伤口跟进实例
     * @return 返回新增伤口跟进的ID
     */
    public Long insertSelective(WoundFollow woundFollow) {
        woundFollowMapper.insertSelective(woundFollow);
        return woundFollow.getId();
    }

    /**
     * 根据主键更新伤口跟进信息
     * @param woundFollow 待更新的伤口跟进实例
     * @return 返回更新后的伤口跟进的ID
     */
    public Long updateByPrimaryKeySelective(WoundFollow woundFollow) {
        woundFollowMapper.updateByPrimaryKeySelective(woundFollow);
        return woundFollow.getId();
    }

}
