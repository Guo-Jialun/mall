package com.example.mall.config;

import com.example.mall.interceptor.CheckTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private CheckTokenInterceptor checkTokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkTokenInterceptor)
                .addPathPatterns("/shopcart/**")
                .addPathPatterns("/orders/**")
                .addPathPatterns("/useraddr/**")
                .addPathPatterns("/user/check")
                .addPathPatterns("/user/becomevip")
                .addPathPatterns("/user/info")
                .addPathPatterns("/product/addcomment")
                .addPathPatterns("/shop/add")
                .addPathPatterns("/shop/listshopsbyuserid")
                .addPathPatterns("/shop/delete")
                .addPathPatterns("/shop/updateproduct")
                .addPathPatterns("/shop/addproductparam")
                .addPathPatterns("/shop/updateproductparam")
                .addPathPatterns("/shop/deleteproduct");
    }

}
