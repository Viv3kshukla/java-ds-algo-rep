package com.javaxpert.geeksforgeeks.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DistributeCandy {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().trim().split(",");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(String s : str) {
			list.add(Integer.parseInt(s.trim()));
		}
		
		ArrayList<Integer> dp = new ArrayList<Integer>();
		dp.add(1);
		for(int i = 1;i<list.size();i++) {
			if(list.get(i) > list.get(i-1)) {
				dp.add(dp.get(i-1) + 1);
			}
			else {
				dp.add(1);
			}
		}
		for(int i = list.size()-2;i>=0;i--) {
			if(list.get(i) > list.get(i+1) && dp.get(i) <= dp.get(i+1)) {
				dp.set(i, dp.get(i+1) +1);
			}
		}
//		
//		for(int i= 0;i<list.size();i++) {
//			System.out.print(dp.get(i) + " ");
//		}
//		
		int ans = dp.stream().mapToInt(i->i).sum();
		System.out.println(ans);
		
		
	}
}
