package com.javaxpert.apas;

import java.util.HashSet;

public class Solution3 {
/*
 * Given a string , find the length of longest substring without repeating characters
 * 
 * Input : "abcabcbb"
 * Output : 3
 * Explanation : The answer is "abc", with the length 3.
 * 
 */
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		int [] index = new int[128];
		for(int j=0,i=0;j<n;j++) {
			i = Math.max(index[s.charAt(j)], i);
			ans = Math.max(ans, j - i + 1);
			index[s.charAt(j)] = j+1;
		}
		return ans;
	}
	
	public int lengthOfLongestSubstring2(String s) {
		int aPointer = 0;
		int bPointer = 0;
		int max = 0;
		HashSet<Character> set = new HashSet<Character>();
		while(bPointer < s.length()) {
			if(!set.contains(s.charAt(bPointer))) {
				set.add(s.charAt(bPointer));
				bPointer++;
				max = Math.max(set.size(), max);
			}
			else {
				set.remove(s.charAt(aPointer)); 
				aPointer++;
			}
		}
		return max;
	}
	
	
	
	
	
}
