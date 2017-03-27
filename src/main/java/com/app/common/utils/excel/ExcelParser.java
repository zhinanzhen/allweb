package com.app.common.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.app.common.utils.ValidateUtils;
import com.app.common.utils.excel.model.ColumnORM;

public class ExcelParser {

	

	private final Integer DEFAULT_TITLE_INDEX = 0;

	/**
	 * 
	 * @param input Excel文件流
	 * @param headers excel标题的别名
	 * @param callback 业务校验的回调
	 * @param titleIndex 解析数据起始行（默认是0）
	 * 调用说明：
	 *  File file = new File("C:\\Users\\Administrator\\Desktop\\test.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		
		ExcelParser parser = new ExcelParser();
		parser.parse(inputStream, new String[]{"agentName","clearAcct","amount"}, new ValidateCallback() {
			@Override
			public boolean validate(Map<String, String> dataRow) {
				String agentName = dataRow.get("agentName");
				
				return StringUtils.isNotBlank(agentName)?true:false;
			}
		});
	 * @return
	 */
	public ParseResultSet parse(InputStream input, String[] headers,
			ValidateCallback callback, Integer titleIndex) {
		
		List<Map<String, String>> successList = new ArrayList<Map<String, String>>();

		List<Map<String, String>> failureList = new ArrayList<Map<String, String>>();
		if (callback == null) {
			return new ParseResultSet(successList, failureList, "0", "未提供业务校验回调函数");
		}

		if (titleIndex == null)
			titleIndex = DEFAULT_TITLE_INDEX;

		/** 获取workbook **/
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(input);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			return new ParseResultSet(successList, failureList, "0", "不支持的文件格式");
		} catch (IOException e) {
			e.printStackTrace();
			return new ParseResultSet(successList, failureList, "0", "网络异常");
		}

		/** 获取sheet **/
		Sheet sheet = workbook.getSheetAt(0);
		/** 单上传批次最大上传数为2000 **/
		/** 下标从0开始  **/
		int rowLength = sheet.getLastRowNum();
		
		if(rowLength < 1){
			workbook = null;
			sheet = null;
			return new ParseResultSet(successList, failureList, "0", "文件无数据");
		}
		
		if (rowLength > 2000) {
			workbook = null;
			sheet = null;
			return new ParseResultSet(successList, failureList, "0", "文件数据条数过多，【最大上传数为2000】");
		}

		/** 获取表头row **/
		Row titleRow = sheet.getRow(titleIndex);
		if (headers.length != titleRow.getLastCellNum()) {
			workbook = null;
			sheet = null;
			return new ParseResultSet(successList, failureList, "0", "上传数据的列数与模板的列数不一致，请仔细核对后上传");
		}

		/** 数据读取与处理 **/
		for (int i = titleIndex + 1; i <= rowLength; i++) {
			// excel的每行记录row
			Row dataRow = sheet.getRow(i);
			//防止空行出现
			if(dataRow == null){
				continue;
			}
			Map<String, String> rowRecord = new HashMap<String, String>();
			boolean rowNotEmpty = false;
			for (int j = 0; j < headers.length; j++) {
				Cell cell = dataRow.getCell(j);
				String value = getCellValue(cell);
				if(StringUtils.isNotEmpty(value)) {
					rowNotEmpty = true;
				}
				rowRecord.put(headers[j], value);
			}
			if(!rowNotEmpty){
				continue;
			}
			// 业务数据正确性校验
			boolean validateStatus = callback.validate(rowRecord);
			if (validateStatus) {
				//数据转换
				callback.translate(rowRecord);
				successList.add(rowRecord);
			} else {
				failureList.add(rowRecord);
			}
		}

		/** 本次操作结果分析 **/
		if (ValidateUtils.isEmpty(failureList)) {
			return new ParseResultSet(successList, failureList, "1");
		} else {
			return new ParseResultSet(successList, failureList, "2");
		}
	}

	/**
	 * excel数据读取
	 * 
	 * @param input
	 * @param headers
	 * @param callback
	 * @return ParseResultSet
	 */
	public ParseResultSet parse(InputStream input, String[] headers,
			ValidateCallback callback) {
		return parse(input, headers, callback, null);
	}

	/**
	 * excel数据读取
	 * @param file
	 * @param headers
	 * @param callback
	 * @return
	 */
	public ParseResultSet parse(File file, String[] headers,
			ValidateCallback callback) {
		InputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			new ParseResultSet("0", "文件不存在");
		}
		return parse(input, headers, callback, null);
	}

	private String getCellValue(Cell cell) {
		String strCell = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_STRING:
				strCell = cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				strCell = new BigDecimal(cell.getNumericCellValue()).toBigInteger().toString();
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				strCell = String.valueOf(cell.getBooleanCellValue());
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				strCell = "";
				break;
			default:
				strCell = "";
				break;
			}
			if ("".equals(strCell)|| strCell == null) {
				return "";
			}
			return strCell.replace(" ", "");
		} else {
			return "";
		}
	}
	public static void main(String[] args) {
		ExcelParser ep = new ExcelParser();
		long currentTimeMillis = System.currentTimeMillis();
		ParseResultSet resultSet = ep.parse(new File("C:/Users/Administrator/Desktop/aaa.xls"), new String[]{"acctName","acctNo","acctBank","faileReason"}, new ValidateCallback() {
			
			@Override
			public boolean validate(Map<String, String> dataRow) {
				return true;
			}
			
			@Override
			public void translate(Map<String, String> dataRow) {
				// TODO Auto-generated method stub
				
			}
		});
		System.out.println(System.currentTimeMillis() - currentTimeMillis);
		
//		List<Map<String,String>> list = resultSet.getSuccessList();
//		
//		ColumnORM[] headers = new ColumnORM[]{
//				new ColumnORM("收款人账户名", "acctName",Style.COLOR_BLACK,Style.COLOR_WHITE),
//				new ColumnORM("收款人账户号", "acctNo"),
//				new ColumnORM("收款人开户行", "acctBank",Style.COLOR_LIGHT_BLUE,Style.COLOR_DARK_BLUE),
//				new ColumnORM("失败原因","failMsg",null, Style.COLOR_RED)};
//		long currentTimeMillis = System.currentTimeMillis();
//		ExcelExport.generatedExcel2007("申请支付账户错误数据", headers, list, "C:/Users/Administrator/Desktop/aaa3.xls");
//		System.out.println(System.currentTimeMillis() - currentTimeMillis);
	}
}
