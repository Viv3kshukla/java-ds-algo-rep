package com.javaxpert.apas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution90 {
	/*
	 * Given a collection of integers that might contain duplicates,
	 * nums, return all possible subsets ( the power set ). 
	 * 
	 * Note : The solution set must not contain duplicate subsets.
	 * 
	 * Example : nums = [1,2,2]
	 * Answer : [[2],[1],[1,2,2],[2,2],[1,2],[]]
	 */

		public List<List<Integer>> subsetsWithDup(int [] nums) {
			if(nums == null || nums.length == 0) {
				return Collections.emptyList();
			}
			
			List<List<Integer>> subsets = new ArrayList<>();
			Arrays.sort(nums);
			backtrack(subsets, nums, 0, new ArrayList<>());
			return subsets;
		}
		
		private void backtrack(List<List<Integer>> subsets, int[] nums,int pos,List<Integer> set) {
			subsets.add(new ArrayList<>(set));
			
			for(int i=pos; i < nums.length;i++) {
				if(i != pos && nums[i] == nums[i-1]) {
					continue;
				}
				set.add(nums[i]);
				backtrack(subsets,nums,i+1,set);
				set.remove(set.size() - 1);
			}
			
		}
		
	
	
}

