package com.thinkinginjava.ten;

public class Parcel4 {
	/**
	 * 在这个私有内部类中添加方法是没有价值的，只有在接口中添加方才才可见
	 * 组织任何依赖与类型的编码
	 * @author xxn
	 * @date 2016年3月25日  下午12:09:27
	 */
	private class Contents implements Parcel4InterCon {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	class Destination implements Parcel4InterDes {
		private String label;

		Destination(String whereTo) {
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}
	}
	
	public Parcel4InterCon contents(){
		return new Contents();
	}
	public Parcel4InterDes destination(String label){
		return new Destination(label);
	}
}
