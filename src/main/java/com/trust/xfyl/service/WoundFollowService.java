package com.trust.xfyl.service;

import com.trust.xfyl.dao.WoundFollowMapper;
import com.trust.xfyl.entity.WoundFollow;
import org.springframework.stereotype.Service;
/**
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Service
public class WoundFollowService {
    private final WoundFollowMapper woundFollowMapper;

    public WoundFollowService(WoundFollowMapper woundFollowMapper) {
        this.woundFollowMapper = woundFollowMapper;
    }

    public Long insertSelective(WoundFollow woundFollow) {
        woundFollowMapper.insertSelective(woundFollow);
        return woundFollow.getId();
    }

    public Long updateByPrimaryKeySelective(WoundFollow woundFollow) {
        woundFollowMapper.updateByPrimaryKeySelective(woundFollow);
        return woundFollow.getId();
    }

}
