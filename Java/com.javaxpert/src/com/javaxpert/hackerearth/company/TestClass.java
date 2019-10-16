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

class TestClass {
	
	
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
		List<Integer> ans = new ArrayList<Integer>();
		
		
		for(Integer k : list) {
			ans.add(k);
			ans.add(-1*k);
		}
		Collections.sort(ans);
		
		return ans;
	}
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim();
		int n = Integer.parseInt(input);
		int arr[] = new int[n];
		int max_right[] = new int[n];
		Arrays.fill(max_right, Integer.MIN_VALUE);
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
//			System.out.println("num is arr " + arr[i]);
			vec[i] = new ArrayList<Integer>(factors(arr[i]));
			
//			for(Integer j: vec[i]) {
//				System.out.println(j + " ");
//			}
//			System.out.println();
			for(Integer j: vec[i]) {
			    if(mp.containsKey(j)) {
    			    List<Integer> ls = (List<Integer>) mp.get(j);
				    for(Integer k : ls) {
				    	max_right[k] = Math.max(max_right[k], arr[i]);
				    }					    
			    }
			}
		}

		int q;
		input = br.readLine().trim();
		q = Integer.parseInt(input);
		
		
//		for(int i=0;i<max_right.length;i++) {
//			System.out.print(max_right[i] + " ");
//		}
//		
		
		
		while(q-- > 0) {
			int m,k;
			input = br.readLine();
			m = Integer.parseInt(input.trim().split(" ")[0]);
			k = Integer.parseInt(input.trim().split(" ")[1]);
			m = m - 1;
			int ans = arr[m];
//			System.out.println("the value of ans is " + ans);
			if(k == 0) {
				System.out.println(arr[m]);
			}
			else if(k == 1){
				System.out.println(max_right[m]);
			}
			else {
				for(Integer j: vec[m]) {
				    if(mp.containsKey(j)) {
	    			    List<Integer> ls = (List<Integer>) mp.get(j);
					    for(Integer c : ls) {
					    	ans = Math.max(max_right[c], ans);
					    }					    
				    }
				}
				System.out.println(ans);
			}
			
			
		}
		
	}
	
}
