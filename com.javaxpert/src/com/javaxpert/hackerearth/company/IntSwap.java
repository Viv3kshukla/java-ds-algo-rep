package com.javaxpert.hackerearth.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntSwap {
	
	public static List<Integer> factors(int n) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		if(n != 1) list.add(n);
		for(int i=2;i*i<=n ;i++) {
			if(n % i == 0) {
				if(i * i == n) {
					list.add(i);
				}
				else {
					list.add(i);
					list.add(n/i);
				}
			}
		}
		Collections.sort(list);
		return list;
	}
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim();
		int n = Integer.parseInt(input);
		int arr[] = new int[n];
		int max_right[] = new int[n];
		Map<Integer,List<Integer>> mp = new HashMap<Integer, List<Integer>>();
		String str[] = br.readLine().trim().split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(str[i]);
			if(mp.containsKey(arr[i])) {
				mp.get(arr[i]).add(i);
			}
			else {
				mp.put(arr[i],new ArrayList<Integer>(Arrays.asList(i)));
			}
			
		}
		
		
		List<Integer> vec[] = new ArrayList[n];
		for(int i=0;i<n;i++) {
			vec[i] = new ArrayList<Integer>(factors(arr[i]));
			for(Integer j: vec[i]) {
				List<Integer> ls = (List<Integer>) mp.get(j);
				for(Integer k : ls) {
					max_right[k] = Math.max(max_right[k], arr[i]);
				}	
			}
		}

		int q;
		input = br.readLine().trim();
		q = Integer.parseInt(input);
		
		while(q-- > 0) {
			int m,k;
			input = br.readLine();
			m = Integer.parseInt(input.trim().split(" ")[0]);
			k = Integer.parseInt(input.trim().split(" ")[1]);
			m = m - 1;
			int ans = 0;
			if(k == 0) {
				System.out.println(arr[m]);
			}
			else if(k == 1){
				System.out.println(max_right[m]);
			}
			else {
				for(int i=0;i<vec[m].size();i++) {
					ans = Math.max(ans, max_right[i]);
				}
				System.out.println(ans);
			}
			
			
		}
		
	}
	
}
