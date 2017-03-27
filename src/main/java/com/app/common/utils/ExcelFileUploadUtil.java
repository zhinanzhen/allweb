package com.app.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class ExcelFileUploadUtil {
	/**
	 * 文件上传
	 * @param request 请求
	 * @param inputName 文件选择框name
	 * @param impPath path.properties 中的地址配置
	 * @param fileNamePrefix 上传后保存文件名的前缀
	 * @return 上传后服务器文件地址【绝对路径+文件】
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static String fileUpload(HttpServletRequest request, String inputName, String impPath, String fileNamePrefix) throws IOException{
		Properties props = new Properties();
		props.load(ExcelFileUploadUtil.class.getClassLoader().getResourceAsStream("path.properties"));
		impPath = request.getRealPath(props.getProperty(impPath));
		String filePathName = impPath + File.separator + fileNamePrefix + TransNoUtils.getTransNo() + ".xls";
		// 转型为MultipartHttpRequest：   
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;   
        // 获得文件：   
        MultipartFile file = multipartRequest.getFile(inputName);
		InputStream stream = file.getInputStream();
		OutputStream bos = new FileOutputStream(filePathName);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
			bos.write(buffer, 0, bytesRead);
		}
		bos.close();
		stream.close();
		return filePathName;
	}

}
