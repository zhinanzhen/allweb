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

/** 
 * @author xxn
 * @date 2016年12月27日  上午11:28:19
 */
public class FileUploadUtils {
	/**
	 * 工程WebRoot真实路径
	 */
	public static String contextPath = "";
	static{
		contextPath = FileUploadUtils.class.getResource("/").getPath();
		contextPath = contextPath.substring(0, contextPath.indexOf("all_web")+7)+"/";
//		contextPath = contextPath.replaceFirst("/", "");
//		contextPath = "/" + contextPath;
	}
   
	
	
	
	/**
	 * 检查上传的文件是否存在
	 * @param request
	 * @param pageFileName
	 * @return
	 */
	public static boolean checkUploadFileExists(HttpServletRequest request, String pageFileName){
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
   		MultipartFile uploadFile = multipartRequest.getFile(pageFileName);
   		String uploadFileName = uploadFile.getOriginalFilename();
   		if (ValidateUtils.isEmpty(uploadFileName)) {
			return false;
		}
   		return true;
	}
	
	
	
	
	
   
   /**
    * 处理Web文件上传
    * @param request		
    * @param savePath	要保存在哪
    * @param pageFileName	页面上文件name
    * @throws Exception
    * @author jun.liu
    */
   public static String handleFileUpload(HttpServletRequest request, String savePath , String pageFileName) throws Exception{
    OutputStream os = null;
   	InputStream is = null;
   	try {
   		//处理上传文件
   		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
   		MultipartFile uploadFile = multipartRequest.getFile(pageFileName);
   		System.out.println("本次上传文件大小【"+uploadFile.getSize()+"】");
   		if(uploadFile.getSize()<=0){
   			throw new Exception("服务器接受到的文件大小为0字节");
   		}
   		
   		String fileName = uploadFile.getOriginalFilename();
   		String pageSuffix = fileName.substring(fileName.lastIndexOf("."));
   		savePath = contextPath + savePath+pageSuffix;
   		savePath = savePath.replaceAll("\\\\", "/");
       	String fileDir = savePath.substring(0, savePath.lastIndexOf("/"));
       	File dir = new File(fileDir);
   		if (!dir.exists()) {
   			dir.mkdirs();
   		}
   		is = uploadFile.getInputStream();
   		os = new FileOutputStream(savePath);
   		byte[] byteArray = new byte[1024];
   		int count = 0;
   		while ((count=is.read(byteArray))!=-1) {
   			os.write(byteArray, 0, count);
   			os.flush();//此处其实不用刷新，为确保立即刷出数据。
   		}
   		return savePath;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			if (os!=null) {
				os.close();
			}
			if (is!=null) {
				is.close();
			}
		}
   }
   
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
		String relaPath = props.getProperty(impPath);//相对路径
		impPath = request.getRealPath(relaPath);
		// 转型为MultipartHttpRequest
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;   
        // 获得文件
        MultipartFile file = multipartRequest.getFile(inputName);
		//生成保存文件名
		String fileName = file.getOriginalFilename();
   		String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
   		String newFileName = fileNamePrefix + TransNoUtils.getTransNo() + fileSuffix;
		String filePathName = impPath + File.separator + newFileName;
		relaPath =  relaPath + File.separator + newFileName;
		//以流的方式读写文件
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
   
   public static void main(String[] args) throws IOException {
//	Reader read = new InputStreamReader(new FileInputStream(""));
/*	BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\alw\\Desktop\\IMG_2611.JPG"));
	System.out.println(bis.read());
	System.out.println(bis.read());*/
//	System.out.println(bis.read());
}
   
   
   
   
   /**
    * 获得文件后缀名
    * @param request		
    * @param pageFileName	 页面文件名称
    * @return 文件名（格式：.zip）	
    * @author jun.liu
    */
   public static String getFileSuffix(HttpServletRequest request, String pageFileName) throws Exception{
		//处理上传文件
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = multipartRequest.getFile(pageFileName);
		String fileName = uploadFile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
		return fileSuffix;
   }
   
   
   
   
   
   
   
   
   /**
    * 获得工程真实路径
    * @return
    */
   public static String getWebContextPath(){
	   return contextPath;
   }
   
}
