package com.javaxpert.geeksforgeeks.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/simplify-directory-path-unix-like/amp/
 */


public class SimplifyTheDirectoryPath {
	
	public static String simplify(String input) {
		Stack<String> stack = new Stack<String>();
		String args[] = input.trim().split("/");
		for(String str: args) {
			if(str.equals("..")) {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}
			else if(!str.isEmpty() && !str.equals(".")) {
				stack.push(str);
			}
		}
		
		StringBuilder sb = new StringBuilder("");
        while(!stack.isEmpty()) {
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
		
		return sb.length() !=0 ? sb.toString(): "/";
	}
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String output = simplify(input);
		System.out.println(output);
		
	}
}
