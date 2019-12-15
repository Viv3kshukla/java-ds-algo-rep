package com.javaxpert.test;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Task {
	
	class Pair {
		int id, bad;
		
		Pair(int x, int y) {
			id = x;
			bad = y;
		}
	}
	
	class Node {
		ArrayList<Pair> nei = new ArrayList<>();
	}
	
	int n;
	int[] up, down;
	Node[] node;
	
	void dfs_down(int u, int p) {
		for (Pair v : node[u].nei) {
			if (v.id == p) continue;
			dfs_down(v.id, u);
			down[u] += down[v.id] + v.bad;
		}
	}
	
	void dfs_up(int u, int p) {
		for (Pair v : node[u].nei) {
			if (v.id == p) continue;
			up[v.id] = up[u] + down[u] - down[v.id] + (v.bad == 0 ? 1 : -1);
			dfs_up(v.id, u);
		}
	}
	
	void solve(Scanner in, PrintWriter out) {
		int n = in.nextInt();
		node = new Node[n];
		up = new int[n];
		down = new int[n];
		for (int i = 0; i < n; ++i)
			node[i] = new Node();
		for (int i = 0; i < n - 1; ++i) {
			int u = in.nextInt(), v = in.nextInt();
			u --; v --;
			node[u].nei.add(new Pair(v, 0));
			node[v].nei.add(new Pair(u, 1));
		}
		dfs_down(0, -1);
		dfs_up(0, -1);
		int ans = 1000 * 1000;
		ArrayList<Integer> caps = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			if (up[i] + down[i] == ans)
				caps.add(i + 1);
			else if (up[i] + down[i] < ans) {
				caps.clear();
				caps.add(i + 1);
				ans = up[i] + down[i];
			}
		}
		out.println(ans);
		for (int city : caps)
			out.printf("%d ", city);
		out.println();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		new Task().solve(in, out);
		out.close();
	}
 
}