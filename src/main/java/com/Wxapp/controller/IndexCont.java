package com.Wxapp.controller;

import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.InLoadResult;
import com.Wxapp.entity.OrderMaResult;
import com.Wxapp.entity.Result;
import com.Wxapp.service.CheckTokenService;
import com.Wxapp.service.OrderMService;
import com.Wxapp.service.PostOrderService;
import com.Wxapp.service.UnloadImageService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;



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
    public Result PostActivity(@RequestHeader("token") String token, @RequestBody JSONObject data){
        Result poresult=new Result();
        poresult.setCode(0);
        poresult.setRepMess("发布失败");
        return poresult;
    }


    /**
     * 在线接单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "AdoptOrder",method = RequestMethod.POST)
    public Result AdoptOrder(@RequestHeader("token") String token, @RequestBody JSONObject data){
        Result poresult=new Result();
        poresult.setCode(0);
        poresult.setRepMess("发布失败");
        return poresult;
    }


    /**
     * 上传图片
     * @param token
     * @param formData
     * @param file
     * @return
     */
    @Autowired
    UnloadImageService UnloadService=new UnloadImageService();
    @ResponseBody
    @RequestMapping(value = "UnloadFile",method = RequestMethod.POST)
    public Result UnloadFile(@RequestHeader("token") String token,HttpServletRequest formData,
                             @RequestParam("file") MultipartFile file)
    {
        Result UnloadResult=UnloadService.Service(token,formData,file);
        return UnloadResult;
    }
    

}
