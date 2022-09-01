package com.example.mall;

import com.example.mall.service.ProductService;
import com.example.mall.service.ShopService;
import com.example.mall.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ShopService shopService;

    @Test
    void contextLoads() {

    }

    @Test
    void userServiceTest() {
        System.out.println(userService.listAllUser());
    }

    @Test
    void searchProductsTest() {
        System.out.println(productService.searchProduct("iPhone", 1, 5));
    }

    @Test
    void listAllShopTest() {
        System.out.println(shopService.listAllShop());
    }
}
