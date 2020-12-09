package com.Wxapp.controller;

import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.InLoadResult;
import com.Wxapp.entity.OrderMaResult;
import com.Wxapp.service.CheckTokenService;
import com.Wxapp.service.OrderMService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 首页（index）内发生的请求
 */
@Controller
public class IndexCont {

    @Autowired
    CheckTokenService checktoken=new CheckTokenService();

    /**
     * 加载页面时，向此函数发生请求
     * @param token
     * @return 页面默认数据
     */
    @ResponseBody
    @RequestMapping(value = "index",method = RequestMethod.POST)
    public InLoadResult ipageload(@RequestHeader("token")String token){
        UserAccount user=checktoken.CheckToken(token);
        InLoadResult loadrsult=new InLoadResult();
        if (null==user){
            loadrsult.setCode(0);
            loadrsult.setRepMess("token无效，重新登陆");
        }
        return null;
    }


    /**
     * 预约维修时，在搜索框中查询电器时，向此函数发生请求
     * @param token
     * @param EleAppliance 请求的电器名称
     * @return 维修点的列表
     */
    @Autowired
    OrderMService orderservice=new OrderMService();
    @ResponseBody
    @RequestMapping(value = "OrderMaintain",method = RequestMethod.POST)
    public OrderMaResult OrderMaintain(@RequestHeader("token") String token, @RequestBody JSONObject data){
        OrderMaResult orderresult=orderservice.OrderService(token,data);
        return orderresult;
    }

}
