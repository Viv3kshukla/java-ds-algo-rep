package com.javaxpert.geeksforgeeks.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromicSubstring {
	
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int n = input.length();
		int low,high,maxn = 1,start = 0;
		for(int i=1;i<n;i++) {
			low = i-1;
			high = i;
			
			while(low >= 0 && high < n && input.charAt(low) == input.charAt(high)) {
				if(high - low + 1 > maxn) {
					start = low;
					maxn = high - low + 1;
				}
				low--;
				high++;
			}
			
			low = i-1;
			high = i+1;
			
			while(low >= 0 && high < n && input.charAt(low) == input.charAt(high)) {
				if(high-low + 1 > maxn) {
					start = low;
					maxn = high - low +1;
				}
				low--;
				high++;
			}
			
		}
		System.out.println(input.substring(start,start+maxn));
	}
}
