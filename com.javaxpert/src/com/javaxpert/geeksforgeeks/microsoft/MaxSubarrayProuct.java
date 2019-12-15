package com.javaxpert.geeksforgeeks.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MaxSubarrayProuct {
	
	
	// final to make array read only
	
	public static int maxProduct(final List<Integer> arr) {
		if(arr.size() == 0) {
			return 0;
		}
		int posp[] = new int[arr.size()];
		int negp[] = new int[arr.size()];
		int maxp[] = new int[arr.size()];
		
		posp[0] = maxp[0] = negp[0] = arr.get(0);
		for(int i=1;i<arr.size();i++) {
			int a = posp[i-1] * arr.get(i);
			int b = negp[i-1] * arr.get(i);
			posp[i] = Math.max(Math.max(a, b), arr.get(i));
			negp[i] = Math.min(Math.min(a, b), arr.get(i));
			maxp[i] = Math.max(posp[i], maxp[i-1]);
		}
		
		return maxp[arr.size() - 1];
    }
	
	public static int maxProductWithoutExtraSpace(final List<Integer> arr) {
		int n = arr.size();
		int answer = 0,maxn = 1,minm = 1;
		for(int i=0;i<n;i++) {
			if(arr.get(i) >= 0) {
				maxn = maxn == 0 ? arr.get(i):arr.get(i) * maxn;
				minm = minm == 0 ? arr.get(i): arr.get(i) * minm;
			}
			else {
				int t = maxn;
				maxn = minm * arr.get(i);
				minm = t==0 ? arr.get(i) : t*arr.get(i);
			}
			answer = Math.max(maxn, answer);
		}
		return answer;
	}
	
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().trim().split(",");
		List<Integer> arr = new ArrayList<Integer>();
		for(String s : input) {
			arr.add(Integer.parseInt(s.trim()));
		}
//		int[] a = A.stream().mapToInt(i -> i.intValue()).toArray();
//		Arrays.stream(max).max().getAsInt();	arrays into stream
		
		
		System.out.println(maxProduct(arr));
		
		
		
	}
}
