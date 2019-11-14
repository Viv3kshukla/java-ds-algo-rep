package com.javaxpert.apas;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a non-negative index k where k <= 33 , return the kth index row of the 
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * In Pascals' triangle , each number is the sum of the two numbers directly
 * above it .
 * 
 * Could you optimize your algorithm to use only O(k) extra space ?
 * 
 */

public class Solution119 {
	
	public List<Integer> getRow(int rowIndex) {
		
		List<Integer> row = new ArrayList<>(rowIndex + 1);	
		row.add(1);
		for(int i = 1; i <= rowIndex; i++) {
			for(int j = i-1; j>= 1; j--) {
				row.set(j, row.get(j-1) + row.get(j));
			}
			row.add(1);
		}
		return null;
		
	}
	

}
