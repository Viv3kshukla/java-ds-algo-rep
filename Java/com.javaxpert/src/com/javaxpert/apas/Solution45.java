package com.javaxpert.apas;

import java.util.Arrays;

public class Solution45 {

/*
 *  Given an array of non-negative integers, you are initially positioned
 *  at the first index of the array.
 *  
 *  Each element in the array represents your maximum jump length at that
 *  position.
 *  
 *  Your goal is to reach the last index in the minimum number of jumps.
 *  
 *  Example: nums = [2,3,1,1,4]
 *  Answer : 2
 *  Explanation : The minimum number fo jumps to reach the last index is 2.
 *  Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *  You can assume that you can always reach the last index.
 */
	
	public int jump(int [] nums) {
		int step = 0;
		int last = 0;	// how far I can go already
		int cur = 0;	// maximum distance that i can go from the current position
		
		for(int i=0;i < nums.length;i++) {	// run out  of we can reach , need one more step
			if(i > last) {
				last = cur;
				step++;
				if(last >= nums.length) return step;
			}
			cur = Math.max(cur, i + nums[i]);
		}
		
		return step;
		
	}
	
	public int jump2(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<=i+nums[i] && j < nums.length;j++) {
                dp[j] = Math.min(dp[j],dp[i]+1);
            }
        }
        
        return dp[nums.length-1];
    }
	
	
	
	
	
}
