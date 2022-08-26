package com.example.mall.service;

import com.example.mall.entity.ShoppingCart;
import com.example.mall.vo.ResultVO;

public interface ShoppingCartService {
    public ResultVO addShoppingCart(ShoppingCart cart);

    public ResultVO listShoppingCartsByUserId(int userId);

    public ResultVO updateCartNum(int cartId,int cartNum);

    public ResultVO listShoppingCartsByCids(String cids);

    public ResultVO deleteShoppingCart(String cids);
}
