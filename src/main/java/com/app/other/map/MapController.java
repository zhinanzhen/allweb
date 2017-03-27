package com.app.other.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/map/")
public class MapController {
	@RequestMapping("keyMap.html")
	public ModelAndView keyMap(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("map/keyMap");
	}
	
	@RequestMapping("check.html")
	public ModelAndView check(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("map/check");
	}
}
