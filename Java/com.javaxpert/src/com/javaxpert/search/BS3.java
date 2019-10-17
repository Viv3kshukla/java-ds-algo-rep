package com.javaxpert.search;

public class BS3 {
	

	//How many times is a sorted array (with no duplicates) rotated  ?


	// number of rotations = index of minimum element
	
	public int binarySearchRotated(int [] nums) {
		int n = nums.length;
		int low = 0;
		int high = n -1;
		while(low <= high) {
			if(nums[low] <= nums[high]) return low;
			int mid = (low + high) >> 1;
			int next = (mid + 1) % n;
			int prev = (mid - 1) % n;
			if(nums[mid] <= nums[next] && nums[mid] <= nums[prev]) return mid;
			else if(nums[mid] <= nums[high]) high = mid-1;
			else if(nums[mid] >= nums[low]) low = mid+1;
		}
		
		return -1;
		
	}
	
	
}
