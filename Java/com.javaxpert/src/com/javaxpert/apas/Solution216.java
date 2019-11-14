package com.javaxpert.apas;

import java.util.ArrayList;
import java.util.List;

/*
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should 
 * be a unique set of numbers.
 * Note : All numbers will be positive integers.
 * 		  The solution set must not contain duplicate combinations .
 * 
 * Input : k = 3, n = 7
 * Output: [[1,2,4]]
 */

public class Solution216 {
	
	public List<List<Integer>> combinationSum3(int k,int n) {
		List<List<Integer>> ans = new ArrayList<>();
		backtrack(ans,new ArrayList<>(),k,1,n);
		return ans;
	}
	
	private void backtrack(List<List<Integer>> ans, List<Integer> comb,int k,int start,int n) {
		if(comb.size() > k) return;
		if(comb.size() == k && n == 0) {
			List<Integer> res = new ArrayList<>(comb);
			ans.add(res);
			return;
		}
		
		for(int i = start; i <= 9;i++) {
			if(n - i >= 0) {
				comb.add(i);
				backtrack(ans,comb,k,i+1,n-i);
				comb.remove(comb.size() - 1);
			}
		}
		
	}
	
	
	
}
