package com.Wxapp.service.merchantdao;

import com.Wxapp.dao.merchantdao.Evaluation;
import com.Wxapp.dao.orderdao.ProcesserOrder;
import com.Wxapp.dao.userdao.UserAccount;
import com.Wxapp.entity.Result;
import com.Wxapp.mapper.EvaluationMapper;
import com.Wxapp.mapper.ProcesserOrderMapper;
import com.Wxapp.mapper.TakeOrderMapper;
import com.Wxapp.service.userservice.CheckTokenService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ding
 * 用户对商家进行评价
 */
@Service
public class EvaluationService {



    @Autowired
    CheckTokenService checkTokenService=new CheckTokenService();

    @Autowired
    EvaluationMapper evaluationMapper;

    @Autowired
    ProcesserOrderMapper processerOrderMapper;

    public Result service(String token, JSONObject data)
    {
        Result result=new Result();
        //检测用户
        UserAccount user= checkTokenService.CheckToken(token);
        if (null==user)
        {
            result.setCode(0);
            result.setRepMess("token无效，请重新登陆");
            return result;
        }

        //评论实体对象
        Evaluation evaluation=new Evaluation();

        /*
        获取参数,并构造
         */
        if (!evaluation.setvalue(data))
        {
            result.setCode(0);
            result.setRepMess("参数错误");
            return result;
        }
        evaluation.setOpenId(user.getOpenId());

        ProcesserOrder processerOrder=processerOrderMapper.selecteByOpenIdAOrderId(user.getOpenId(),evaluation.getOrderId());
        evaluation.setMerchantId(processerOrder.getHandler());

        /*
        写入数据库
         */
        evaluationMapper.insertEvaluationMapper(evaluation);

        result.setCode(1);
        result.setRepMess("评论成功");
        return result;
    }

}
