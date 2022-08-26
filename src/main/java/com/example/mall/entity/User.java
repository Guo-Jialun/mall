package com.example.mall.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.Date;

@Repository
public class User {
    /**
     * 主键id 用户id
     */
    @Id
    @Column(name="user_Id")
    private Integer userId;
    /**
     * 用户名 用户名
     */
    @Column(name = "username")
    private String username;
    /**
     * 性别 M(男) or F(女)
     */
    @Column(name = "user_sex")
    private String userSex;
    /**
     * 密码 密码
     */
    @Column(name = "password")
    private String password;
    /**
     * 邮箱地址 邮箱地址
     */
    @Column(name = "user_email")
    private String userEmail;
    /**
     * 昵称 昵称
     */
    @Column(name = "nickname")
    private String nickname;
    /**
     * 真实姓名 真实姓名
     */
    @Column(name = "realname")
    private String realname;
    /**
     * 手机号 手机号
     */
    @Column(name = "user_mobile")
    private String userMobile;
    /**
     * 头像 头像
     */
    @Column(name = "user_Img")
    private String userImg;
    /**
     * 生日 生日
     */
    @Column(name = "user_birth")
    Date user_birth;
    /**
     * 注册时间 创建时间
     */
    @Column(name = "user_regtime")
    Date user_regtime;  /*注册时间*/
    /**
     *判断是否为管理员
     */
    @Column(name = "isAdmin")
    private Boolean isAdmin; //是否为管理员
    /**
     * 判断是否为店家
     */
    @Column(name = "isShopKeeper")
    private Boolean isShopKeeper; //是否为店家
    /**
     * 判断是否为VIP
     */
    @Column(name = "isVIP")
    private Boolean isVIP ;//是否为会员

    @Column(name="user_address")
    private String userAddress;

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public Date getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(Date user_birth) {
        this.user_birth = user_birth;
    }

    public Date getUser_regtime() {
        return user_regtime;
    }

    public void setUser_regtime(Date user_regtime) {
        this.user_regtime = user_regtime;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean isShopKeeper() {
        return isShopKeeper;
    }

    public void setShopKeeper(Boolean shopKeeper) {
        isShopKeeper = shopKeeper;
    }

    public Boolean isVIP() {
        return isVIP;
    }

    public void setVIP(Boolean VIP) {
        isVIP = VIP;
    }

    public User(Integer userId, String username, String userSex, String password, String userEmail, String nickname, String realname, String userMobile, String userImg, Date user_birth, Date user_regtime,String userAddress) {
        this.userId = userId;
        this.username = username;
        this.userSex = userSex;
        this.password = password;
        this.userEmail = userEmail;
        this.nickname = nickname;
        this.realname = realname;
        this.userMobile = userMobile;
        this.userImg = userImg;
        this.user_birth = user_birth;
        this.user_regtime = user_regtime;
        this.userAddress=userAddress;
    }

    public User() {
    }
}
