//package com.javaxpert.apas;
//
//import java.util.Stack;
//
//public class Solution85 {
//	
//	public maximalRec
//	
//	
//	
//	
//	
//	private int largestRectangleArea(int [] heights) {
//		if(heights == null || heights.length == 0) return 0;
//		Stack<Integer> stack = new Stack<Integer>();
//		int maxArea = 0;
//		for(int i=0;i<heights.length;i++) {
//			while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                int val = stack.pop();
//				maxArea = Math.max(maxArea, heights[val] * (stack.isEmpty() ? i: (i - stack.peek() - 1)));
//			}
//			stack.push(i);
//		}
//		while(!stack.isEmpty())  {
//            int val = stack.pop();
//			maxArea = Math.max(maxArea, heights[val] * (stack.isEmpty() ? heights.length : (heights.length - stack.peek() - 1)));
//		}
//		return maxArea;
//	}
//	
//}
