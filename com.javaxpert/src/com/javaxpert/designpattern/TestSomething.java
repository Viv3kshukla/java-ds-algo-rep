package com.javaxpert.designpattern;

public class TestSomething {
	
	public static void update(Integer b) {
		b = 6;
	}
	
	
	public static void main(String args[]) {
		Integer b = 5;
		
		System.out.println(b);
		
		update(b);
		
		System.out.println(b);
		
		String s = "{a:b,b:c}";
		s = s.substring(1,s.length()-1);
		String arr[] = s.split(",");
		
		for(String str: arr) {
			System.out.println(str);
		}
		
		
	
	}
	
}
