package com.javaxpert.dsalgoimpl.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class StockSpan {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> arr = Arrays.stream(br.readLine().trim().split(" ")).map(Integer:: parseInt).collect(Collectors.toList());
		List<Integer> ans = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<n;i++) {
			while(!stack.isEmpty() && arr.get(stack.peek()) < arr.get(i)) {
				stack.pop();
			}
			if (!stack.isEmpty()) ans.add(i - stack.peek());
			else ans.add(i);
			
			stack.push(i);
		}
		
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i) + " ");
		}
		 
	}
}
