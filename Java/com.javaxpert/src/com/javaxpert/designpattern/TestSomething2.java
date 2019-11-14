package com.javaxpert.designpattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSomething2 {
	public static void main(String args[]) {
		
		String str = "1";
		List<String> arr = new ArrayList<String>(Arrays.asList(str.split(","))) ;
		System.out.println(arr);
		
	}
}
