package com.example.mall.mapper;

import com.example.mall.entity.OrderItem;
import com.example.mall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemMapper extends GeneralDAO<OrderItem> {

    public List<OrderItem> listOrderItemsByOrderId(String orderId);
}
