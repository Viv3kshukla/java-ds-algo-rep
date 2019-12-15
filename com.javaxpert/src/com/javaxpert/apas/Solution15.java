package com.javaxpert.apas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution15 {
	
// Given an array nums of n integers, are there elements a,b,c in nums
//	such that a+b+c = 0 ? Find all unique triplets in the array which 
//	gives the sum  of zero.
	
// The solution set must not contain duplicate triplets .
//	Example : nums [-1,0,1,2,-1,-4] , answer : [ [-1,0,1],[-1,-1,2] ]
	
	public static List<List<Integer>> threeSum(int[] nums) {
		
		if(nums == null || nums.length < 3) {
			return Collections.emptyList();
		}
		Arrays.sort(nums);
		final List<List<Integer>> res = new ArrayList<>();
		
		for(int i = 0;i < nums.length -2; i++) {
			if(nums[i] > 0) {
				break;
			}
			
			if(i > 0 && nums[i] == nums[i-1]) {		// skip duplicates
				continue;
			}
			
// now it got reduced to two sum problem 
			
			int low = i+1;
			int high = nums.length - 1;
			int sum = 0 - nums[i];
			
			while(low < high) {
				if(nums[low] + nums[high] == sum) {
					res.add(Arrays.asList(nums[i],nums[low],nums[high]));
					while(low < high && nums[low] == nums[low+1]) low++;		// cause we don't want duplicates
					while(low < high && nums[high] == nums[high-1]) high--;		// cause we don't want duplicates
					low++;
					high--;
				}
				else if (nums[low]+nums[high] > sum) {
					high--;
				}
				else {
					low++;
				}
			}
			
		}
		
		return res;
		
	}
	
	public static void main(String args[]) {
		int [] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}
	
	
}
