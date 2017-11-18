package com.xyf.upload;

/*import com.xyf.ddshop.common.util.FtpUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

*//**
 * User: Administrator
 * Date: 2017/11/17
 * Time: 19:35
 * Version:V1.0
 *//*
public class FtpUploadTest {
    @Test
    public void testFtpUpload() throws Exception{
        //创建FTPClient客户端
        FTPClient ftpClient = new FTPClient();
        //创建FTP连接
        ftpClient.connect("10.31.161.47",21);
        //登录
        ftpClient.login("ftpuser","qaz123xyf");
        //读取本地文件
        FileInputStream fs=new FileInputStream(new File("E:\\001.jpg"));
        //配置上传参数
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //上传文件
        ftpClient.storeFile("hello.jpg",fs);
        //关闭连接
        fs.close();
        ftpClient.logout();
    }
    @Test
    public void testFtpUtil() throws Exception{
        FileInputStream fs = new FileInputStream(new File("E:\\001.jpg"));
        FtpUtils.uploadFile("10.31.161.47",21,"ftpuser","qaz123xyf","/home/ftpuser/www/images","/2017/11/17","hello2.jpg",fs);
    }
}*/
