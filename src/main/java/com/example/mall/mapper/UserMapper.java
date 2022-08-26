package com.example.mall.mapper;


import com.example.mall.entity.User;
import com.example.mall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper  extends GeneralDAO<User> {
    /*通过use_Id 删除该用户，修改user表*/
    void deleteUser(int userId);
    /*找出所有的用户*/
    List<User> listAllUser();
}
