package com.javaxpert.apas;

import java.util.Arrays;

public class Solution16 {

/*
 * Given an array nums of n integers and an integer target , find three
 * integers in nums such that the sum is closest to target integers.
 * Return the sum of three integers.
 * You may assume that each input would have exactly one solution.
 * 
 * Example : nums = [-1,2,1,-4] and target = 1
 * Answer : 2 (-1 + 2+ 1 = 2)
 * 
 */
	
	
	public static int threeSumClosest(int [] nums, int target) {
		int result = 0;
		Arrays.sort(nums);
		
		for(int i = 0;i< nums.length && i < 3;i++) {
			result += nums[i];
		}
		
		if (nums.length < 3) {
			return result;
		}
		
		for(int i = 0;i < nums.length -2 ;i++) {
			int low = i+1;
			int high = nums.length -1;
			while(low < high) {
				int currentSum = nums[i] + nums[low] + nums[high];
				if(currentSum > target) {
					high--;
				}
				else {
					low++;
				}
				
				if(Math.abs(currentSum - target) < Math.abs(result - target)) {
					result = currentSum;
				}
				
			}
		}
		
		return result;
	}
	
	public static void main(String args[]) {
		int [] nums = {-1,2,1,-4};
		int target = 1;
		System.out.println(threeSumClosest(nums,target));
	}
	
}
