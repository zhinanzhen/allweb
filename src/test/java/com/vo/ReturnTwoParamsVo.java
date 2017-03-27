package com.vo;

/**
 * 返回任意两个参数
 * @author xxn
 * @date 2016年5月24日  下午6:39:16
 * @param <A>
 * @param <B>
 */
public class ReturnTwoParamsVo<A, B> {
	public final A firstParam;
	public final B secondParam;
	public ReturnTwoParamsVo(A a, B b) {
		firstParam = a;
		secondParam = b;
	}
	
	/**
	 * 获取ReturnTwoParams
	 * @param a
	 * @param b
	 * @return
	 */
	public static <A,B> ReturnTwoParamsVo<A, B> getReturnTwoParamsVo(A a, B b){
		return new ReturnTwoParamsVo<A, B>(a,b);
	}
}
