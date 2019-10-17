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
	
	
	public static List<List<Integer>> subsets(int [] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res,nums,0,new ArrayList<>());
		return res;
	}
	
	public static void backtrack(List<List<Integer>> res, int[] nums,int pos,List<Integer> subset) {
		if(pos == nums.length) {			
			res.add(new ArrayList<>(subset));
			return;
		}
		
		// as we are passing through the array 
		
		backtrack(res,nums,pos+1,subset);	// without taking current element
		subset.add(nums[pos]);
		backtrack(res,nums,pos+1,subset);	// with taking current element
		subset.remove(subset.size() -1);
		
	}
	
	public static void main(String args[]) {
		
		int [] nums = {1,2};
		List<List<Integer>> lists = subsets(nums);
		for(List<Integer> list : lists) {
			for(Integer val : list) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
	}
	
}
