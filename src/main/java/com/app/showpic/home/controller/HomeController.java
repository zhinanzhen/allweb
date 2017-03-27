package com.app.showpic.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
	@RequestMapping("/homePage.html")
	public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("showpic/home/homePage");
	}
}
