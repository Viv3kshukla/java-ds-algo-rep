package com.javaxpert.apas;

import java.util.Arrays;

/*
 * Given an array of size n , find the majority element. The majority elememt is the 
 * element that appears more that floor(n/2) times .
 * 
 * You may assume that the array si non-empty and the majority element 
 * always exist in the array
 */


public class Solution169 {
	public int majorityElement(int [] nums) {
		int count = 0;
		Integer candidate = null;
		
		for(int num : nums) {
			if(count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1: -1;
		}
		
		return candidate;
	}
	
	public int majorityElement2(int [] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	public int majorityElement3(int [] nums) {
		
		int majorityCount = nums.length/2;
		
		for(int num : nums) {
			int count = 0;
			for(int elem : nums) {
				if(elem == num) {
					count += 1;
				}
			}
			if(count > majorityCount) {
				return num;
			}
		}
		
		return -1;
	}

}
