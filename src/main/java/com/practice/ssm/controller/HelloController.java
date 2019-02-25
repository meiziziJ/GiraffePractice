package com.practice.ssm.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-01-23 17:26
 */
@Controller
public class HelloController {
    String serverPath = "/ssm/upload";

    /**
     *  遵循struts2原有的struts-sy.xml页面跳转配置
     *
     *   <package>
     *       <action name="" class="" namespace="">
     *           <result name="">跳转页面</result>
     *       </action>
     *   </package>
     *
     * RequetMapping 替换掉原有的action标签的配置
     *  "括号内值" 是给action的属性name赋值
     * @return
     */
    @RequestMapping("/hi")
    public String sayHello(){
        System.out.println("hello springMvc");
        return "hello";
    }

    @RequestMapping("/hi2")
    public ModelAndView sayHello2(){
        ModelAndView mav = new ModelAndView();
        System.out.println("hello2 springMvc");
        mav.addObject("thing","我就是这个，这个就是我");
        //serViewName （设置跳转的视图jsp名字）
        mav.setViewName("hello");
        return mav;
    }

    /**
     * 测试注解 @requestParam 当其属性required为true时，如果不传指定属性值将无法访问该方法
     *   command ：分页
     * @param name
     * @return
     */
    @RequestMapping("/hi3")
    public String sayHello3(@RequestParam(value = "name", required = true) String name){
        System.out.println("hello3 springMvc");
        return "hello";
    }

    @RequestMapping("/i18n")
    public String changeLanguage(String state, HttpSession session){
        if("中文".equals(state)){
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
        }else{
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.US);
        }
        return "i18n";
    }

    /**
     * springmvc上传到本地硬盘，添加tomcat服务器映射关系
     * @param file
     * @param req
     * @return
     */
    @RequestMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest req){
        /*String filename = file.getOriginalFilename();
        String realpath = req.getServletContext().getRealPath(serverPath+filename);*/
        try {
            //FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realpath));
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E://temp/"+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "i18n";
    }
}
