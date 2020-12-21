package com.Wxapp.service;

import com.Wxapp.dao.OrderImage;
import com.Wxapp.dao.UserAccount;
import com.Wxapp.entity.Result;
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
        //检测订单号
        String OrderId=formData.getParameter("OrderId");
        if (null==OrderId) {
            result.setCode(0);
            result.setRepMess("订单发布无效，上传图片失败");
            return result;
        }
        if(null!=file)
        {
            try {
                //获取文件字节
                byte[] filebyte=file.getBytes();
                OrderImage orderimage=new OrderImage(user.getOpenId(),OrderId,filebyte);
                //写入数据库
                OrdImgMapper.insertImage(orderimage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        result.setCode(1);
        result.setRepMess("发布成功");
        return result;
    }

}
