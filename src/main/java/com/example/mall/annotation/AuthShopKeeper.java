package com.example.mall.annotation;

import java.lang.annotation.*;

//说明该注解将被包含在javadoc中
@Documented
//可以在方法和类上使用注解
@Target({ElementType.METHOD,ElementType.TYPE})
// 定义的这个注解是注解会在class字节码文件中存在，在运行时可以通过反射获取到。
@Retention(RetentionPolicy.RUNTIME)
// 子类可以继承父类中的该注解
@Inherited
public @interface AuthShopKeeper {
//商家权限注释
}
