package com.javaxpert.apas;

public class Solution53 {
/*
 * Given an integer array nums, find the contiguous subarray 
 * (containing at least one number) which has the largest sum
 * and return its sum.
 * 
 * Example : nums = [-2,2,-3,4,-1,2,1,-5,4]
 * Answer : 6
 * Explanation : [4,-1,2,1] has the largest sum = 6
 * 
 * If you've figured out the O(n) solution , try coding another solution
 * using the divide and conquer approach, which is more subtle.
 * 
 * subtle meaning : delicate , precise
 */
	
	public int maxSubArray(int [] nums) {
		if(nums == null || nums.length == 0) return 0;
		int max = nums[0];
		int n = nums.length;
		int sum = nums[0];
		int maxSum = nums[0];
		for(int i=1;i<n;i++) {
			sum = Math.max(sum+nums[i], nums[i]);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}
	
	public int maxSumArray2(int [] nums) {
		return maxSubArray2(nums,0,nums.length-1);
	}
	
	private int maxSubArray2(int [] nums,int start,int end) {
		if(start == end) return nums[start];
		int mid = (start+end)/2;
		int max1 = maxSubArray2(nums,start,mid);
		int max2 = maxSubArray2(nums, mid+1, end);
		int max3 = crossMidMaxSum(nums,start,end,mid);
		return Math.max(max1, Math.max(max2, max3));
	}
	
	private int crossMidMaxSum(int[] nums,int start,int end,int mid) {
		int leftMax = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=mid;i >= start;i--) {
			sum += nums[i];
			if(sum > leftMax) leftMax = sum;
		}
		
		int rightMax = Integer.MIN_VALUE;
		sum = 0;
		for(int i = mid+1;i <= end;i++) {
			sum += nums[i];
			if(sum > rightMax) rightMax = sum;
		}
		return leftMax + rightMax;
		
	}
	
}
