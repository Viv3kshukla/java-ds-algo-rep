package com.javaxpert.geeksforgeeks.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
	
	
	// with int you can use Arrays.stream(arr).max().getAsInt()
	
	
	public static int lis(final List<Integer> arr) {
	
		Integer [] dp = new Integer[arr.size()];
		dp[0] = 1;
		for(int i=1;i<arr.size();i++) {
			dp[i] = 1;
			for(int j = 0;j<i;j++) {
				if(arr.get(i) > arr.get(j) && dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
//		Integer answer = Arrays.stream(dp).max((a,b) -> a.compareTo(b)).get();
		Integer answer = Arrays.stream(dp).max((a,b) -> a.compareTo(b)).get();
		return answer;
		
	}
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().trim().split(",");
		List<Integer> arr = new ArrayList<Integer>();
		for(String str: input) {
			arr.add(Integer.parseInt(str.trim()));
		}
		
//		arr.forEach(s -> System.out.print(s + ", "));
//		System.out.println();
//		System.out.println(arr.size());
		
		int answer = lis(arr);
//		System.out.println();
		System.out.println(answer);
		
	}
}
