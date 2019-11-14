package com.javaxpert.test;

public class SplitTest {
	public static void main(String args[]) {
		String str = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
		String arr[] = str.split("\\.");
		
		for(String s : arr) {
			System.out.println(s);
		}
	}
}
