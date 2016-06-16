package com.evan.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadFileAction {

	/**
	 * 上传文件主页面
	 */
	
	@RequestMapping("/toUploadFileView1")
	public String toUploadFileView1() {
		return "uploadFile1";
	}

	/**
	 * 1、最原始的输入输出流复制文件（IO流）
	 */
	@RequestMapping("/parserUploadFile1")
	public String parserUploadFile1(MultipartFile file) throws IOException {
		String realPath = "E:/";
		InputStream is = file.getInputStream();
		String fileName = file.getOriginalFilename();
		FileOutputStream os = new FileOutputStream(realPath
				+ new Date().getTime() + file.getOriginalFilename());
		int i = 0;
		while ((i = is.read()) != -1) {
			os.write(i);
		}
		os.flush();
		os.close();
		is.close();
		return "success";
	}
	@RequestMapping("/toUploadFileView2")
	public String toUploadFileView() {
		return "uploadFile2";
	}

	/**
	 * 2、通过apache自带的FileUtils工具类进行复制上传文件
	 */
	@RequestMapping("/parserUploadFile2")
	public String parserUploadFile2(MultipartFile file) throws IOException {
		String realPath = "E:/";

		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
				realPath, file.getOriginalFilename()));

		return "success";
	}

	

	@RequestMapping("/toUploadFileView3")
	public String toUploadFileView3() {
		return "uploadFile3";
	}

	/**
	 * 3、通过springMVC提供的API上传文件
	 */
	@RequestMapping("/parserUploadFile3")
	public String parserUploadFile3(MultipartFile file) throws IOException {
		String realPath = "E:/";
		
		file.transferTo(new File(realPath+file.getOriginalFilename()));

		return "success";
	}

}
