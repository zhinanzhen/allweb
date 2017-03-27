package com.thinkinginjava.file;

import java.io.File;
import java.io.FilenameFilter;

public class DirList {
	private static String[] list ;
	public static FilenameFilter filter(final String afn){
		return new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				String f = new File(name).getName();
				return f.indexOf(afn) != -1;
			}
		};
	}
	private static void print(){
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	public static void main(String[] args) {
		File path = new File(".");
		if(args.length == 0){
			list = path.list(filter(".svn"));
		}else{
			list = path.list(filter(args[0]));
		}
		print();
	}
}
