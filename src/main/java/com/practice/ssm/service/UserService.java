package com.practice.ssm.service;

import com.practice.ssm.model.User;

public interface UserService {

    User queryUserByName(String userName);
}