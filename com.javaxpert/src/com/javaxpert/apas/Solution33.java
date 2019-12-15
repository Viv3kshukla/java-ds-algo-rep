package com.javaxpert.apas;

public class Solution33 {
/*
 * Suppose an array sorted in ascending order is rotated at some pivot
 * unknown to you beforehand.
 * 
 * You are give a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in order of O(logn)
 * 
 * Example: nums = [4,5,6,7,0,1,2], target = 0
 * Answer : 4
 * 
 */
	
	public int search(int [] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			if(nums[mid] == target) {
				return mid;
			}
			if(nums[low] <= nums[mid]) {
				if(target < nums[mid] && target >= nums[low]) {
					high = mid-1;
				}
				else {
					low = mid+1;
				}
			}
			if(nums[mid] <= nums[high]) {
				if(target > nums[mid] && target <= nums[high]) {
					low = mid+1;
				}
				else {
					high = mid - 1;
				}
			}
			
		}
		return -1;
	}
	
	
	
}
