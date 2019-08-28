package com.javaxpert.geeksforgeeks.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

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
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
}
