package com.javaxpert.apas;

import javax.sound.sampled.ReverbType;

/*
 * Given an array ,rotate the array to the right by k steps,
 * where k is non-negative
 * 
 * Example 1 : 
 * Input : [1,2,3,4,5,6,7] , k = 3
 * Output : [5,6,7,1,2,3,4]
 * 
 * Note : Try to come up as many solutions ans you can , there are at least 
 * 3 different ways to solve this problem
 * Could you do it in-place with O(1) extra space ?
 * 
 */

public class Solution189 {
	
	public void rotate(int [] nums, int k) {
		int temp, previous;
		for(int i=0;i < k;i++) {
			previous = nums[nums.length - 1];
			for(int j = 0;j < nums.length; j++) {
				temp = nums[j];
				nums[j] = previous;
				previous = temp;
			}
		}
	}
	
	public void rotate2(int [] nums, int k) {
		int [] a = new int[nums.length];
		for(int i=0;i< nums.length;i++) {
			a[(i+k) % nums.length] = nums[i];
		}
		for(int i=0;i< nums.length;i++) {
			nums[i] = a[i];
		}
	}
	
	public void rotate3(int [] nums,int k) {
		k = k% nums.length;
		reverse(nums,0,nums.length - 1);
		reverse(nums,0,k - 1);
		reverse(nums,k, nums.length - 1);
		
	}
	
	public void reverse(int [] nums,int start,int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
}
