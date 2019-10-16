package com.javaxpert.apas;

public class Solution48 {

/*
 * You are given an n*n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise)
 * 
 * Note : You have to rotate the image in-place, which means you have
 * to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * 
 * Example : Given input matrix = [
 * 									[1,2,3],
 * 									[4,5,6],
 * 									[7,8,9]
 * 								  ]
 * rotate the input matrix in-place such that it becomes :
 * 	[
 * 		[7,4,1],
 * 		[8,5,2],
 * 		[9,6,3]
 * ]
 */
	
	public void rotate(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		
		int n = matrix.length;
		
		for(int i=0;i<n/2;i++) {
			for(int j = i;j < n-i-1;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-j-1][i];
				matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
				matrix[j][n-i-1] = temp;
			}
		}
	}

	// here trick is to take transpose and after that flip it horizontally
	
	public void rotate2(int [][] matrix) {
		if(matrix == null || matrix.length == 0|| matrix[0].length == 0) {
			return;
		}
		int n = matrix.length;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n/2;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-j-1];
				matrix[i][n-j-1] = temp;
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
// transpose matrix in-place	
	
//	public void transpose(int A[][],int N) 
//    { 
//        for (int i = 0; i < N; i++) 
//            for (int j = i+1; j < N; j++) 
//            { 
//                 int temp = A[i][j]; 
//                 A[i][j] = A[j][i]; 
//                 A[j][i] = temp; 
//            } 
//    }
	
	
	
	
	
	
	
	
	
	
	
}
