package com.example.mall.service;


import com.example.mall.entity.User;
import com.example.mall.vo.ResultVO;


public interface UserService {
    //用户注册
    ResultVO userResgit(String name, String pwd);
    //用户登录
    ResultVO checkLogin(String name, String pwd);
    ResultVO updateUserImg(int userId,String url);
    //注册成为VIP
    ResultVO becomeVIP(String name);

    ResultVO getUserInfo(String name);

    ResultVO updateInfo(User user);
    //管理员删除用户
    ResultVO deleteUser(int userId);
    //管理员查看所有用户
    ResultVO listAllUser();
}
