package com.javaxpert.apas;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers and an integer k , find out whether
 * there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.
 * 
 * Input : nums = [1,2,3,1], k = 3
 * Output: true
 * 
 */

public class Solution219 {
	
	public boolean containsNearbyDuplicate(int [] nums,int k) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i < nums.length;i++) {
			if(set.contains(nums[i])) return true;
			set.add(nums[i]);
			if(set.size() > k) {
				set.remove(nums[i-k]);
			}
		}
		return false;
	}
	
	
}
