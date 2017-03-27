package com.app.common.utils.xml;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 根据xml创建实体，实体中的属性类型可以为多个list、实体、基本类型。
 * 暂不支持   set/map/array等
 * 其中xml中对应的标签与实体中的必须一样。
 * @author xxn
 * @date 2015年10月29日  下午2:23:24
 */
public class XmlParser {
	private static Log logger = LogFactory.getLog(XmlParser.class);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getEntity(String xml, Class<T> clazz) throws Exception {
		T newInstance = clazz.newInstance();
		Map<String,List<Object>> mapList = new HashMap<String,List<Object>>();//支持实体中有多个list
		Document doc = null;
		doc = DocumentHelper.parseText(xml); // 将字符串转为XML
		Element rootElt = doc.getRootElement(); // 获取根节点
		List<Element> elements = rootElt.elements();//获得所有的子节点
		for(int i = 0; i<elements.size() ; i++){
			Element element = elements.get(i);
			String fieldName = element.getName();
			Type type = null;
			try {
				type = clazz.getDeclaredField(fieldName).getGenericType();
			} catch (Exception e) {
				logger.debug("Entity attributes \""+fieldName+"\" does not exist!");
				e.printStackTrace();
			}
			if(element.elements().size() != 0){
				List<Element> sonElements = element.elements();
				if(type.toString().contains("java.util.List")){
					//用属性的名字当做集合的引用
					if(!mapList.containsKey(fieldName)){
						mapList.put(fieldName, new ArrayList<Object>());
					}
					Class  sonTypeClazz =(Class) ((ParameterizedType) type).getActualTypeArguments()[0];
					Object sonEntity = sonTypeClazz.newInstance();
					for (Element sonElement : sonElements) {
						String sonFieldName = sonElement.getName();
						Type  sonType = sonTypeClazz.getDeclaredField(sonFieldName).getGenericType();
						//非集合赋值
						sonEntity = setFieldValue(sonEntity,sonType,sonFieldName,element.elementTextTrim(sonFieldName));
					}
					//将实体放到list中
					mapList.get(fieldName).add(sonEntity);
					//集合赋值
					newInstance = setFieldValue(newInstance,type,fieldName,mapList.get(fieldName));
				}else if(type.toString().contains("java.util.Set") || type.toString().contains("class [L") || 
						type.toString().contains("java.util.Map")){
					logger.debug("The method entity does not support the existence of such property!-->"+type.toString());
					throw new Exception("The method entity does not support the existence of such property!-->"+type.toString());
				}else{
					Object sonEntity = ((Class<Object>) type).newInstance();
					for (Element sonElement : sonElements) {
						String sonFieldName = sonElement.getName();
						Type  sonType = ((Class<Object>) type).getDeclaredField(sonFieldName).getGenericType();
						//非集合赋值
						sonEntity = setFieldValue(sonEntity,sonType,sonFieldName,element.elementTextTrim(sonFieldName));
					}
					//实体赋值
					newInstance = setFieldValue(newInstance,type,fieldName,sonEntity);
				}
			}else{
				//非集合赋值
				newInstance = setFieldValue(newInstance,type,fieldName,rootElt.elementTextTrim(fieldName));
			}
		}
		return newInstance;
	}
	private static <T> T setFieldValue(T instance ,Type type,String fieldName,Object value) throws Exception, IllegalAccessException, InvocationTargetException{
		fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
		if (type.toString().equals("class java.lang.String")) {
			Method m = instance.getClass().getMethod("set" + fieldName,String.class);
			m.invoke(instance, value);
		}else if (type.toString().equals("class java.lang.Byte")) {
			Method m = instance.getClass().getMethod("set" + fieldName,Byte.class);
			m.invoke(instance, Byte.valueOf((String)value));
		}else if (type.toString().equals("class java.lang.Integer")) {
			Method m = instance.getClass().getMethod("set" + fieldName,Integer.class);
			m.invoke(instance, Integer.valueOf((String)value));
		}else if (type.toString().equals("class java.lang.Long")) {
			Method m = instance.getClass().getMethod("set" + fieldName,Long.class);
			m.invoke(instance, Long.valueOf((String)value));
		}else if (type.toString().equals("class java.lang.Double")) {
			Method m = instance.getClass().getMethod("set" + fieldName,Double.class);
			m.invoke(instance, Double.valueOf((String)value));
		}else if (type.toString().equals("class java.lang.Float")) {
			Method m = instance.getClass().getMethod("set" + fieldName,Float.class);
			m.invoke(instance, Float.valueOf((String)value));
		}else if (type.toString().equals("class java.lang.Short")) {
			Method m = instance.getClass().getMethod("set" + fieldName,Short.class);
			m.invoke(instance, Short.valueOf((String)value));
		}else if (type.toString().equals("class java.lang.Character")) {
			Method m = instance.getClass().getMethod("set" + fieldName,Character.class);
			m.invoke(instance, (Character)value);
		}else if (type.toString().equals("boolean")) {
			Method m = instance.getClass().getMethod("set" + fieldName, boolean.class);
			m.invoke(instance, Boolean.valueOf((String)value));
		}else if (type.toString().contains("java.util.List")) {
			//list集合
			Method m = instance.getClass().getMethod("set" + fieldName, List.class);
			m.invoke(instance, value);
		}else{
			//实体
			Method m = instance.getClass().getMethod("set" + fieldName, value.getClass());
			m.invoke(instance, value);
		}
		return instance;
	}
	public static void main(String[] args) throws Exception {
		
		Abc abc = getEntity("<?xml version=\"1.0\"?><head><name>parentName</name><addre>和囊</addre><success>true</success><age>34</age><childs><name>childname</name>"+
	"<age>34</age><email>23@qq.com</email></childs><childs><name>childname2</name><age>342</age><email>232@qq.com</email></childs><haes><name>hae哈哈</name><phone>33333444</phone></haes><haes><name>水电费</name><phone>137</phone></haes><you><name>you</name><no>2011</no></you></head>", Abc.class);
		System.out.println(abc.getAddre() + abc.getAge() + abc.getName()+abc.isSuccess());
		List<Child> childs = abc.getChilds();
		for (Child child : childs) {
			System.out.println(child.getName());
		}
		System.out.println(abc.getYou().getName());
	}
}
