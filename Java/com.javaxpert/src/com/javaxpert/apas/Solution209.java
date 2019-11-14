package com.javaxpert.apas;

/*
 * Given an array of n positive integers and a positive integer
 * s, find the minimal length of a contiguous subarray of which the 
 * sum >= s. I there isn't one , return 0 instead.
 * Example : s = 7, nums = [2,3,1,2,4,3]
 * Output : 2
 * 
 * Explanation : the subarray [4,3] has the minimal length under the
 * problem constraint.
 * Follow up :
 * If you have figured out the O(n) solution , try coding another solution 
 * of which the time complexity is O(n log n)
 * 
 */

public class Solution209 {
	public int minSubArrayLen(int s,int [] nums) {
		
		int n = nums.length;
		int ans = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;
		
		for(int i=0;i < n;i++) {
			sum += nums[i];
			while(sum >= s) {
				ans = Math.min(ans, i+1 - left);
				sum -= nums[left++];
			}
		}
		return (ans != Integer.MAX_VALUE) ? ans: 0;

	}
}
