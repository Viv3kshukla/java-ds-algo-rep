package com.javaxpert.apas;

import java.util.Arrays;

/*
 * Given an array of n integers where n > 1 , return an array output such that 
 * output[i] is equal to the product of all the elements of nums
 * except nums[i]
 * 
 * Input : nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * Note : Please solve it without division and in O(n).
 * Follow up : 
 * Could you solve it with constant space complexity ? The output array
 * does not count as extra space for purpose of space complexity analysis.
 */

public class Solution238 {
	public int[] productExceptSelf(int [] nums) {
		int n = nums.length;
		int [] output = new int[n];
		Arrays.fill(output, 1);
		int left = 1;
		int right = 1;
		
		for(int i=0;i<nums.length; i++) {
			output[i] = output[i] * left;
			left = left * nums[i];
			output[n - 1 - i] = output[n - 1 - i] * right;
			right = right * output[n - 1 - i];
		}
		
		return output;
		
	}
	
	public int [] productExceptSelf2(int [] nums) {
		int n = nums.length;
		int [] res = new int[n];
		
		res[0] = 1;
		for(int i = 1;i < n;i++) {
			res[i] = res[i-1] * nums[i-1];
		}
		
		int right = 1;
		for(int i = n-1; i>= 0; i--) {
			res[i] = res[i] * right;
			right = right * nums[i];
		}
		
		return res;
	}
}
