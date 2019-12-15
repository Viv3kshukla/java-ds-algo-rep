package com.javaxpert.apas;

public class Solution35 {
	
/*
 * Given a sorted array and a target value , return the index if the
 * target is found . If not , return the index where it would be if it were
 * inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example : nums = [1,3,5,6], target = 5
 * Answer : 2
 * Example : nums = [1,3,5,6], target = 2
 * Answer : 1 ( as if 2 would have been present in the array it, it's index
 * would've been 
 * 
 */
	// remember low would be 1 more than high here .
	
	public static int searchInsert(int [] nums, int target) {
		
		if(nums == null || nums.length == 0) return 0;
		int low = 0;
		int high = nums.length -1;
		while(low <= high) {
			int mid = (low+high) / 2;
			if(nums[mid] == target) return mid;
			else if(nums[mid] > target) high = mid -1;
			else low = mid+1;
		}
		return low;
	}
	
	public static void main(String args[]) {
		
		int [] nums = {1,3,5,6};
		int target = 2;
		
		System.out.println(searchInsert(nums,target));
		
	}
	
	
}
