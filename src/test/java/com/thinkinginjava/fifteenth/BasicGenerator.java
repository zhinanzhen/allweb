package com.thinkinginjava.fifteenth;

import com.thinkinginjava.fifteenth.coffee.Coffee;

/**
 * 生成器
 * @author xxn
 * @date 2016年5月12日  下午7:32:37
 * @param <T>
 */
public class BasicGenerator<T> implements Generator<T> {
	private Class<T> type;
	public BasicGenerator(Class<T> type){
		this.type = type;
	}
	@Override
	public T next() {
		try {
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> Generator<T> create(Class<T> type){
		return new BasicGenerator<T>(type);
	}
	public static void main(String[] args) {
		Generator<Coffee> create = create(Coffee.class);
		for(int i=0; i<5 ; i++){
			System.out.println(create.next());
		}
	}
}
