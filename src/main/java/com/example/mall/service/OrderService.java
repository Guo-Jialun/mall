package com.example.mall.service;

import com.example.mall.entity.Orders;
import com.example.mall.vo.ResultVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface OrderService {

    public List<Map <String,String> > addOrder(String cids, Orders order) throws SQLException;

    //立即购买
    public Map<String,String> addInstanceOrder(String productId, Orders order) throws SQLException;

    public int updateOrderStatus(String orderId, String status);

    ResultVO deleteOrders(String ids);

    public ResultVO getOrderById(String orderId);

    public void closeOrder(String orderId);

    public ResultVO listOrders(String userId,String status,int pageNum, int limit);

    public ResultVO listOrdersByShopId(String shopId,String status,int pageNum, int limit);



}

