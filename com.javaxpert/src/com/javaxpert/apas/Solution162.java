package com.javaxpert.apas;

public class Solution162 {
	public int findPeakElement(int [] nums) {
		int low = 0;
		int high = nums.length -1;
		int result = 0;
		while(low < high) {
			int mid = (low + high) / 2;
			if(nums[mid] > nums[mid+1]) {
				high = mid;
			}
			else {
				result = mid+1;
				low = mid+1;
			}
		}
		return result;	
	}
}
