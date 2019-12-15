package com.javaxpert.search;

public class BS4 {
	
	public int circularArraySearch(int [] nums,int x) {
		int low = 0;
		int high = 0;
		while(low <= high) {
			int mid = (low+high)/2;
			if(x == nums[mid]) return mid;
			if(nums[mid] <= nums[high]) {
				if(x > nums[mid] && x <= nums[high]) {
					low = low + 1;
				}
				else {
					high = mid -1;
				}
			}
			else if(nums[low] <= nums[mid]) {
				if(x > low && x <= nums[mid]) {
					high = mid-1;
				}
				else {
					low = mid + 1;
				}
			}
			
		}
		
		return -1;
	}
	
	
}
