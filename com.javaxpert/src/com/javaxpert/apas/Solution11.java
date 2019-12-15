package com.javaxpert.apas;

public class Solution11 {
	
// Given n non-negative integers  a1, a2 , .. an, where each represents
// a point at coordinate (i, ai) . n vertical lines are drawn such that
// the two endpoints of line i is at (i , ai) and (i,0). Find two lines,
// which together with x-axis forms a container, such that the container 
// contains the most water .
	
// Example : [1,8,6,2,5,4,8,3,7]
	
	
// here in the solution , we wanna keep tallest vertical line that we can
//	and then move the one that's constraining it. So we wanna move the smaller one to hopefully
//	find taller pointer from that side .

	public int maxArea(int [] height) {
		int maxarea = 0,l = 0,r = height.length -1;
		
		while(l < r) {
			maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r-l));
			
			if(height[l] < height[r]) {
				l++;
			}
			else {
				r--;
			}
		}

		return maxarea;
	}
	
	public int maxAreaMethod2(int [] height) {
		int maxarea = 0;
		
		for(int i = 0;i < height.length; i++) {
			for(int j = i+1;j < height.length; j++) {
				maxarea = Math.max(maxarea, Math.min(height[i], height[j])*(j-i));
			}
		}
		
		return maxarea;
		
	}
	
	
}
