package com;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import junit.framework.TestCase;

import org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag;
import org.apache.xbean.spring.context.XmlWebApplicationContext;
import org.junit.Assert;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.DispatcherServlet;

import com.alibaba.fastjson.JSONObject;
import com.app.common.utils.ValidateUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foundation.Person;
import com.vo.ReturnTwoParamsVo;

final class Asb {
}

public class AllTest extends TestCase {
	private static final String FOLDER_SEPARATOR = "/";
	private static final String WINDOWS_FOLDER_SEPARATOR = "\\";
	public void test_40(){
		System.out.println(3/2.0);
		
	}
	public void test_39(){
		int h = 32768;
		h ^= (h >>> 20) ^ (h >>> 12);
        int b = h ^ (h >>> 7) ^ (h >>> 4);
		System.out.println(Integer.toBinaryString(b));
	}
	public void test_38() throws FileNotFoundException{
		BigDecimal bd = new BigDecimal(23);
		Buffer buffer;
		DataOutputStream os = new DataOutputStream(new FileOutputStream(""));
		String str;
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<String> list ;
		new HashSet<String>();
		new HashMap<String,String>();
		ConcurrentHashMap c;
		LinkedBlockingQueue l;
		ThreadLocal<Boolean> tl;
		Thread th;
		Integer i;
	}
	public void test_37(){
		Thread r = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("333");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("44444");
			}
		});
		r.start();
		System.out.println("444444444");
	}
	public void test_36(){
		try {
			ClassUtils.forName("org.springframework.web.context.support.XmlWebApplicationContext", ContextLoader.class.getClassLoader());
		} catch (ClassNotFoundException | LinkageError e) {
			e.printStackTrace();
		}
	}
	public void test_35(){
		XmlWebApplicationContext x;
		BeanDefinitionRegistry reg = new DefaultListableBeanFactory(); 
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(reg); 
		reader.loadBeanDefinitions(new ClassPathResource("bean1.xml")); 
		reader.loadBeanDefinitions(new ClassPathResource("bean2.xml")); 
		BeanFactory bf=(BeanFactory)reg; 
	}
	public void test_34(){
	    String str = "13abf";
	    int iq = Integer.parseInt(str, 16);
		System.out.println(iq);
	    int len = str.length();
	    int sum = 0;
	    for(int i=0;i<len;i++){
	        char c = str.charAt(len-1-i);
	        int n = Character.digit(c,16);
	        sum += n * (1<<(4*i)); 
	    } 
	    System.out.println(sum);
	}
	public void test_33(){
		int i = Integer.parseInt("123ab", 16);
		System.out.println(i);
		System.out.println(Character.digit('a', 16));
		System.out.println(1<<4);
	}
	public void test_32(){
		List<String> a = new ArrayList<String>();
		a.add("3");
//		List<Integer> b = new ArrayList<Integer>();
//		b.add(2);
//		b.add(4);
		a.add(0, "4");
		ListIterator<String> listIterator = a.listIterator();
		System.out.println(Arrays.toString(a.toArray()));
		
	}
	public void test_30(){
//		String jstr="{'json':'jsonvalue','bool':true,'int':1,'double':'20.5'}";
//		net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(jstr);
//		json.put("transs", "33333");
//		System.out.println(json.toString());
//		DefaultBeanDefinitionDocumentReader d ;
//		Date date = new Date();
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String format = df.format(date);
//		System.out.println(format);
		XmlBeanFactory xml;
//		xml.getBean("");
		DefaultListableBeanFactory d ;
		Class cls ;
//		
//		DateFormat dff = new SimpleDateFormat("yy-MM-dd");
//		String str = "2017-08-12 23:21:34";
//		try {
//			Date dd = df.parse(str);
//			System.out.println(dd);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		System.out.println(BeanFactoryUtils.transformedBeanName("&&ddddd"));
	}
	public void test_29() throws NoSuchFieldException, SecurityException{
		Person sb = new Person();
		System.out.println(sb.getClass().getDeclaredField("name4"));
//		BeanUtils.copyProperties(source, target, ignoreProperties);;
		BeanFactory b ;
	}
	public void test_28(){
		int i = 1,j=10;
		do{
			if(i > --j){
				continue;
			}
		}while(i++ < 5);
		System.out.println(i + "," + j);
	}
	public void test_27(){
		ApplicationContext c= new FileSystemXmlApplicationContext("");  
		XmlBeanFactory  xml;
		ClassPathResource res = new ClassPathResource("beans.xml");  
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();  
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);  
		reader.loadBeanDefinitions(res);  
		ProxyFactoryBean bean;
		RequestEncodingTag t;
		AnnotationConfigApplicationContext context;
		ApplicationContext ac ;
		System.out.println(DispatcherServlet.class.getName());
//		WebApplicationContextUtils.getWebApplicationContext(gets)
	}
	
	public void test_26(){
		// 弱引用
		WeakHashMap<String, String> map = new WeakHashMap<String, String>();
		map.put(new String("1"), "1");
		map.put("2", "2");
		String s = new String("3");
		map.put(s, "3");
		while (map.size() > 0) {
			try {
				System.out.println("11111111111111111111111");
				Thread.sleep(500);
			} catch (InterruptedException ignored) {
				
			}
			System.out.println("Map Size:"+map.size());
			System.out.println(map.get("1"));
			System.out.println(map.get("2"));
			System.out.println(map.get("3"));
			System.gc();
		}
	}

	public void test_25() {
		String str = null;
		System.out.println("33333333333322");
		Assert.assertNull("不能为空", str);
		System.out.println("44444");
	}

	public void test_24() {
		int i = 0;
		int j = 10;
		for (; j > 0; j = j >> 1) {
			System.out.println(j);
		}
	}

	public void test_23() {
		/*
		 * BigInteger gt = null; StringBuilder sb = new StringBuilder();
		 * StringBuilder sb2 = null; sb.append(sb2); sb.reverse();
		 * System.out.println(sb.toString());
		 * 
		 * Calendar c ; Arrays.asList(null);
		 */
		System.out.println(Void.class);
		System.out.println(Boolean.class);
		System.out.println(boolean.class);
		System.out.println(boolean[].class + "\n\r" + byte[].class + "\n\r"
				+ char[].class + "\n\r" + double[].class + "\n\r"
				+ float[].class + "\n\r" + int[].class + "\n\r" + long[].class
				+ "\n\r" + short[].class);

	}

	public void test_22() {
		StringBuilder sb = new StringBuilder("23");
		ReturnTwoParamsVo<String, StringBuilder> vo = ReturnTwoParamsVo
				.getReturnTwoParamsVo("1", sb);
		StringBuilder secondParam = vo.secondParam;
		secondParam.append("rrrrr");
		System.out.println(vo.secondParam);
	}

	public void test_21() {
		List<Group> groups = new ArrayList<Group>();

		Group g0 = new Group(0);
		Group g1 = new Group(1);
		Group g2 = new Group(2);

		groups.add(g0);
		groups.add(g1);
		groups.add(g2);
		groups.add(g0);
		groups.add(g1);
		groups.add(g2);
		groups.remove(g0);
		String text = JSONObject.toJSON(groups).toString();
		System.out.println(text);
	}

	public void test_20() {
		Vector<String> v = new Vector<>();
		List list = new ArrayList();
		Collections.synchronizedCollection(list);
		Collections.synchronizedList(list);
	}

	public void test_19() {
		int[] arr = new int[] { 3, 4, 6, 7, 9, 1, 67, 12, 11 };
		insertSortASC(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public void insertSortASC(int[] a) {
		int left = 0;
		int right = a.length - 1;
		for (int i = left, j = i; i < right; j = ++i) {
			int ai = a[i + 1];
			while (ai < a[j]) {
				a[j + 1] = a[j];
				if (j-- == left) {
					break;
				}
			}
			a[j + 1] = ai;
		}
	}

	public void test_18() {
		boolean bool = false;
		bool |= false;
		System.out.println(bool);
	}

	public void test_17() {
		Set<String> set = new HashSet<>();
		set.add("123");
		set.add("234");
		Set<String> subSet = new HashSet<>();
		subSet.add("123");
		set.removeAll(subSet);
	}

	public void test_16() {
		List<Person> list = new ArrayList<>();
		ListIterator lt = list.listIterator();// 链表--
		list.iterator();// 向前

	}

	public void test_15() {
		String str = System.getProperty("com.AllTest");
		System.out.println(str);
	}

	public void test_14() {
		int parseInt = Integer.parseInt("f", 16);
		System.out.println(parseInt);
	}

	public void test_13() {
		String name = "abs徐";
		byte[] bytes = name.getBytes();
		String str = new String(bytes, 0, 6);
		System.out.println(str);
	}

	public void test_12() throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		System.out.println(String.class);
		System.out.println(AllTest.class);
		System.out.println(int.class);

		Class cls = AllTest.class;
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}

		List<String> list = new ArrayList<>();
		list.add("123abv");
		Class class1 = list.getClass();
		Method[] declaredMethods = class1.getDeclaredMethods();
		for (Method method : declaredMethods) {
			if ("add".equals(method.getName())) {
				method.invoke(list, 23);
			}
		}
		for (String str : list) {
			System.out.println(str);
		}
	}

	public void test_11() {
		String input = "1 fish 2 fish red fish blue fish";
		Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
		System.out.println(s.nextInt());
		System.out.println(s.nextInt());
		System.out.println(s.next());
		System.out.println(s.next());
		s.close();
	}

	public void test_10() {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println(a + b);
	}

	public void test_9() {
		System.out.println("sdfsdf".contains("23"));
	}

	public void test_8() {
		Map map = new HashMap();
		map.put("1", "22");
		map.put("3", "sdf");
		Set entrySet = map.keySet();

		System.out.println(entrySet.toString());
	}

	public void test_7() {
		String str = "||we||rt||45||";
		System.out.println(str.contains("||we||"));
	}

	public void test_6() {
		String str = "123";
		System.out.println(str.hashCode());
		str = "345";
		System.out.println(str.hashCode());
		str = "123";
		System.out.println(str.hashCode());

	}

	public void test_5() {
		System.out.println(b());
		System.out.println(aa());
	}

	public String b() {
		String name = "123";
		try {
			return name;
		} finally {
			name = "456";
		}
	}

	public int aa() {
		int b = 23;
		try {
			return b;// 返回到一个地方，之后进入finaly块，引用改变，否则不改变
		} catch (Exception e) {
			System.out.println("error      :      " + e);
			return b;
		} finally {
			b = 200;
		}
	}

	public int[] tt() {
		int[] b = new int[2];
		try {
			System.out.println("yes");
			b[0] = 2;
			return b;// 返回到一个地方，之后进入finaly块，引用改变，否则不改变
		} catch (Exception e) {
			System.out.println("error      :      " + e);
		} finally {
			b[1] = 200;
			return b;// 不是引用则覆盖上面的return;
		}
	}

	public void test_4() {
		List<String> str = new ArrayList<>();
		str.add("1");
		str.add("2");
		str.add("3");
		StringBuilder sb = new StringBuilder();
	    sb.append('[');
	    for (int i = str.size()-1; i > -1 ;) {
	    	  sb.append(str.get(i));
	    	  if(--i < 0 ){
	    		  sb.append(']');
	    		  break;
	    	  }
	    	  sb.append(',');
		}
	    System.out.println(sb.toString());
	}
	public void test_41() {
		List<String> str = new ArrayList<>();
		str.add("1");
		str.add("2");
		str.add("3");
		str.add("4");
		StringBuilder sb = new StringBuilder();
	    sb.append('[');
	    for (int i = 0; i < str.size() ;) {
	    	  sb.append(str.get(i));
	    	  if(++i > str.size()-1 ){
	    		  sb.append(']');
	    		  break;
	    	  }
	    	  sb.append(',');
		}
	    System.out.println(sb.toString());
	}

	public void test_3() {
//		char value[] = "eeter".toCharArray();
//		int length = value.length;
//		boolean b = "344".startsWith("3", 0);
//		Assert.assertFalse("fffff", b);
//		System.out.println(b);
		Map<String, String> map = new HashMap<>();
		map.put(null, null);
		System.out.println(map.get(null));
	}

	public void test_2() {
		// BeanFactory b;
		XmlBeanFactory x;

		ClassPathResource res = new ClassPathResource("bean.xml");
		DefaultListableBeanFactory db = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xr = new XmlBeanDefinitionReader(db);
		int loadBeanDefinitions = xr.loadBeanDefinitions(res);
		System.out.println(loadBeanDefinitions);
	}

	public void test_1() {
		System.out.println(replace("http://test/sdf\\sdf.html",
				WINDOWS_FOLDER_SEPARATOR, FOLDER_SEPARATOR));
	}

	public static String replace(String inString, String oldPattern,
			String newPattern) {
		if (!hasLength(inString) || !hasLength(oldPattern)
				|| newPattern == null) {
			return inString;
		}
		StringBuilder sb = new StringBuilder();
		int pos = 0; // our position in the old string
		int index = inString.indexOf(oldPattern);
		// the index of an occurrence we've found, or -1
		int patLen = oldPattern.length();
		while (index >= 0) {
			sb.append(inString.substring(pos, index));
			sb.append(newPattern);
			pos = index + patLen;
			index = inString.indexOf(oldPattern, pos);
		}
		sb.append(inString.substring(pos));
		// remember to append any characters to the right of a match
		return sb.toString();
	}

	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}

	public static class Group {

		private int id;

		public Group() {

		}

		public Group(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String toString() {
			return "{id:" + id + "}";
		}

	}
}
