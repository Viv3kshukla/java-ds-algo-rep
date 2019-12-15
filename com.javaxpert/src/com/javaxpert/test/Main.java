package com.javaxpert.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
 
public class Main {
	
	private static long best = 0;
	
	public static void main(String[] args) {
 
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int n = in.nextInt();
		int[] w = new int[n];
		List<Integer[]>[] adj = new Vector[n];
 
		for(int i = 0; i < n; i++) {
			w[i] = in.nextInt();
			adj[i] = new Vector<>();
		}
		
		for(int i = 1; i < n; i++) {
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			int cost = in.nextInt();
			adj[x].add(new Integer[] {y, cost});
			adj[y].add(new Integer[] {x, cost});
		}
	
		int root = 0;
		for(int i = 0; i < n; i++) {
			if(adj[i].size() > 1) {
				root = i;
				break;
			}
		}
		
		calculaMaximo(root, -1, adj, w);
		
		System.out.println(best);
	}
 
	public static long calculaMaximo(int v, int parent, List<Integer[]>[] adj, int[] w) {
		
		long max = w[v];
		long maior = 0;
		long segundoMaior = 0;
		
		for(Integer[] child: adj[v]) {
			
			int v1 = child[0];
			int l1 = child[1];
			
			if(v1 == parent) continue;
			
			long w1 = calculaMaximo(v1, v, adj, w);
			
			if(w1 > l1) {
				
				if(w1 - l1 > maior) {segundoMaior = maior; maior = w1 - l1;}
				else if(w1 - l1 > segundoMaior) {segundoMaior = w1 - l1;}
				
				max = Math.max(max, w[v] + w1 - l1);
			}
		}
		
		best = Math.max(best, maior + segundoMaior + w[v]);
		
		return max;
	}
}