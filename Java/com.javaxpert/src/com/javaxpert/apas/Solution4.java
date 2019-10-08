package com.javaxpert.apas;

// Median of Two Sorted Arrays

// There are two sorted arrays nums1 and nums2 of size m and n respectively.
// Find the median of the two sorted arrays . The overall run time complexity
// should be O(log(m+n))

// you may assume nums1 and nums2 cannot be both empty
// Example nums1 = [1,2] , nums2 = [3,4] , median = 2.5



public class Solution4 {
	
	public static double findMedianSortedArrays(int [] input1, int [] input2) {
		if(input1.length > input2.length) {
			return findMedianSortedArrays(input2,input1);
		}
		
		int x = input1.length;
		int y = input2.length;
		
		
		int low = 0;
		int high = x;
		int halfLen = (x+y+1)/2;
		while(low <= high) {
			int partitionX = (low+high)/ 2;
			int partitionY = halfLen - partitionX;
			
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE: input1[partitionX -1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE: input1[partitionX];
			
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE: input2[partitionY -1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE: input2[partitionY];

			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {	// partitioned at correct place
				if((x+y)%2 == 0) {
					return ((double)Math.max(maxLeftX,maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				}
				else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			}
			else if(maxLeftX > minRightY) {	//we are two right side for partition X
				high = partitionX - 1;
			}
			else {							//we are too far on the left side for partition X
				low = partitionX + 1;
			}
			
		}	
		
		throw new IllegalArgumentException();
				
	}
	
	public static void main(String args[]) {
		int [] x = {1,3,8,9,15};
		int [] y = {7,11,18,19,21,25};
		
		System.out.println(findMedianSortedArrays(x,y));
		
	}
	
	
	
}
