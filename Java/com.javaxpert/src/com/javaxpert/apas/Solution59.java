package com.javaxpert.apas;

public class Solution59 {
	
	/*
	 * Given a positive integer n, generate a square matrix
	 * filled with elements from 1 to n2 in spiral order
	 * 
	 * Example : 3
	 * Answer [[1,2,3],[4,5,6],[7,8,9]]
	 * 
	 */
	
	public int[][] generateMatrix(int n) {
		if(n <= 0) return new int [0][0];
		int [][] ans = new int[n][n];
		int num = 1;
		int lv = 0;
		while(2*lv < n) {
			for(int i=lv;i<n-lv;i++) ans[lv][i] = num++;
			for(int i=lv+1;i < n-lv;i++) ans[i][n-lv-1] = num++;
			for(int i = n-lv-2;i>=lv;i--) ans[n-lv-1][i] = num++;
			for(int i = n-lv-2;i>=lv+1;i--) ans[i][lv] = num++;
		}
		return ans;
	}
	
}
