package com.app.common.utils.excel.model;

public class ColumnORM {

	private String label;//列名
	
	private String key;//List<Map<String,String>>中map对应的key值
	
	private Short backgroundColor;//背景色
	
	private Short fontColor;

	public ColumnORM(String label, String key) {
		super();
		this.label = label;
		this.key = key;
	}

	public ColumnORM(String label, String key, Short backgroundColor,
			Short fontColor) {
		super();
		this.label = label;
		this.key = key;
		this.backgroundColor = backgroundColor;
		this.fontColor = fontColor;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Short getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Short backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Short getFontColor() {
		return fontColor;
	}

	public void setFontColor(Short fontColor) {
		this.fontColor = fontColor;
	}

}
