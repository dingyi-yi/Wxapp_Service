package com.Wxapp.controller;

import com.Wxapp.entity.Result;
import com.Wxapp.service.DownloadFileService;
import com.Wxapp.service.UnloadImageService;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ding
 * 图片上传层
 */
@Controller
public class UnloadFile {

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
    public Result unloadFile(@RequestHeader("token") String token, HttpServletRequest formData,
                             @RequestParam("file") MultipartFile file)
    {
        Result UnloadResult=UnloadService.Service(token,formData,file);
        return UnloadResult;
    }


    /**
     * 下载图片
     * @param token
     * @param data
     * @return
     */
    @Autowired
    DownloadFileService downloadFileService=new DownloadFileService();
    @ResponseBody
    @RequestMapping(value = "DownloadFile",method = RequestMethod.POST)
    public Result downloadFile(@RequestHeader("token")String token,@RequestBody JSONObject data)
    {
       Result result=downloadFileService.service(token,data);
       return result;
    }
}
