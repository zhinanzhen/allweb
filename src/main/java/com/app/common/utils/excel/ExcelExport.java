package com.app.common.utils.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.app.common.utils.DateUtils;
import com.app.common.utils.excel.model.ColumnORM;

public class ExcelExport {
	/**
	 * 导出excel2003
	 * @param sheetName sheet名
	 * @param datas		数据
	 * @param filePath  路径
	 * @param headers   表头
	 * @param fontColor 字体颜色
	 * void
	 */
	public static void generatedExcel2003(String sheetName,String[] headers,List<Map<String, String>> datas,String filePath){
		filePath = filePath.replaceAll("\\\\", "/");
       	String fileDir = filePath.substring(0, filePath.lastIndexOf("/"));
       	//如果文件不存在则创建
       	File dir = new File(fileDir);
   		if (!dir.exists()) {
   			dir.mkdirs();
   		}
   		//根据后缀 声明一个工作薄,数据填充sheet
   		Workbook workbook = new HSSFWorkbook();
   		defaultGeneratedSheet(workbook,sheetName, datas,headers);
   		OutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			workbook.write(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 导出excel2007
	 * @param sheetName sheet名
	 * @param datas		数据
	 * @param filePath  路径
	 * @param headers   表头
	 * @param fontColor 字体颜色
	 * void
	 */
	public static void generatedExcel2007(String sheetName,String [] headers,List<Map<String, String>> datas,String filePath){
		filePath = filePath.replaceAll("\\\\", "/");
       	String fileDir = filePath.substring(0, filePath.lastIndexOf("/"));
       	//如果文件不存在则创建
       	File dir = new File(fileDir);
   		if (!dir.exists()) {
   			dir.mkdirs();
   		}
   		//根据后缀 声明一个工作薄,数据填充sheet
   		Workbook workbook = new XSSFWorkbook();
   		defaultGeneratedSheet(workbook,sheetName, datas,headers);
   		OutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			workbook.write(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成sheet,并填充新数据
	 * @param workbook
	 * @param sheetTitle
	 * @param dataset
	 * @param out
	 */
	private static void defaultGeneratedSheet(Workbook workbook,String sheetTitle,List<Map<String, String>> dataset,String[] headers) {
		// 生成一个表格
		Sheet sheet = workbook.createSheet(sheetTitle);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 15);
		// 生成一个样式
		CellStyle style = createDefaultHeadCss(workbook);
		// 产生表格标题行
		Row row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(headers[i]);
		}
		for (int indexRow = 1; indexRow <= dataset.size(); indexRow++) {
			row = sheet.createRow(indexRow);
			Map<String, String> map = dataset.get(indexRow - 1);
			int indexCol = 0;
			Set<String> set = map.keySet();
			for (String key : set) {
				String value = map.get(key);
				Cell cell = row.createCell(indexCol);
				cell.setCellValue(value);
				indexCol++;
			}
		}
	}
	/**
	 * 生成默认样式
	 * @param workbook
	 * @return
	 */
	private static CellStyle createDefaultHeadCss(Workbook workbook){
		return Style.generatedHeadStyle(workbook, Style.COLOR_LIGHT_BLUE, Style.COLOR_WHITE);
	}
	
	/**
	 * 生成excel 2003
	 * @param sheetName sheet名
	 * @param orms 标题
	 * @param datas 数据
	 * @param filePath 文件路径
	 */
	public static void generatedExcel2003(String sheetName,ColumnORM[] orms,List<Map<String,String>> datas,String filePath){
		filePath = filePath.replaceAll("\\\\", "/");
       	String fileDir = filePath.substring(0, filePath.lastIndexOf("/"));
       	//如果文件不存在则创建
       	File dir = new File(fileDir);
   		if (!dir.exists()) {
   			dir.mkdirs();
   		}
   		//根据后缀 声明一个工作薄,数据填充sheet
   		Workbook workbook = new HSSFWorkbook();
   		//创建sheet页
   		createSheet(workbook, sheetName, orms, datas);
   		//将内容写入磁盘
   		OutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			workbook.write(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 生成excel 2007
	 * @param sheetName sheet名
	 * @param orms 标题
	 * @param datas 数据
	 * @param filePath 文件路径
	 */
	public static void generatedExcel2007(String sheetName,ColumnORM[] orms,List<Map<String,String>> datas,String filePath){
		filePath = filePath.replaceAll("\\\\", "/");
       	String fileDir = filePath.substring(0, filePath.lastIndexOf("/"));
       	//如果文件不存在则创建
       	File dir = new File(fileDir);
   		if (!dir.exists()) {
   			dir.mkdirs();
   		}
   		//根据后缀 声明一个工作薄,数据填充sheet
   		Workbook workbook = new SXSSFWorkbook();
//   		Workbook workbook = new XSSFWorkbook();
   		//创建sheet页
   		createSheet(workbook, sheetName, orms, datas);
   		//将内容写入磁盘
   		OutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			workbook.write(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void createSheet(Workbook workbook,String sheetName,ColumnORM[] orms,List<Map<String, String>> dataset) {
		// 生成一个表格
		Sheet sheet = workbook.createSheet(sheetName);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 20);
		// 生成一个样式
		CellStyle style = createDefaultHeadCss(workbook);
		// 产生表格标题行与每一列的样式
		Row row = sheet.createRow(0);
		Font[] fonts = new Font[orms.length];
		for (int i = 0; i < orms.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(orms[i].getLabel());
			// 列样式
			Font font = workbook.createFont();
			font.setColor(orms[i].getFontColor() == null ? Style.COLOR_BLACK : orms[i].getFontColor());
			fonts[i] = font;
		}
		
		for(int i=0;i<dataset.size();i++){
			Map<String,String> dataMap = dataset.get(i);
			Row dataRow = sheet.createRow(i+1);
			for(int j=0;j<orms.length;j++){
				CellStyle cs = Style.generatedTableStyle(workbook, orms[j].getBackgroundColor(), fonts[j]);
				Cell cell = dataRow.createCell(j);
				cell.setCellStyle(cs);
				cell.setCellValue(dataMap.get(orms[j].getKey()));
			}
		}
	}
	
	/**
	 * 生成excel workbook--从页面下载
	 * @param sheetName
	 * @param orms
	 * @param datas
	 * @return
	 * Workbook
	 */
	public static void writeExcel2003(String sheetName,ColumnORM[] orms,List<Map<String,String>> datas,HttpServletResponse response){
		//根据后缀 声明一个工作薄,数据填充sheet
   		Workbook workbook = new HSSFWorkbook();
   		//创建sheet页
   		createSheet(workbook, sheetName, orms, datas);
   		OutputStream output = null;
   		try {
			response.setHeader("content-disposition", "attachment;filename=" +DateUtils.getNowTime()+".xls");
			response.setContentType("application/octet-stream");
			output = response.getOutputStream();
			workbook.write(response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				output.flush();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for (int i = 0; i < 10000; i++) {
			Map<String,String> map = new HashMap<String, String>();
			map.put("acctName", "张三");
			map.put("acctNo", "1111111");
			map.put("acctBank", "华夏银行");
			map.put("failMsg", "已存在");
			list.add(map);
		}
		ColumnORM[] headers = new ColumnORM[]{
				new ColumnORM("收款人账户名", "acctName",Style.COLOR_BLACK,Style.COLOR_WHITE),
				new ColumnORM("收款人账户号", "acctNo"),
				new ColumnORM("收款人开户行", "acctBank",Style.COLOR_LIGHT_BLUE,Style.COLOR_DARK_BLUE),
				new ColumnORM("失败原因","failMsg",null, Style.COLOR_RED)};
		long currentTimeMillis = System.currentTimeMillis();
		ExcelExport.generatedExcel2007("申请支付账户错误数据", headers, list, "C:/Users/Administrator/Desktop/aaa.xls");
		System.out.println(System.currentTimeMillis() - currentTimeMillis);
	}
}
