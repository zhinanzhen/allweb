package com.app.showpic.js.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.BaseController;

@Controller
@RequestMapping("/js")
public class JsController extends BaseController{
	@RequestMapping("/regularTest.html")
	public ModelAndView goRegularPage(){
		return returnJsp("showpic/js/regularTest");
	}

}
