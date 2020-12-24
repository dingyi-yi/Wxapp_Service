package com.Wxapp.controller;

import com.Wxapp.entity.OrderMaResult;
import com.Wxapp.entity.Result;
import com.Wxapp.service.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;




/**
 * 首页（index）内发生的请求
 */
@Controller
public class IndexCont {



    /**
     * 加载页面时，向此函数发生请求
     * @param token
     * @return 页面默认数据
     */
    @Autowired
    GainActivityService gainActivityService=new GainActivityService();
    @ResponseBody
    @RequestMapping(value = "IndexOnload",method = RequestMethod.POST)
    public Result indexOnload(@RequestHeader("token")String token,@RequestBody JSONObject data){
        Result result=gainActivityService.service(token,data,1);
        return result;
    }


    /**
     * 预约维修时，在搜索框中查询电器时，向此函数发生请求
     */
    @Autowired
    OrderMService orderservice=new OrderMService();
    @ResponseBody
    @RequestMapping(value = "OrderMaintain",method = RequestMethod.POST)
    public OrderMaResult OrderMaintain(@RequestHeader("token") String token, @RequestBody JSONObject data){
        OrderMaResult orderresult=orderservice.OrderService(token,data);
        return orderresult;
    }


    /**
     * 发布订单接收函数,不包含图片
     * @return
     */
    @Autowired
    PostOrderService postorderservice=new PostOrderService();
    @ResponseBody
    @RequestMapping(value = "PostOrder",method = RequestMethod.POST)
    public Result PostOrder(@RequestHeader("token") String token,@RequestBody JSONObject data){

        Result postresult=postorderservice.Service(token,data);
        return postresult;
    }


    /**
     * 发布活动，不包含图片
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "PostActivity",method = RequestMethod.POST)
    public Result postActivity(@RequestHeader("token") String token, @RequestBody JSONObject data){
        return null;
    }


    /**
     * 在线接单
     * @return
     */
    @Autowired
    AdoptOrderService adoptOrderService=new AdoptOrderService();
    @ResponseBody
    @RequestMapping(value = "AdoptOrder",method = RequestMethod.POST)
    public Result adoptOrder(@RequestHeader("token") String token, @RequestBody JSONObject data){
        Result result=adoptOrderService.service(token,data);
        return result;
    }


    /**
     * 接单服务时，获取订单列表,以及在线接单时，查询订单服务
     * @param token
     * @param data
     * @return
     */
    @Autowired
    GainOrderService gainOrderService=new GainOrderService();
    @ResponseBody
    @RequestMapping(value = "GainOrder",method = RequestMethod.POST)
    public Result GainOrder(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=gainOrderService.service(token,data,2);
        return result;
    }


    /**
     * 获取价格参考
     * @param token
     * @param data
     * @return
     */
    @Autowired
    PriceRefenceService priceRefenceService=new PriceRefenceService();
    @ResponseBody
    @RequestMapping(value = "PriceRefence",method = RequestMethod.POST)
    public Result priceRefence(@RequestHeader("token") String token, @RequestBody JSONObject data)
    {
        Result result=priceRefenceService.service(token,data);
        return result;
    }


}
