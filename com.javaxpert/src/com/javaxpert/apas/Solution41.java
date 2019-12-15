package com.javaxpert.apas;

import java.util.HashSet;

public class Solution41 {
	
/*
 * Given an unsorted integer array, find the smallest missing positive
 * integer.
 * Example 1: [1,2,0]
 * Answer : 3
 * 
 * Example 2: [3,4,-1,1]
 * Answer = 2;
 * 
 * Required Complexity : O(n) time and O(1) space complexity
 */
	public int firstMissingPositive(int [] nums) {
		
		if(nums == null || nums.length == 0) {
			return 1;
		}
		int length = nums.length;
		
		for(int i = 0;i < length;i++) {
			int num = nums[i];
			while(nums[i] <= length && nums[i] > 0 && nums[num -1] != num) {
				nums[i] = nums[num-1];
				nums[num-1] = num;
				num = nums[i];
			}
		}
		
		for(int i = 0;i < length;i++) {
			if(nums[i] != i+1) {
				return i+1;
			}
		}
		return length + 1;
	}
	
	public int firstMissingPositiveExtraSpace(int [] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i: nums) {
			set.add(i);
		}
		
		for(int i = 0;i <= nums.length; i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String args[]) {
		int [] nums = {3,4,-1,1};
		Solution41 solve = new Solution41();
		System.out.println(solve.firstMissingPositive(nums));
	}
	
}
