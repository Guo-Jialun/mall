package com.example.mall.controller;


import com.example.mall.entity.Orders;
import com.example.mall.service.OrderService;
import com.example.mall.vo.ResStatus;
import com.example.mall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/order")
@Api(value = "提供订单相关的操作接口",tags = "订单管理")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/updatestatus")
    public ResultVO updateOrderStatus(String orderId, String status){
        int i=orderService.updateOrderStatus(orderId,status);
        if(i==1){
            return new ResultVO(ResStatus.OK,"success",null);
        }else if(i==0){
            return new ResultVO(ResStatus.NO,"找不到订单",null);
        }else{
            return new ResultVO(ResStatus.NO,"有多个目标订单",null);
        }
    }

    @PostMapping("/add")
    public ResultVO add(String cids, @RequestBody Orders order){
        ResultVO resultVO = null;
        String msg = "订单提交成功！";
        List<Map<String, String>> result = new ArrayList<>();
        try {
            List<Map<String, String>> orderInfos = orderService.addOrder(cids, order);
            for (Map<String, String> orderInfo: orderInfos) {
                if(orderInfo!=null){
                    String orderId = orderInfo.get("orderId");
                    //设置当前订单信息
                    HashMap<String,String> data = new HashMap<>();
                    data.put("body",orderInfo.get("productNames"));  //商品描述
                    data.put("out_trade_no",orderId);               //使用当前用户订单的编号作为当前支付交易的交易号
                    data.put("fee_type","CNY");                     //支付币种
                    //data.put("total_fee",order.getActualAmount()*100+"");          //支付金额
                    data.put("total_fee","1");
                    data.put("trade_type","NATIVE");                //交易类型
                    data.put("notify_url","http://47.118.45.73:8080/pay/callback");           //设置支付完成时的回调方法接口
                    result.add(orderInfo);
                    if (orderId == null) {
                        System.out.println("aaaaaaaaaa");
                        msg = orderInfo.get("productNames") + " 库存不足！";
                        return new ResultVO(ResStatus.NO, msg, result);
                    }
                }
            }
            resultVO = new ResultVO(ResStatus.OK, msg, result);
        } catch (SQLException e) {
            resultVO = new ResultVO(ResStatus.NO,"提交订单失败！",null);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = new ResultVO(ResStatus.NO,"提交订单失败！",null);
        }
        return resultVO;
    }

    @GetMapping("/delete")
    public ResultVO deleteBy(String orderIds){
        return orderService.deleteOrders(orderIds);
    }


    //立即购买接口
    @PostMapping("/addInstance")
    public ResultVO addInstance(String productId, @RequestBody Orders order){
        ResultVO resultVO = null;
        try {
            Map<String, String> orderInfo = orderService.addInstanceOrder(productId, order);
            if(orderInfo!=null){
                resultVO = new ResultVO(ResStatus.OK,"提交订单成功！",orderInfo);
            }else{
                resultVO = new ResultVO(ResStatus.NO,"提交订单失败！",null);
            }
        } catch (SQLException e) {
            resultVO = new ResultVO(ResStatus.NO,"提交订单失败！",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    @GetMapping("/status/{oid}")
    public ResultVO getOrderStatus(@PathVariable("oid") String orderId,@RequestHeader("token")String token){
        ResultVO resultVO = orderService.getOrderById(orderId);
        return resultVO;
    }

    @GetMapping("/list")
    @ApiOperation("订单查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "userId", value = "用户ID",required = true),
            @ApiImplicitParam(dataType = "string",name = "status", value = "订单状态",required = false),
            @ApiImplicitParam(dataType = "int",name = "pageNum", value = "页码",required = true),
            @ApiImplicitParam(dataType = "int",name = "limit", value = "每页条数",required = true)
    })
    public ResultVO list(@RequestHeader("token")String token,
                         String userId,String status,int pageNum,int limit){
        ResultVO resultVO = orderService.listOrders(userId, status, pageNum, limit);
        return resultVO;
    }

    @GetMapping("/listByShopId")
    public ResultVO listByShopId(String shopId,String status,int pageNum,int limit) {
        return orderService.listOrdersByShopId(shopId, status, pageNum, limit);
    }

}
