package com.javaxpert.dsalgoimpl.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ContinuousMedian {
	
	public static void addNumber(int number, PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers) {
		if(lowers.size() == 0 || number < lowers.peek()) {
			lowers.add(number);
		}
		else {
			highers.add(number);
		}
	}
	
	
	public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers:highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers:lowers;
		if(biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}
	}
	
	public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers:highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers:lowers;
		if(biggerHeap.size() == smallerHeap.size()) {
			return ((double)biggerHeap.peek() + smallerHeap.peek())/2;
		}
		else {
			return biggerHeap.peek();
		}
	}
	
	public static double [] getMedians(int [] array) {
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
		double [] medians = new double[array.length];
		for(int i=0;i<array.length;i++) {
			int number = array[i];
			addNumber(number,lowers,highers);
			rebalance(lowers,highers);
			medians[i] = getMedian(lowers,highers);
		}
		return medians;
	}
	
	
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = scan.nextInt();
		}
		
		double [] answer = getMedians(arr);
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
		
	}
}
