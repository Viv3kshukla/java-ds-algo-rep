package com.javaxpert.apas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution39 {

	/*
	 * Given a set of candidate numbers (candidates) (without duplicates) and target
	 * number (target), find all unique combinations in candidates where the
	 * candidate numbers sums to target
	 * 
	 * The same repeated number may be chosen from candidates unlimited number of
	 * times
	 * 
	 * Note , the solution set must not contain duplicate combinations Example :
	 * candidates = [2,3,6,7] Answer : target = 7 A solution set is : [[7],[2,2,3]]
	 * 
	 * Example 2: candidates = [2,3,5], target = 8 Answer : A solution set is :
	 * [[2,2,2,2],[2,3,3],[3,5]]
	 * 
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		if (candidates == null || candidates.length == 0) {
			return Collections.emptyList();
		}
		final List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);

		helper(candidates, target, 0, new ArrayList<>(), res);

		return res;
	}

	/*
	 *  Backtracking
	 */
	
	private void helper(int[] candidates, int target, int pos, List<Integer> comb, List<List<Integer>> res) {
		
		if(target == 0) {
			res.add(new ArrayList<>(comb)); // Dereference
			return;
		}
		
		for(int i = pos;i < candidates.length;i++) {
			int newTarget = target - candidates[i];
			if(newTarget >= 0) {
				comb.add(candidates[i]);
				helper(candidates,newTarget,i,comb,res);
				comb.remove(comb.size() - 1);
			}
			else {
				break;
			}
		}
		
	}
	
	public static void main(String args[]) {
		
		int [] candidates = {2,3,6,7};
		int target = 7;
		
		Solution39 solve = new Solution39();
		System.out.println(solve.combinationSum(candidates, target));
		
	}
	

}
