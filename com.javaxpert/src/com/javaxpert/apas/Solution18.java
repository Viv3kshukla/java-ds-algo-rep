package com.javaxpert.apas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution18 {
	
/*
 * 
 * Given an array nums of n integers and an integer target ,
 * are there elements a, b, c and d in nums such that a + b + c + d = target
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example :
 * nums = [1,0,-1,0,-2,2]
 * target = 0
 * Answer : [[-1,0,0,1],[-2,-1,1,2],[-2,0,0,2]]
 * 
 */
	
	public List<List<Integer>> fourSum(int [] nums , int target) {
		
		if(nums == null || nums.length < 4) {
			return Collections.emptyList();
		}
		
		final List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		
		for(int i = 0;i < nums.length - 3; i++) {
			
			if(i > 0 && nums[i] == nums[i-1]) {	// we don't want duplicates
				continue;
			}
			
			for(int j = i+1 ;j < nums.length -2 ;j++) {
				if(j > i+1 && nums[j] == nums[j-1]) {	// we don't want duplicates
					continue;
				}
				
				int newTarget = target - nums[i] - nums[j];
				
				int low = j+1;
				int high = nums.length -1;
				
				while(low < high) {		// here if you want to remove dup you can do it either solution15 way or this way 
					if(low > j+1 && nums[low] == nums[low-1]) {
						low++;
						continue;
					}
					if(high < nums.length -1 && nums[high] == nums[high+1]) {
						high--;
						continue;
					}
					
					int sum = nums[low] + nums[high];
					
					if(sum < newTarget) {
						low++;
					}
					else if(sum > newTarget) {
						high--;
					}
					else {
						res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
						low++;
						high--;
					}	
				}
			}
		}
		return res;
	}
	
	
	
}
