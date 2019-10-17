package com.javaxpert.apas;

public class Solution80 {
	
	public int removeDuplicates(int [] nums) {
		if(nums == null) {
			return 0;
		}
		int n = nums.length;
		if(nums.length <= 2) return n;
		int length = 2;
		
		for(int i=2;i<n;i++) {
			if(nums[i] != nums[length-2]) {
				nums[length] = nums[i];
				length++;
			}
		}
		return length;
	}
	
}
