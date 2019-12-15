package com.javaxpert.apas;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers, find if the array contains duplicates.
 * Your function should return true if any value appears at least
 * twice in the array , and it should return false if every element is
 * distinct
 * 
 */

public class Solution217 {
	public boolean containsDuplicate(int [] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for(int x : nums) {
			if(set.contains(x)) return true;
			set.add(x);
		}
		return false;
	}
}	
