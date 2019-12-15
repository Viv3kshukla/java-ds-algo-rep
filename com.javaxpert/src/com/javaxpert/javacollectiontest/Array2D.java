package com.javaxpert.javacollectiontest;

import java.util.Scanner;

public class Array2D {
	
	
	static void print2DArray(Integer [][] array) {
		for(Integer[] aux: array) {
			for(Integer i: aux) {
				System.out.println("i "+ i);
			}
		}
	}
	
	static void getInput2DArray(Integer [][] array,Scanner scan) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				array[i][j] = scan.nextInt();
			}
		}
	}
	
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Integer [][] arr = new Integer[n][n];
		
		getInput2DArray(arr,scan);
		print2DArray(arr);
		
	}
}
