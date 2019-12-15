package com.javaxpert.geeksforgeeks.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthSmallestElement {
	
	public int solve(int [] arr,int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i: arr) {
			minHeap.add(i);
			if(minHeap.size() > k) {
				minHeap.remove();
			}
		}
		return minHeap.remove();
	}
	
	
	public int solveWithQuickSelect(int [] arr,int k) {
		
		
		
		return 0;
	}
	
	
	public static void swap(int [] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public static void quickSelect(int [] arr,int left, int right,int k) {
		
		if( left < right) {
			int index = partition(arr , left, right);
			
			if(k == index) {
				return;
			}
			else if(k < index ) {
				quickSelect(arr, left, index-1, k);
			}
			else {
				quickSelect(arr,index+1,right,k);
			}
		}
 		
		
	}
	
	
	public static int partition(int [] arr,int left,int right) {
		int pivot = arr[(left + right)/2];
		
		while(left <= right) {
			
			while(arr[left] < pivot) {
				left++;
			}
			
			while(pivot < arr[right]) {
				right--;
			}
			
			if(left <= right) {
				swap(arr,left,right);
				left++;
				right--;
			}
			
		}
		
		return left;

	}
//	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(str -> Integer.parseInt(str)).toArray();
		
		
		int k = Integer.parseInt(br.readLine());
		quickSelect(arr,0,(arr.length - 1),k-1);
		
		System.out.println("the answer is " + arr[k-1]);
	}
}
