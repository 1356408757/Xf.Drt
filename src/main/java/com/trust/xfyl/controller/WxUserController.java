package com.trust.xfyl.controller;


import com.trust.xfyl.dao.UsersMapper;
import com.trust.xfyl.entity.Users;
import com.trust.xfyl.entity.UsersExample;
import com.trust.xfyl.util.utils.ResultUtils;
import com.trust.xfyl.util.utils.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @Description
 * @author Bay-max
 * @date 2024/4/22 15:19
 **/

@RestController
@RequestMapping("/wxapi/user")
public class WxUserController {
    private final UsersMapper usersMapper;

    public WxUserController(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    /**
     * 查单个用户信息
     */
    @GetMapping("/get/{openid}")
    public ResultVo get(@PathVariable("openid") String openid){
        UsersExample usersExample =new UsersExample();
        usersExample.createCriteria().andOpenidEqualTo(String.valueOf(openid));
        List<Users> users = usersMapper.selectByExample(usersExample);
        if (users.size()>0){
            Users user = users.get(0);
            return ResultUtils.success("查询成功！",user);
        }
        return ResultUtils.error("查询失败！");
    }

}
