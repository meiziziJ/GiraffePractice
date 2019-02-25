package com.practice.ssm.util;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-02-19 16:59
 */
public class CommonUtil {

    /**
     * MultipartFile 转换成File
     *
     * @param multfile 原文件类型
     * @return File
     */
    public File multipartToFile(MultipartFile multfile) {

        CommonsMultipartFile cf = (CommonsMultipartFile)multfile;
        //这个myfile是MultipartFile的
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        File file = fi.getStoreLocation();
        return file;
    }
}
