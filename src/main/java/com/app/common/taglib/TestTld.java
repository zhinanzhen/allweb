package com.app.common.taglib;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class TestTld extends TagSupport {
	// 标签属性value
	private String value;
	private String pattern;
	
	// 构造函数
	public TestTld() {

	}

	/* 标签初始方法 */
	@SuppressWarnings("static-access")
	public int doStartTag() throws JspTagException {
		return super.EVAL_BODY_INCLUDE;
	}

	/* 标签结束方法 */
	@SuppressWarnings("static-access")
	public int doEndTag() throws JspTagException {
		JspWriter out = pageContext.getOut();
		BigDecimal bm = new BigDecimal(value);
		DecimalFormat df = new DecimalFormat(pattern);
		String format = df.format(bm);
		try {
			// 标签的返回值
			out.println(format);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.SKIP_BODY;
	}

	/* 释放资源 */
	public void release() {
		super.release();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	
}
