package com.Wxapp.service;

import com.Wxapp.dao.ActiveImage;
import com.Wxapp.dao.OrderImage;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.ActiveImageMapper;
import com.Wxapp.mapper.OrderImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ding
 */
@Service
public class UnloadImageService {

    @Autowired
    CheckTokenService checktoken=new CheckTokenService();

    @Autowired
    OrderImageMapper OrdImgMapper;

    @Autowired
    ActiveImageMapper activeImageMapper;

    public Result Service(String token, HttpServletRequest formData, MultipartFile file)
    {
        Result result=new Result();
        //检测用户
        UserAccount user= checktoken.CheckToken(token);
        if (null==user)
        {
            result.setCode(0);
            result.setRepMess("token无效，请重新登陆");
            return result;
        }
        //检测订单/活动编号
        String OAId=formData.getParameter("OAId");
        if (null==OAId) {
            result.setCode(0);
            result.setRepMess("订单发布无效，上传图片失败");
            return result;
        }

        //获取类型
        int type= Integer.parseInt(formData.getParameter("Type"));
        if (type==1)
        {//订单图片
            orderImage(user.getOpenId(),OAId,file);
        }else if (type==2)
        {//活动图片
            activityImage(user.getOpenId(),OAId,file);
        }

        result.setCode(1);
        result.setRepMess("发布成功");
        return result;
    }


    /**
     * 订单上图片
     * @param OpenId 发布者openid
     * @param OrderId 订单编号
     * @param file 图片
     * @return
     */
    public boolean orderImage(String OpenId, String OrderId,MultipartFile file)
    {
        if(null!=file)
        {
            try {
                //获取文件字节
                byte[] filebyte=file.getBytes();
                OrderImage orderimage=new OrderImage(OpenId,OrderId,filebyte);
                //写入数据库
                OrdImgMapper.insertImage(orderimage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 活动上传图片
     * @param OpenId 发布者openid
     * @param ActiveId 活动编号
     * @param file 图片
     * @return
     */
   public boolean activityImage(String OpenId,String ActiveId,MultipartFile file)
   {
       if (null!=null)
       {
           try {
               byte[] filebyte=file.getBytes();
               ActiveImage activeImage=new ActiveImage(OpenId,ActiveId,filebyte);
               activeImageMapper.insertActiveImage(activeImage);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return false;
   }

}
