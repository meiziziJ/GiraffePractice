package com.practice.ssm.controller;

import com.practice.ssm.util.CommonUtil;
import com.practice.ssm.util.ExecuteResult;
import com.practice.ssm.util.QiNiuUtil;
import com.qiniu.api.auth.AuthException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.json.JSONException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-02-19 16:58
 */
@Controller
@RequestMapping(value = "")
public class QiNiuController {
    /**
     * @param request
     * @param multipartFile
     * @return
     */
    @RequestMapping(value = "/qiniuUpload", method = RequestMethod.POST)
    @ResponseBody
    public String qiniuUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam("imagefile") MultipartFile multipartFile) {
        QiNiuUtil qiniuUtil = new QiNiuUtil();
        CommonUtil commonUtil = new CommonUtil();

        ExecuteResult<String> executeResult = new ExecuteResult<String>();

        try {
            /**
             * 上传文件扩展名    图片上传至七牛之后的文件名
             */
            String filenameExtension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."), multipartFile.getOriginalFilename().length());

            /*
             * MultipartFile 转 file 类型
             */
            File file = commonUtil.multipartToFile(multipartFile);

            /*
             * 七牛云文件上传 服务  file文件 以及 文件扩展名
             */
            executeResult = qiniuUtil.uploadFile(file, filenameExtension);
            if (!executeResult.isSuccess()) {
                return "失败" + executeResult.getErrorMessages();
            }

        } catch (AuthException e) {
            logger.error("AuthException", e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("上传到七牛云的图片:" + executeResult.getResult());

        return executeResult.getResult();
    }

    private static Logger logger = LoggerFactory.getLogger(QiNiuController.class);


    @RequestMapping("qiniuCommon")
    private String qiniuCommon(HttpServletRequest request){
        return "qiniuCommon";
    }

}
