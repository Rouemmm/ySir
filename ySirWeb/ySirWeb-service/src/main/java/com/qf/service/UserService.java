package com.qf.service;

import com.qf.pojo.User;

/**
 * @program: ySirWeb
 * @description:
 * @encoder: Roue
 * @create: 2020-06-30 17:04
 **/
public interface UserService {

    User loginUser(String email, String password);
}
