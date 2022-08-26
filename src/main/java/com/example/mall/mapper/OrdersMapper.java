package com.example.mall.mapper;

import com.example.mall.entity.Orders;
import com.example.mall.entity.OrdersVO;
import com.example.mall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersMapper extends GeneralDAO<Orders> {

    List<OrdersVO> selectOrders(@Param("userId") String userId,
                                @Param("status") String status,
                                @Param("start") int start,
                                @Param("limit") int limit);

    List<OrdersVO> selectOrdersByShopId(@Param("shopId") String shopId,
                                        @Param("status") String status,
                                        @Param("start") int start,
                                        @Param("limit") int limit);

    Integer selectOrdersCountByShopId(@Param("shopId") String shopId,
                                        @Param("status") String status);


}
