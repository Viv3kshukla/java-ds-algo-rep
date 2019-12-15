package com.javaxpert.search;

public class BS2 {
	
	static final int FIRST = 0;
	static final int LAST = 1;
	
	
	public int binarySearch(int [] nums,int x,int searchType) {
		int low = 0;
		int high = nums.length - 1;
		int result = -1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			if(nums[mid] == x) {
				if(searchType == FIRST) {
					result = mid;
					high = mid-1;
				}
				else if(searchType == LAST) {
					result = mid;
					low = mid+1;
				}
			}
			
			else if(x < nums[mid]) high = mid + 1;
			else low = mid + 1;
			
		}
		
		return result;
	}
	
}
