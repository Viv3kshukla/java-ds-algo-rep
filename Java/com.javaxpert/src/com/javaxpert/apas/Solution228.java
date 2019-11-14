package com.javaxpert.apas;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted integer array without duplicates, return the summary of its ranges
 * Input : [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 */

public class Solution228 {
	public List<String> summaryRanges(int[] nums) {
		List<String> summary = new ArrayList<String>();
		for(int i = 0,j = 0; j < nums.length;j++) {
			if(j + 1 < nums.length && nums[j+1] == nums[j] + 1) {
				continue;
			}
			if(i == j) {
				summary.add(nums[i] + "");
			}
			else {
				summary.add(nums[i] + "->" + nums[j]);
			}
			i = j+1;
		}
		return summary;
	}
}
