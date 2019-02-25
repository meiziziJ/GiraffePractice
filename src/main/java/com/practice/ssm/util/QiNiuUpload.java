/*package com.practice.ssm.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import javax.security.auth.login.Configuration;


*//**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-02-18 20:17
 *//*

public class QiNiuUpload {

    public static void main(String[] args) {
        Configuration cfg = new Configuration(Zone.zone0());  //  zone0() 代表华东地区, zone1() 代表华北地区 , zone2() 代表华南地区
        UploadManager uploadManager = new UploadManager(cfg);

        String accessKey = "jGX8jpbgW6RiqpP_7ryYHv319IKRQxdulHrlincE";      //AccessKey的值
        String secretKey = "eEB9cnq7G3h7xwXtms9ybeHBEj6a1sOzerrRZMaU";      //SecretKey的值
        String bucket = "meizizi";                                          //存储空间名
        String localFilePath = "E:\\Temp\\stationmaster_img.png";     //上传图片路径

        String key = "456.png";                                               //在七牛云中图片的命名

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

}*/

