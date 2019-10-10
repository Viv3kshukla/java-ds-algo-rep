package com.javaxpert.apas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution40 {
	
/*
 * Given a collection of candidate numbers (candidates) and a target
 * number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target
 * 
 * Each number in the candidates may only be used once in the combination.
 * 
 * Node , All the numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * Example 1: candidates = [10,1,2,7,6,1,5],target = 8
 * Answer : A solution set is : [[1,7],[1,2,5],[2,6],[1,1,6]]
 * 
 * 
 */
	
	public List<List<Integer>> dfs(int [] nums,int target) {
		
		if(nums == null || nums.length == 0) {
			return Collections.emptyList();
		}
		final List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		dfs(nums,target,0,new ArrayList<>(),res);
		return res;
	}
	
	public void dfs(int [] nums,int target,int index, List<Integer> comb, List<List<Integer>> result) {
		
		if(target == 0) {
			result.add(new ArrayList<>(comb));
		}
		
		for(int i=index; i< nums.length;i++) {
			int newTarget = target - nums[i];
			if(newTarget >= 0) {
				comb.add(nums[i]);
				dfs(nums,newTarget,i+1,comb,result);
				comb.remove(comb.size() - 1);
			}
			else {
				break;
			}
			
			// Skip duplicates
			
			while(i < nums.length-1 && nums[i] == nums[i+1]) {
				i++;	// Move i to the end of the duplicates
			}
			
		}
	}
	
	public static void main(String args[]) {
		int [] nums = {10,1,2,7,6,1,5};
		int target = 8;
		Solution40 solve = new Solution40();
		System.out.println(solve.dfs(nums,target));
	}
	
	
	
	
}
