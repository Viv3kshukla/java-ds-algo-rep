package com.javaxpert.apas;

public class Solution55 {
	/*
	 * Given an array of non-negative integers, you are initially positioned
	 * at the first index of the array.
	 * 
	 * Each element in the array represents you maximum jump length at
	 * that position.
	 * 
	 * Determine if you are able to reach the last index.
	 * Example: nums = [2,3,1,1,4]
	 * Answer : true
	 * Explanation: Jump 1 step from index 0 to 1 , then 3 steps to the last
	 * index. 
	 * 
	 */
	
	public boolean canJump(int [] nums) {
		int lastPos = nums.length -1;
		for(int i=nums.length-1; i>=0;i--) {
			if(i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}
		return lastPos == 0;
	}
	
}
