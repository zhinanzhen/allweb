package com.thinkinginjava.ten;

import com.thinkinginjava.ten.Parcel4.Destination;

public class Parcel4Test {
	public static void main(String[] args) {
		Parcel4 p4 = new Parcel4();
		Parcel4InterCon contents = p4.contents();
		Parcel4InterDes destination = p4.destination("xxn");
		int value = contents.value();
		System.out.println(value);
		String readLabel = destination.readLabel();
		System.out.println(readLabel);
		
		
		Parcel4.Destination dd = (Destination) p4.destination("");
//		Parcel4.Contents contents2 = (Contents) p4.contents();
		Parcel4.Destination ddd = p4.new Destination("");
	}
}
