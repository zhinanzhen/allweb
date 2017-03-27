package com.app.common.utils.excel;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

public class Style {
	
	public static final short COLOR_RED = HSSFColor.RED.index;//红色
	
	public static final short COLOR_DARK_BLUE = HSSFColor.DARK_BLUE.index;//深蓝
	
	public static final short COLOR_LIGHT_BLUE = HSSFColor.LIGHT_BLUE.index;//浅蓝
	
	public static final short COLOR_CORNFLOWER_BLUE = HSSFColor.LIGHT_CORNFLOWER_BLUE.index;//浅蓝
	
	public static final short COLOR_WHITE = HSSFColor.WHITE.index;//白色
	
	public static final short COLOR_BLACK = HSSFColor.BLACK.index;//黑色
	
	/**
	 * 
	 * @param workbook
	 * @param backgroundColor
	 * @param fontColor
	 * @return
	 * CellStyle
	 */
	public static CellStyle generatedHeadStyle(Workbook workbook,Short backgroundColor,Short fontColor){
		CellStyle style = workbook.createCellStyle();
		//default dark blue background color
		style.setFillForegroundColor(backgroundColor==null?COLOR_CORNFLOWER_BLUE:backgroundColor);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		Font font = workbook.createFont();// 生成一个字体
		font.setColor(fontColor==null?COLOR_WHITE:fontColor);
		style.setFont(font);// 把字体应用到当前的样式
		return style;
	}
	/**
	 * 
	 * @param workbook
	 * @param backgroundColor
	 * @param fontColor
	 * @return
	 * CellStyle
	 */
	public static CellStyle generatedTableStyle(Workbook workbook,Short backgroundColor,Font font){
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(backgroundColor==null?COLOR_WHITE:backgroundColor);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND); 
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFont(font);
		return style;
	}
	
}
