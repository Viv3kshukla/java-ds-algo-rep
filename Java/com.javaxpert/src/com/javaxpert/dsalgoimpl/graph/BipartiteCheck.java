package com.javaxpert.dsalgoimpl.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Given a graph , check if it's bipartite or not 
 * 
 * Remember : You can't create arrays of generic type. Use this instead
 * A bipartite graph, also called a bigraph,
 *  is a set of graph vertices decomposed into two disjoint sets such that
 *  no two graph vertices within the same set are adjacent.
 * 
 */
public class BipartiteCheck {
	
	
	public static boolean bipartiteCheck(Integer [] color, ArrayList<Integer> [] vec,Integer s) {
		boolean isBpt = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		color[s] = 0;
		queue.add(s);
		
		while(!queue.isEmpty() && isBpt) {
			Integer u = queue.remove();
			for(Integer v: vec[u]) {
				if(color[v] == 2) {
					color[v] = 1-color[u];
					queue.add(v);
				}
				else if(color[v]==color[u]) {
					isBpt = false;
					break;
				}
			}
			
		}
		
		return isBpt;
	}
	

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		Integer n,e,x,y;
		n = scan.nextInt();
		e = scan.nextInt();
		@SuppressWarnings("unchecked")
		ArrayList<Integer> [] vec = new ArrayList[n+1];
		
		for(int i=0;i<vec.length;i++) {
			vec[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<=e;i++) {
			x = scan.nextInt();
			y = scan.nextInt();
			
			vec[x].add(y);
			vec[y].add(x);
			
		}
		
		Integer [] color = new Integer[n+1];
		Arrays.fill(color, 2);
		
		boolean answer = bipartiteCheck(color, vec, 1);
		
		if(answer) {
			System.out.println("Bipartite");
		}
		else {
			System.out.println("Not Bipartite");
		}
		
		scan.close();
	}
	
	
	
}
