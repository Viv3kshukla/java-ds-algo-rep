package com.javaxpert.dsalgoimpl.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class CoinSelectionOnTrees {
	
	static ArrayList<Integer> [] vec;
	static int dp1[];
	static int dp2[];
	static int arr[];
	
	public static void dfs(int u, int p) {
		int sum1=0,sum2=0;
		
		// sum1 is for not including current u
		// sum2 is for including current u
		
		for(int v: vec[u]) {
			if(v == p)  {
				continue;
			}
			dfs(v,u);
			sum1 += Math.max(dp1[v], dp2[v]);
			sum2 += dp1[v];
		}
		
		dp1[u] = sum1;
		dp2[u] = sum2 + arr[u];
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		Integer n,x,y;
		n = scan.nextInt();
		
		vec = new ArrayList[n+1];
		dp1 = new int[n+1];
		dp2 = new int[n+1];
		arr = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			vec[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<n;i++) {
			x = scan.nextInt();
			y = scan.nextInt();
			
			vec[x].add(y);
			vec[y].add(x);
			
		}
		
		for(int i=1;i<=n;i++) {
			arr[i] = scan.nextInt();
		}
		
		dfs(1,0);
		
		int answer = Math.max(dp1[1], dp2[1]);
		System.out.println(answer);
		
		
		scan.close();
		
	}
}
