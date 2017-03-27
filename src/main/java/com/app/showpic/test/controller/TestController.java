package com.app.showpic.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.BaseController;
import com.app.showpic.test.bean.Test1;
import com.app.showpic.test.bean.Test2;
import com.app.showpic.test.sercive.ITestSercive;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
	@Autowired
	ITestSercive testSercive;
	
	@RequestMapping("/testValue.html")
	public ModelAndView getValue(HttpServletRequest request, HttpServletResponse response){
		List <Test1> tests = testSercive.getValue();
		Test1 t1 = new Test1();
		t1.setName("张颐武");
		t1.setPhone("333333333");
		t1.setSex("男");
		Test2 t2 = new Test2();
		t2.setName("赵日天");
		t2.setEmail("qq@.com");
		testSercive.saveBean(t1,t2);
		for(Test1 te:tests){
			System.out.println(te.getName()+":"+te.getPhone());
		}
		request.setAttribute("tests", tests);
		return new ModelAndView("showpic/test/test");
	}
}
