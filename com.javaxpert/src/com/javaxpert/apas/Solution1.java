package com.javaxpert.apas;

import java.util.HashMap;
import java.util.Map;

// Given an array of integers , return indices of the two numbers such that
// they add up to a specific target

//you may assume that each input would have exactly one solution
// and you may not use same element twice

// Given nums = [2,7,11,15] , target = 9 , return [0,1]


public class Solution1 {
	
	public int[] twoSum(int [] nums, int target) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0;i < nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement)) {
				return new int[] {map.get(complement),i};
			}
			map.put(nums[i],i);
		}
		 throw new IllegalArgumentException("No two such solution");
	}
	
	// second method
	public int [] twoSumMethod2(int [] nums, int target) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i],i);
		}
		
		for(int i=0;i<nums.length;i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement) && map.get(complement) != i) {
				return new int[] {i, map.get(complement)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
		
	}
	
	public int[] twoSumMethod3(int [] nums, int target) {
		for(int i = 0;i< nums.length;i++) {
			for(int j = i+1;j < nums.length;j++) {
				if(nums[j] == target - nums[i]) {
					return new int[] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	
	
	
}
								