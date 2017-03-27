package com.osc.weather.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherReport {
	/**
	 * 获取SOAP的请求头，并替换其中的标志符号为用户输入的城市
	 * 
	 * 编写者：王景辉
	 * 
	 * @param city
	 *            用户输入的城市名称
	 * @return 客户将要发送给服务器的SOAP请求
	 */
	@SuppressWarnings("unused")
	private static String getSoapRequest(String city) {
		StringBuilder sb = new StringBuilder();
		sb
				.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>"
						+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
						+ "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
						+ "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
						+ "<soap:Body>    <getWeatherbyCityName xmlns=\"http://WebXml.com.cn/\">"
						+ "<theCityName>" + city
						+ "</theCityName>    </getWeatherbyCityName>"
						+ "</soap:Body></soap:Envelope>");
		return sb.toString();
	}

	/**
	 * 用户把SOAP请求发送给服务器端，并返回服务器点返回的输入流
	 * 
	 * 编写者：王景辉
	 * 
	 * @param city
	 *            用户输入的城市名称
	 * @return 服务器端返回的输入流，供客户端读取
	 * @throws Exception
	 */
	private static InputStream getSoapInputStream(String city) throws Exception {
		//检查QQ是否在线的websevice    http://www.webxml.com.cn/webservices/qqOnlineWebService.asmx?op=qqCheckOnline
		try {
			//SOAP方式
			/*String soap = getSoapRequest(city);
			if (soap == null) {
				return null;
			}
			URL url = new URL(
					"http://www.webxml.com.cn/WebServices/WeatherWebService.asmx");
			URLConnection conn = url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);

			conn.setRequestProperty("Content-Length", Integer.toString(soap
					.length()));
			conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			conn.setRequestProperty("SOAPAction",
					"http://WebXml.com.cn/getWeatherbyCityName");

			OutputStream os = conn.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			osw.write(soap);
			osw.flush();
			osw.close();

			InputStream is = conn.getInputStream();*/
			
			//get方式请求
			URL url1 = new URL("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx/getWeatherbyCityName?theCityName="+city);//指定连接资源
			HttpURLConnection conn1 = (HttpURLConnection)url1.openConnection();//获取连接对象
			conn1.setRequestMethod("GET");//设置请求方式
			InputStream is = conn1.getInputStream();
			
			//post 方式
			/*String url = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx/getWeatherbyCityName";
			URL url1 = new URL(url);//指定连接资源
			HttpURLConnection conn1 = (HttpURLConnection)url1.openConnection();//获取连接对象
			conn1.setRequestMethod("POST");//设置请求方式
			conn1.setRequestProperty("theCityName",city);
			conn1.setRequestProperty("Content-Length",String.valueOf(city.length()));
			conn1.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			InputStream is = conn1.getInputStream();*/
			
			return is;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 对服务器端返回的XML进行解析
	 * 
	 * 编写者：王景辉
	 * 
	 * @param city
	 *            用户输入的城市名称
	 * @return 字符串 用,分割
	 */
	public static String getWeather(String city) {
		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream is = getSoapInputStream(city);
			doc = db.parse(is);
			
			//生成xml文件
			TransformerFactory tf = TransformerFactory.newInstance();// 此抽象类的实例能够将源树转为结果树
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(doc);// 创建带有DOM节点的新输入源
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");// 设置转换中世纪的输出属性
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");//
			PrintWriter pw = new PrintWriter(new FileOutputStream("d:/test.xml"));
			StreamResult result = new StreamResult(pw);// 充当转换结果的持有者，可以为xml、纯文本、HTML或某些其他格式的标记
			transformer.transform(source, result);// 将XML Source转换为Result
			System.out.println("生成XML文件成功");
			
			
			
			
			NodeList nl = doc.getElementsByTagName("string");
			StringBuffer sb = new StringBuffer();
			for (int count = 0; count < nl.getLength(); count++) {
				Node n = nl.item(count);
				if(n.getFirstChild().getNodeValue().equals("查询结果为空！")) {
					sb = new StringBuffer("#") ;
					break ;
				}
				sb.append(n.getFirstChild().getNodeValue() + "#\n");
			}
			is.close();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 测试用
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(getWeather("长沙"));
		System.out.println("po&oi".split("&").length) ;
		System.out.println("##".split("#").length) ;
	}
}
