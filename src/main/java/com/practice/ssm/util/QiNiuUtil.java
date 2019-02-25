package com.practice.ssm.util;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.RSClient;
import com.qiniu.api.rs.URLUtils;
import com.qiniu.util.Auth;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-02-19 17:01
 */
public class QiNiuUtil {

    private static Logger logger = LoggerFactory.getLogger(QiNiuUtil.class);

    /**
     *  读取七牛个人信息，密钥ak,sk ，加载cdn域名 ，存储在七牛的存储空间名
     */
    PropertyUtil propertyUtil = new PropertyUtil();
    private String bucketName = propertyUtil.getProperty("bucketName");
    private String domain = propertyUtil.getProperty("domain");
    private String ACCESS_KEY = propertyUtil.getProperty("ACCESS_KEY");
    private String SECRET_KEY = propertyUtil.getProperty("SECRET_KEY");

   Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    /**
     * 获取网络路径，通过七牛提供的sdk属性auth
     * @param targetUrl
     * @return
     **/
    public String getDownloadUrl(String targetUrl){
        String downloadUrl = auth.privateDownloadUrl(targetUrl);
        return downloadUrl;
    }

    /**
     *  获得下载地址
     */
    /*public String getDownloadFileUrl(String filename) throws Exception {
        *//*
        mac  相当于Java访问七牛云的一个凭证
         *//*
        Mac mac = getMac();
        *//*
          获取文件在七牛云的域名加文件名
         *//*
        String baseUrl = URLUtils.makeBaseUrl(domain, filename);
        //getPolicy 获取到路径和凭证，调用方法向七牛云发送请求
        GetPolicy getPolicy = new GetPolicy();
        //发送请求获得下载文件的地址
        String downloadUrl = getPolicy.makeRequest(baseUrl, mac);
        return downloadUrl;
    }*/

    /**
     * 下载文件
     * @param fileName
     * @throws Exception
     */
    public void download(String fileName) throws Exception {
        //String downloadFileUrl = getDownloadFileUrl(fileName);
        String downloadFileUrl = getDownloadUrl(domain+fileName);

        String filePath = "E:\\Temp\\qiNiuImage";

        download(downloadFileUrl, filePath, fileName);
    }

    /**
     * 文件下载
     * @param url
     * @param filePath
     * @throws IOException
     */
    public static void download(String url, String filePath, String fileName) throws IOException {
        //创建一个OkHttpClient网络协议发送http get 请求
        OkHttpClient ok = new OkHttpClient();
        //打印网络下载路径      2019/02/23/ed97f8cb-d8c4-4c1c-abb2-5292ab0d3fb6.jpg
        System.out.println("网络路径："+url);
        //通过网络路径 获取网络request请求
        Request req = new Request.Builder().url(url).build();
        Response resp = ok.newCall(req).execute();
        /*
            如果七牛云网络对我们发送的请求成功响应
             ，则。。。。
         */
        if(resp.isSuccessful()) {
            //一个抽象类，主要是持有流的作用，用来作文件读取和写入
            ResponseBody body = resp.body();
            //body获取字节输入流（做读取资源的作用）
            InputStream is = body.byteStream();
            // 获取到以byte为单位的网络资源内容
            byte[] bytes = readInputStream(is);
            System.out.println("图片单位字节:" + bytes.length);
            //得到文件
            File imgFile = new File(filePath+"\\25.jpg");
            if(!imgFile.exists()) {
                System.out.println("文件目录不存在");
                imgFile.mkdirs();
            }

            FileOutputStream fos = new FileOutputStream(imgFile);
            fos.write(bytes);
            fos.close();
        }
    }

    /**
     * 读取字节输入流内容
     * @param is
     * @return
     */
    private static byte[] readInputStream(InputStream is) {
        ByteArrayOutputStream writer = new ByteArrayOutputStream();
        byte[] buff = new byte[1024 * 2];
        int len = 0;
        try {
            while((len = is.read(buff)) != -1) {
                writer.write(buff, 0, len);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toByteArray();
    }

    //通过文件路径上传文件
    public ExecuteResult<String> uploadFile(String localFile) throws AuthException, JSONException {
        File file = new File(localFile);
        /*
         * 文件后缀名 文件扩展名
         */
        String filenameExtension = localFile.substring(localFile.lastIndexOf("."), localFile.length());
        return uploadFile(file, filenameExtension);
    }

    //通过File上传
   public ExecuteResult<String> uploadFile(File file, String filenameExtension) throws AuthException, JSONException {
        ExecuteResult<String> executeResult = new ExecuteResult<String>();
        String uptoken = getUpToken();

        // 可选的上传选项，具体说明请参见使用手册。
       //putExtra 这里我们使用的是，对象存储的表单上传方式，该类定义了符合表单上传图片的格式内容
        PutExtra extra = new PutExtra();
        SimpleDateFormat time = new SimpleDateFormat("yyyy/MM/dd");
        // 上传文件
       /*
        putret获取的是一个名字，一个key,
       *    IoApi是Java上传到七牛云空间的一个辅助类，上传方法是putfile， 参数
       *
       * */
        PutRet ret = IoApi.putFile(uptoken, time.format(new Date()) + "/" + UUID.randomUUID() + filenameExtension, file.getAbsolutePath(), extra);

        if (ret.ok()) {
            executeResult.setSuccessMessage("上传成功!");
            executeResult.setResult(domain+ret.getKey());
        } else {
            executeResult.addErrorMessage("上传失败");
        }
        return executeResult;
    }

    /**
     * 从 inputstream 中写入七牛
     *
     * @param key     文件名
     * @param content 要写入的内容
     * @return
     */
    public boolean uploadFile(String key, String content) throws AuthException, JSONException {
        // 读取的时候按的二进制，所以这里要同一
        ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes());

        String uptoken = getUpToken();

        // 可选的上传选项，具体说明请参见使用手册。
        PutExtra extra = new PutExtra();

        // 上传文件
        PutRet ret = IoApi.Put(uptoken, key, inputStream, extra);

        if (ret.ok()) {
            return true;
        } else {
            return false;
        }
    }

    //删除文件
    public void deleteFile(String filename) {
        Mac mac = getMac();
        RSClient client = new RSClient(mac);
        client.delete(domain, filename);
    }

    //获取凭证
    private String getUpToken() throws AuthException, JSONException {
        //密钥信息管理类  (七牛个人信息)
        Mac mac = getMac();
        //七牛上传资源的一个上传策略   做上传资源数据的数据回调作用
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = putPolicy.token(mac);
        return uptoken;
    }

    /**
     * 通用验证七牛密钥
     * @return
     */
    private Mac getMac() {
        Mac mac = new Mac(ACCESS_KEY, SECRET_KEY);
        return mac;
    }
}
