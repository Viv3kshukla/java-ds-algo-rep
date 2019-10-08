package com.javaxpert.apas;

public class Solution31 {

/*
 * Implement next permutation, which rearranges numbers into lexicographically
 * next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the
 * lowest possible order (i.e sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Examples :
 * 1,2,3 -> 1,3,2
 * 3,2,1 -> 1,2,3
 * 1,1,5 -> 1,5,1
 * 
 */
	
	public void nextPermutation(int [] nums) {
		int i = nums.length - 2;
		while(i >= 0 && nums[i+1] <= nums[i]) {
			i--;
		}
		
		if(i >= 0) {
			int j = nums.length - 1;
			while(j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums,i,j);
		}
		
		reverse(nums,i+1);
		
	}
	
	public void reverse(int [] nums,int start) {
		int i = start , j = nums.length -1;
		while(i < j) {
			swap(nums,i,j);
			i++;
			j--;
		}
	}
	
	private void swap(int [] nums,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	
}
