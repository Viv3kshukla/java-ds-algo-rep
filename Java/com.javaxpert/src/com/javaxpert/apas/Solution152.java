package com.javaxpert.apas;

public class Solution152 {
	
	public int maxProduct(int [] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int max = nums[0];
		int  min = nums[0];
		int res = nums[0];
		
		for(int i=1;i<nums.length;i++) {
			int preMax = max;
			int preMin = min;
			max = Math.max(Math.max(nums[i], preMax * nums[i]), preMin * nums[i]);
			min = Math.min(Math.min(nums[i], preMax* nums[i]), preMin * nums[i]);
			res = Math.max(max, res);
		}
		
		return res;
	}
	
}
