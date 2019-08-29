package com.javaxpert.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
//620E
public class NewYearTree {	
		
	static class SegmentTree {
 
		long[] tree, lazy;
		int N;
 
		private int left(int p) {
			return p << 1;
		}
 
		private int right(int p) {
			return (p << 1) + 1;
		}
 
		public SegmentTree(int n) {
			N = n;
			tree = new long[n << 2];
			lazy = new long[n << 2];
			build(1, 0, N - 1);
		}
 
		void build(int parent, int L, int R) {
			if (L == R) {
				tree[parent] = cmsk[L];
			} else {
				build(left(parent), L, (L + R) >> 1);
				build(right(parent), ((L + R) >> 1) + 1, R);
				tree[parent] = tree[left(parent)] | tree[right(parent)];
			}
		}
 
		public void update_range(int i, int j, long v) {
			update_range(1, 0, N - 1, i, j, v);
		}
 
		private void update_range(int p, int L, int R, int i, int j, long v) {
 
			if (lazy[p] != 0) {
				tree[p] = lazy[p];
				if (L != R) {
					lazy[left(p)] = lazy[p];
					lazy[right(p)] = lazy[p];
				}
				lazy[p] = 0;
			}
 
			if (i > R || j < L)
				return;
 
			if (L >= i && R <= j) {
				tree[p] = v;
				if (R != L) {
					lazy[left(p)] = v;
					lazy[right(p)] = v;
				}
			} else {
				int mid = (L + R) / 2;
				update_range(left(p), L, mid, i, j, v);
				update_range(right(p), mid + 1, R, i, j, v);
				tree[p] = tree[left(p)] | tree[right(p)];
			}
		}
 
		public int query(int i, int j) {
			return Long.bitCount(query(1, 0, N - 1, i, j));
		}
 
		private long query(int parent, int L, int R, int i, int j) {
			if (i > R || j < L)
				return 0;
			if (lazy[parent] != 0) {
				tree[parent] = lazy[parent];
				if (L != R) {
					lazy[left(parent)] = lazy[parent];
					lazy[right(parent)] = lazy[parent];
				}
				lazy[parent] = 0;
			}
			if (L >= i && R <= j)
				return tree[parent];
			int mid = (L + R) >> 1, left = left(parent), right = right(parent);
			long ll = query(left, L, mid, i, j);
			long rr = query(right, mid + 1, R, i, j);
			return ll | rr;
		}
	}
 
	static ArrayList<Integer> graph[];
	static int[] color, tin, tout, tree;
	static int globalTime;
	static long[] cmsk;
 
	static void dfs(int u, int p) {
		tree[globalTime] = u;
		tin[u] = globalTime++;
		for (int v : graph[u]) {
			if (p != v)
				dfs(v, u);
		}
		tout[u] = globalTime - 1;
	}
 
	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int V = sc.nextInt();
		int Q = sc.nextInt();
		color = new int[V];
		for (int i = 0; i < V; i++)
			color[i] = sc.nextInt();
		graph = new ArrayList[V];
		for (int i = 0; i < V; i++)
			graph[i] = new ArrayList<>();
 
		for (int i = 0; i < V - 1; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			graph[u].add(v);
			graph[v].add(u);
		}
		tin = new int[V];
		tout = new int[V];
		tree = new int[V];
		dfs(0, -1);
		cmsk = new long[V];	
		for (int i = 0; i < V; i++)
			cmsk[i] = 1L << color[tree[i]];
		SegmentTree st = new SegmentTree(V);
		while (Q-- > 0) {
			int t = sc.nextInt();
			if (t == 1) {
				int node = sc.nextInt() - 1;
				int color = sc.nextInt();
				st.update_range(tin[node], tout[node], 1L << color);
			} else {
				int node = sc.nextInt() - 1;
				pw.println(st.query(tin[node], tout[node]));
			}
		}
		pw.close();
	}
 
	static class MyScanner {
		StringTokenizer st;
		BufferedReader br;
 
		public MyScanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}
 
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
 
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
 
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public String nextLine() throws IOException {
			return br.readLine();
		}
 
		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
