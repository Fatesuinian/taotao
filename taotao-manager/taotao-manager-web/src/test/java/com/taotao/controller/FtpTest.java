package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FtpTest {
	
	@Test
	public void testFtpClient() throws Exception {
		//创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		//创建ftp连接，默认端口21
		ftpClient.connect("115.159.188.102", 22);
		//登录ftp服务器，使用用户名密码
		ftpClient.login("root", "root");
		//上传文件
		//读取本地文件
		FileInputStream inputSteam = new FileInputStream(new File("D:\\Git\\1.jpg"));
		//设置上传的路径
		ftpClient.changeWorkingDirectory("/home/images");
		//修改上传文件的格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//第一个参数：服务器端文档名
		//第二个参数：	上传文档的inputSteam
		ftpClient.storeFile("2.jpg", inputSteam);
		//关闭连接
		ftpClient.logout();
	}

}
