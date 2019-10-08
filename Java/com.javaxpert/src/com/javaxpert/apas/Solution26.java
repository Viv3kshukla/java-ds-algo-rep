package com.javaxpert.apas;

public class Solution26 {
/*
 * Give a sorted array nums , remove the duplicates in-place such that
 * each element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array , you must do this by 
 * modifying the input array in-place with O(1) extra memory
 * 
 * Given nums = [1,1,2] , 
 * your function should return length = 2, 
 * 
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference , which means
 * modification to the input array will be known to the caller
 * 
 * Internally you can think of this :
 * nums is passed by reference without making a copy , any modification in your function
 * 
 */
	
	public static int removeDuplicates(int [] nums) {
		if(nums.length == 0) return 0;
		int i = 0;
		for(int j = 1;j< nums.length;j++) {
			if(nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
	}
	
	public static void main(String args[]) {
		int [] nums = {1,1,2};
		int len = removeDuplicates(nums);
		
		for(int i = 0;i<len;i++) {
			System.out.println(nums[i]);
		}
	}
	
	
	
	
}
