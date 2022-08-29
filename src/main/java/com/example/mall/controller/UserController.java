package com.example.mall.controller;

import com.example.mall.annotation.AuthAdmin;
import com.example.mall.entity.User;
import com.example.mall.service.UserService;
import com.example.mall.utils.TokenUtil;
import com.example.mall.vo.ResStatus;
import com.example.mall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(value = "提供用户的登录和注册接口",tags = "用户管理")
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username", value = "用户登录账号",required = true),
            @ApiImplicitParam(dataType = "string",name = "password", value = "用户登录密码",required = true)
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String name, @RequestParam(value = "password") String pwd){
        ResultVO resultVO = userService.checkLogin(name, pwd);
        logger.info(resultVO.getMsg());
        return resultVO;
    }



    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username", value = "用户注册账号",required = true),
            @ApiImplicitParam(dataType = "string",name = "password", value = "用户注册密码",required = true)
    })
    @PostMapping("/regist")
    public ResultVO regist(@RequestBody User user){
        ResultVO resultVO = userService.userResgit(user.getUsername(), user.getPassword());
        return resultVO;
    }

    @PostMapping("/updateInfo")
    public ResultVO updateInfo(@RequestBody User user){
        ResultVO resultVO = userService.updateInfo(user);
        return resultVO;
    }

    @ApiOperation("校验token是否过期接口")
    @GetMapping("/check")
    public ResultVO userTokencheck(@RequestHeader("token") String token){
        return new ResultVO(ResStatus.OK,"success",null);
    }

    @GetMapping("/becomevip")
    public ResultVO becomeVIP(@RequestParam("username") String name){
        return userService.becomeVIP(name);
    }
    @GetMapping("/info")
    public ResultVO getInfomation(@RequestHeader("token") String token){
        String username= TokenUtil.getUsername(token);
        return userService.getUserInfo(username);
    }

    //列出所有用户
    @GetMapping("/listUsers")
    @AuthAdmin
    public ResultVO listAllUser(){
        ResultVO resultVO = userService.listAllUser();
        return resultVO;
    }

    //删除用户
    @GetMapping("/deleteUser")
    @AuthAdmin
    public ResultVO deleteProduct(int userId,@RequestHeader("token")String token){
        ResultVO resultVO = userService.deleteUser(userId);
        return resultVO;
    }
}