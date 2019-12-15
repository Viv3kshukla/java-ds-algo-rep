package com.javaxpert.apas;

public class Solution27 {
	
	/*
	 * Given an array nums and a value val , remove all instances of that
	 * value in-place and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this by 
	 * modifying input array in-place with O(1) extra memory
	 * 
	 * The order of elements can be changed . It doesn't matter what you leave
	 * beyond the new length.
	 * 
	 * Example: nums = [3,2,2,3] , val = 3
	 * Answer : 2 , (if want to know the reason refer Solution 26)
	 * 
	 */
	
	public static int removeElement(int [] nums, int val) {
		int idx = 0;
		int n = nums.length;
		
		for(int i = 0;i < nums.length;i++) {
			if(nums[i] != val) {
				nums[idx++] = nums[i];
			}
		}
		return idx;
	}
	
	public static void main(String args[]) {
		int [] nums = {3,2,2,3};
		int val = 3;
		int len = removeElement(nums,val);
		for(int i = 0;i<len;i++) {
			System.out.println(nums[i]);
		}
	}
	
	
	
}
