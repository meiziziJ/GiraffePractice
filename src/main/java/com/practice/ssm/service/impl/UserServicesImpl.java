package com.practice.ssm.service.impl;

import com.practice.ssm.mapper.UserMapper;
import com.practice.ssm.model.User;
import com.practice.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-02-19 14:29
 *
 * 根据spring注解auto wired注入方式，需要指定service名，才可实现功能注入
 */
@Service("userService")
public class UserServicesImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByName(String userName) {
        return this.userMapper.queryUserByName(userName);
    }
}
