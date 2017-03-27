package com.app.utilsample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.utils.excel.ExcelExport;
import com.app.common.utils.excel.model.ColumnORM;

@Controller
@RequestMapping("/excel")
public class ExcelController {
	@RequestMapping("excelPage.html")
	public ModelAndView excelPage(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("showpic/excel/excelPage");
	}
	@RequestMapping("writeExcelToPage.html")
	public void writeExcelToPage(HttpServletRequest request, HttpServletResponse response){
		List<Map<String,String>> loanApplyList = new ArrayList<>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "xuxu");
		map.put("age", "22");
		map.put("email", "22@163.com");
		loanApplyList.add(map);
		ColumnORM[] headers = new ColumnORM[]{
				new ColumnORM("姓名", "name"),
				new ColumnORM("年龄", "age"),
				new ColumnORM("email", "email"),
    	};
		ExcelExport.writeExcel2003("客户",headers,loanApplyList,response);
	}
}
