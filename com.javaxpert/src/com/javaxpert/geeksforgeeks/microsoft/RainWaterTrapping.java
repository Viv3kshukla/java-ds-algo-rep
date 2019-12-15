package com.javaxpert.geeksforgeeks.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * left[i] = max(from 0 .. i)
 * right[i] = max(n-1 .. i)
 * ans += min(left[i],right[i]) - arr[i]
 */


public class RainWaterTrapping {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
		
		String [] s = br.readLine().trim().split(",");
		Integer [] arr = new Integer[s.length];
		for(int i=0;i < s.length;i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int ans = 0;
		for(int i=0;i<arr.length;i++) {
			if(stack.isEmpty()) {
				stack.push(i);
			}
			else if(arr[stack.peek()] >= arr[i]) {
				ans = ans+ (arr[stack.peek()] - arr[i]);
			}
			else {
				stack.push(i);
			}
		}
		
		int idx = stack.peek();
		
		for(int i=arr.length-1;i>=idx;i--) {
			ans = ans - (arr[idx] - arr[i]);
		}
		
		while(!stack.isEmpty()) stack.pop();
		
		
		for(int i= arr.length -1;i>=idx;i--) {
			if(stack.isEmpty()) {
				stack.push(i);
			}
			else if(arr[stack.peek()] >= arr[i]) {
				ans += (arr[stack.peek()] - arr[i]);
			}
			else {
				stack.push(i);
			}
		}
		
		System.out.println(ans);	
	}
}
