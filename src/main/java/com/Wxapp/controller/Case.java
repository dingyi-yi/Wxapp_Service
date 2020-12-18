package com.Wxapp.controller;

import com.Wxapp.entity.CaseLoadResult;
import org.springframework.stereotype.Controller;

/**
 * 案例类，处理从case页面发送来的请求
 */
@Controller
public class Case {

    /**
     * 案例页面加载时，需要请求的数据
     * @return
     */
    public CaseLoadResult CaseLoad(){
        CaseLoadResult loadResult=new CaseLoadResult();
        return loadResult;
    }

}
