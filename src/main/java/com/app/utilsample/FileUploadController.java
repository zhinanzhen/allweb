package com.app.utilsample;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.app.common.utils.DateUtils;
import com.app.common.utils.FileUploadUtils;
import com.app.common.utils.GetPathByNameUtil;

@Controller
@RequestMapping("/fileUpload")
public class FileUploadController extends MultiActionController {
	@RequestMapping(value = "/page.html")
	public String FileUploadPage(){
		return "/showpic/file/file";
	}
	
	/**
	 * 上传文件
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadFileToJson.html")
	public void uploadFileToJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String path = uploadFileToString(request,response);
		System.out.println(path);
		if("".equals(path)){
			JSONObject json = new JSONObject();
			json.put("result", "0");
			String msg = json.toString();
			response.setCharacterEncoding("UTF-8");
			try {
				response.getWriter().write(msg);
				return;
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		JSONObject json = new JSONObject();
		json.put("result", "1");
		json.put("filePath", path);
		String msg = json.toString();
		response.setHeader("Content-Type", "application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(msg);
			return;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 上传文件
	 * @param request
	 * @param response
	 * @return 返回String为文件上传的路径
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadFileToString.html")
	public String uploadFileToString(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String prefix = request.getParameter("prefix");//获得模块路径
		String module = request.getParameter("module");//获得模块路径
		String path = GetPathByNameUtil.getPathByName("home_file_path");//获得属性文件中的配置路径
		String url = path+"/"+module;
		String now = DateUtils.getNowTimeInMillis();

		// 完成文件上传
		String pageFileName = "file";
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = multipartRequest.getFile(pageFileName);
		String fileName = uploadFile.getOriginalFilename();
		String pageSuffix = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = "/"+prefix+"_"+ now;
		String saveFileUri = url + newFileName;
		
		try {
			FileUploadUtils
					.handleFileUpload(request, saveFileUri, pageFileName);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
		saveFileUri += pageSuffix;
		return saveFileUri;

	}
	@RequestMapping("/deleteFile.html")
	public void deleteFile(HttpServletRequest request, HttpServletResponse response){
		String filePath = request.getParameter("filePath");
		String url = FileUploadUtils.contextPath+"/"+filePath;
		File file = new File(url);
		if("".equals(filePath) || !file.exists()){
			JSONObject json = new JSONObject();
			json.put("result", "0");
			String msg = json.toString();
			response.setCharacterEncoding("UTF-8");
			try {
				response.getWriter().write(msg);
				return;
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		file.delete();
		JSONObject json = new JSONObject();
		json.put("result", "1");
		String msg = json.toString();
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(msg);
			return;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
