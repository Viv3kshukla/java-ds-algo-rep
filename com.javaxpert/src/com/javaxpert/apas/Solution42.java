package com.javaxpert.apas;

import java.util.Stack;

public class Solution42 {
	
	/*
	 *  Trapping Rain Water
	 *  
	 *  Given n non-negative integers representing an elevation map
	 *  where the width of each bar is 1, compute how much water it is
	 *  able to trap after raining.
	 *  
	 *  Example : [0,1,0,2,1,0,1,3,2,1,2,1]
	 *  Answer : 6
	 *  
	 */
	
	public int trap(int [] height) {
		
		if(height == null) return 0;
		int length = height.length;
		int left[] = new int[length];
		int right [] = new int[length];
		left[0] = height[0];
		for(int i=1;i<length;i++) {
			left[i] = Math.max(left[i-1], height[i]);
		}
		right[length-1] = height[length-1];
		for(int i=length-2;i>=0;i--) {
			right[i] = Math.max(right[i+1], height[i]);
		}
		
		int answer = 0;
		for(int i=0;i<length;i++) {
			answer += Math.min(left[i], right[i]) - height[i];
		}
		
		return answer;
	}
	
	public int trapMethod2(int [] height) {
		if(height == null) return 0;
		int leftMax = 0,rightMax = 0;
		int left = 0,right = height.length-1;
		int ans = 0;
		while(left < right) {
			if(height[left] < height[right]) {
				if(height[left] >= leftMax) {
					leftMax = height[left];
				}
				ans += leftMax - height[left];
				left++;
			}
			else {
				if(height[right] >= rightMax) {
					rightMax = height[right];
				}
				ans += rightMax - height[right];
				right--;
			}
		}
		return ans;
		
	}
	
	public int trapMethod3(int [] height) {
		int ans = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0;i < height.length; i++) {
			while(!stack.isEmpty()  && height[i] > height[stack.peek()]) {
				int top = stack.pop();
				if(stack.isEmpty()) break;
				int distance = i - stack.peek() - 1;
				int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
				ans = + distance* bounded_height;
			}
			stack.push(i);
		}	
		return ans;
	}
}



