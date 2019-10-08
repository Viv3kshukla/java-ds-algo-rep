package com.javaxpert.apas;

public class Solution34 {
	
/* Find First and Last Position of Element in Sorted Array
 *  
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * 
 * Example : nums = [5,7,7,8,8,10], target = 8
 * Answer : [3,4]
 * 
 */
	
	private int extremeInsertionIndex(int [] nums, int target, boolean left) {
		int low = 0;
		int high = nums.length;
		
		while(low < high) {
			int mid = (low+high) / 2;
			if(nums[mid] > target || (left && target == nums[mid])) {
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
		return low;
	}
	
	public int[] searchRange(int[] nums,int target) {
		int [] targetRange = {-1,-1};
		
		int leftIdx = extremeInsertionIndex(nums, target, true);
		
		if(leftIdx == nums.length || nums[leftIdx] != target) {
			return targetRange;
		}
		
		targetRange[0] = leftIdx;
		targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
		
		return targetRange;
		
		
	}
	
	
}
