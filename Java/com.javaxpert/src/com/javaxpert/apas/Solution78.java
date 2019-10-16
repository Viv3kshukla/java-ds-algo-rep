package com.javaxpert.apas;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
/*
 * Given a set of distinct integers, nums, return all possible subsets
 * (the power set)
 * 
 * Note : The solution set must not contain duplicate subsets
 * Example : nums = [1,2,3]
 * Answer : [all subsets]
 * 
 * 
 */
	
	
	public List<List<Integer>> subsets(int [] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res,nums,0,new ArrayList<>());
		return res;
	}
	
	public void backtrack(List<List<Integer>> res, int[] nums,int pos,List<Integer> subset) {
		if(pos == nums.length) {
			res.add(new ArrayList<>(subset));
			return;
		}
		
		backtrack(res,nums,pos+1,subset);
		subset.add(nums[pos]);
		backtrack(res,nums,pos+1,subset);
		subset.remove(subset.size() -1);
		
		
	}
	
}
