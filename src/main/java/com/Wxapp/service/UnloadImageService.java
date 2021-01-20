package com.Wxapp.service;

import com.Wxapp.dao.activitydao.ActiveImage;
import com.Wxapp.dao.casesharedao.CaseImage;
import com.Wxapp.dao.communtitydao.CommunityImage;
import com.Wxapp.dao.orderdao.OrderImage;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.ActiveImageMapper;
import com.Wxapp.mapper.CaseImageMapper;
import com.Wxapp.mapper.CommunityImageMapper;
import com.Wxapp.mapper.OrderImageMapper;
import com.Wxapp.service.userservice.CheckTokenService;
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
        //检测编号（订单/活动/案例）
        String OAId=formData.getParameter("OAId");
        if (null==OAId) {
            result.setCode(0);
            result.setRepMess("订单发布无效，上传图片失败");
            return result;
        }

        boolean ret=false;
        //获取类型
        int type= Integer.parseInt(formData.getParameter("Type"));
        if (type==1)
        {//订单图片
           ret=orderImage(user.getOpenId(),OAId,file);
        }else if (type==2)
        {//活动图片
            ret=activityImage(user.getOpenId(),OAId,file);
        }else if (type==3)
        {//案例上传
            ret=caseImage(user.getOpenId(),OAId,file);
        }else if (type==4)
        {
            ret=communityImage(user.getOpenId(),OAId,file);
        }

        if (ret)
        {
            result.setCode(1);
            result.setRepMess("发布成功");
            return result;
        }
        result.setCode(0);
        result.setRepMess("发布失败");
        return result;
    }




    /**
     * 订单上图片
     * @param OpenId 发布者openid
     * @param OrderId 订单编号
     * @param file 图片
     * @return
     */
    @Autowired
    OrderImageMapper OrdImgMapper;
    public boolean orderImage(String OpenId, String OrderId,MultipartFile file)
    {
        if(file!=null)
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
            return true;
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
    @Autowired
    ActiveImageMapper activeImageMapper;
   public boolean activityImage(String OpenId,String ActiveId,MultipartFile file)
   {
       if (file!=null)
       {
           try {
               byte[] filebyte=file.getBytes();
               ActiveImage activeImage=new ActiveImage(OpenId,ActiveId,filebyte);
               activeImageMapper.insertActiveImage(activeImage);
           } catch (IOException e) {
               e.printStackTrace();
           }
           return true;
       }
       return false;
   }



    /**
     * 案例图片上传
     * @param OpenId 发布者openid
     * @param CaseId 案例编号
     * @param file 图片
     * @return
     */
    @Autowired
    CaseImageMapper caseImageMapper;
   public  boolean caseImage(String OpenId,String CaseId,MultipartFile file)
   {
       if (file!=null)
       {
           try {
               byte[] filebyte=file.getBytes();
               CaseImage caseImage=new CaseImage(OpenId,CaseId,filebyte);
               caseImageMapper.insertCaseImage(caseImage);
           } catch (IOException e) {
               e.printStackTrace();
           }
           return true;
       }
       return false;
   }


    /**
     * 社区图片上传
     * @param OpenId
     * @param CommunityId
     * @param file
     * @return
     */
    @Autowired
    CommunityImageMapper communityImageMapper;
   public boolean communityImage(String OpenId,String CommunityId,MultipartFile file)
   {
       if (file!=null)
       {
           try {
               byte[] filebyte=file.getBytes();
               CommunityImage communityImage=new CommunityImage(OpenId,CommunityId,filebyte);
               communityImageMapper.insertCommunityImage(communityImage);
           } catch (IOException e) {
               e.printStackTrace();
           }
           return true;
       }
       return false;

   }
}
