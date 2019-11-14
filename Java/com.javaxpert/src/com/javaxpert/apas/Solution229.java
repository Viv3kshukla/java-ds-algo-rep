package com.javaxpert.apas;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an integer array of size n , find all elements that appear more
 * than lower(n/3) times
 * Note : The algorithm should run in linear time .
 * 
 * Input : [3,2,3]
 * Output: [3]
 * 
 */

public class Solution229 {
	public List<Integer> majorityElement(int [] nums) {
		int num1 = 0;
		int count1 = 0;
		int num2 = 0;
		int count2 = 0;
		
		List<Integer> res = new ArrayList<>();
		
		for(int n : nums) {
			if(n == num1) {
				count1++;
			} 
			else if(n == num2) {
				count2++;
			}
			else if(count1 == 0) {
				num1 = n;
				count1 = 1;
			}
			else if(count2 == 0) {
				num2 = n;
				count2 = 1;
			}
			else {
				count1--;
				count2--;
			}
		}
		
		count1 = 0;
		count2 = 0;
		
		for(int n: nums) {
			if(n == num1) {
				count1++;
			}
			else if(n == num2) {
				count2++;
			}
		}
		
		if(count1 > nums.length / 3) {
			res.add(num1);
		}
		if(count2 > nums.length / 2) {
			res.add(num2);
		}
		
		return res;
		
	
	}
}
