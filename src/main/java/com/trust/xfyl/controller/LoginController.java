package com.trust.xfyl.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.trust.xfyl.dao.UsersMapper;
import com.trust.xfyl.entity.Users;
import com.trust.xfyl.entity.UsersExample;
import com.trust.xfyl.entity.dto.WxConfig;
import com.trust.xfyl.util.utils.ResultUtils;
import com.trust.xfyl.util.utils.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信登录控制器
 *
 * @Description 处理微信登录相关的请求
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
@RestController
@RequestMapping("/wxapi/login")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final UsersMapper usersMapper;
    private final WxConfig wxConfig;

    /**
     * 构造函数
     *
     * @param usersMapper 用户数据访问对象
     * @param wxConfig 微信配置对象
     */
    public LoginController(UsersMapper usersMapper, WxConfig wxConfig) {
        this.usersMapper = usersMapper;
        this.wxConfig = wxConfig;
    }

    /**
     * 处理微信登录请求
     *
     * @param code 微信授权码
     * @param nickName 用户昵称
     * @param avatarUrl 用户头像地址
     * @param email 用户邮箱
     * @return 登录结果
     */
    @RequestMapping("/wxLogin")
    public ResultVo wxLogin(@RequestParam("code") String code,
                            @RequestParam("nickName") String nickName,
                            @RequestParam("avatarUrl") String avatarUrl,
                            @RequestParam("email") String email) {
        if (code == null || nickName == null || avatarUrl == null || email == null) {
            return ResultUtils.error("参数不能为空");
        }

        Map<String, String> map = new HashMap<>(4);
        map.put("appid", wxConfig.getAppId());
        map.put("secret", wxConfig.getAppSecret());
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");

        String body = "";
        try {
            body = HttpRequest.get("https://api.weixin.qq.com/sns/jscode2session").form(map).body();
            JSONObject responseJson = JSONObject.parseObject(body);
            String unionid = responseJson.getString("unionid");
            String openid = responseJson.getString("openid");
            // 检查微信接口返回是否有错
            if (responseJson.containsKey("errorCode")) {
                return ResultUtils.error(responseJson.getString("errmsg"));
            }

            UsersExample usersExample = new UsersExample();
            usersExample.createCriteria().andOpenidEqualTo(openid);
            List<Users> usersList = usersMapper.selectByExample(usersExample);
            if (usersList.size() > 0) {
                Users userInDb = usersList.get(0);
                // 用户已存在，更新最后登录时间
                userInDb.setLastLoginTime(new Date());
                userInDb.setAvatarUrl(avatarUrl);
                usersMapper.updateByPrimaryKeySelective(userInDb);
                // 返回更新后的用户信息
                return ResultUtils.success("用户已存在，更新登录时间成功", userInDb);
            } else {
                Users users = new Users();
                users.setOpenid(openid);
                users.setNickname(nickName);
                users.setAvatarUrl(avatarUrl);
                users.setEmail(email);
                users.setCreateTime(new Date());
                users.setLastLoginTime(new Date());
                users.setIsDelete(0);
                int result = usersMapper.insertSelective(users);
                if (result > 0) {
                    return ResultUtils.success("获取成功", users);
                } else {
                    return ResultUtils.error("获取失败");
                }
            }
        } catch (Exception e) {
            logger.error("登录处理异常：", e);
            return ResultUtils.error("处理异常");
        }
    }

    /**
     * 使用简单的哈希函数对敏感信息进行脱敏
     * @param input 敏感信息
     * @return 脱敏后的信息
     */
    private String hash(String input) {
        return input.hashCode() + "";
    }
}

