package com.javaxpert.search;

public class BS1 {

// simple binary search algorithm for sorted array without duplicate
	
	public int binarySearch(int [] nums, int x) {
		int n = nums.length;
		int low = 0;
		int high = n-1;
		while(low <= high) {
			int mid = (low + high) >>1;
			if(x == nums[mid]) return mid; 
			else if(x < nums[mid]) high = mid-1;
			else low = mid+1;
		}
		return -1;
	}
	
	public int binarySearchRec(int [] nums,int low ,int high,int x) {
		if(low <= high) {
			int mid = (low+high) >> 1;
			if(x == nums[mid]) {
				return mid;
			}
			else if(x < nums[mid]) {
				return binarySearchRec(nums, low, mid-1, x);
			}
			else {
				return binarySearchRec(nums, mid+1, high, x);
			}
		}
		return -1;
	}
	
	
}
