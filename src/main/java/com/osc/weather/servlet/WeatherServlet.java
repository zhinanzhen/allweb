package com.osc.weather.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osc.weather.util.WeatherReport;

/**
 * 通过调用webservice 来查找天气情况，运行界面tianqi.jsp
 * @author Administrator
 *
 */
public class WeatherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ;
		String city = request.getParameter("city") ;
		String info = WeatherReport.getWeather(city) ;
		request.setAttribute("info", info) ;
		request.getRequestDispatcher("/weatherInfo.jsp").forward(request, response) ;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response) ;
	}

}
