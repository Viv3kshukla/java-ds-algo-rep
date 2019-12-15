package com.javaxpert.test;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class A {
 
	static ArrayList<Integer>[] adj;
 
	public static void main(String[] args) throws Exception {
		Scanner bf = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int N = bf.nextInt(), m = bf.nextInt();
		int n = 1;
		while (n < N)
			n <<= 1;
		long[] col = new long[N];
		for (int i = 0; i < N; i++) {
			col[i] = 1l << (bf.nextInt() - 1);
		}
		adj = new ArrayList[N];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			int x = bf.nextInt() - 1, y = bf.nextInt() - 1;
			adj[x].add(y);
			adj[y].add(x);
		}
		eulerWalk(0, N);
		long[] in = new long[n + 1];
		for (int i = 0; i < col.length; i++) {
			in[E[i]] = col[i];
		}
		SegmentTree sg = new SegmentTree(in);
		for (int i = 0; i < m; i++) {
			int t = bf.nextInt();
			if (t == 1) {
				int v = bf.nextInt() - 1, c = bf.nextInt() - 1;
				sg.update_range(E[v], E[v] + M[v], c);
			} else {
				int v = bf.nextInt() - 1;
				out.println(Long.bitCount(sg.query(E[v], E[v] + M[v])));
			}
		}
		out.flush();
		out.close();
	}
 
	static int[] E, M;
	static int t;
 
	static int dfs(int u, int p) {
 
		E[u] = t++;
		for (int v : adj[u]) {
			if (v == p)
				continue;
			M[u] += dfs(v, u) + 1;
		}
		return M[u];
	}
 
	static void eulerWalk(int root, int N) {
		t = 1;
		E = new int[N];
		M = new int[N];
		dfs(root, -1);
	}
 
	static class SegmentTree { // 1-based DS, OOP
 
		int N;
		long[] array, sTree, lazy;
 
		SegmentTree(long[] in) {
			array = in;
			N = in.length - 1;
			sTree = new long[N << 1];
			lazy = new long[N << 1];
			build(1, 1, N);
		}
 
		void build(int node, int b, int e) // O(n)
		{
			if (b == e)
				sTree[node] = array[b];
			else {
				int mid = b + e >> 1;
			build(node << 1, b, mid);
			build(node << 1 | 1, mid + 1, e);
			sTree[node] = sTree[node << 1] | sTree[node << 1 | 1];
			}
		}
 
		void update_range(int i, int j, int val) // O(log n)
		{
			update_range(1, 1, N, i, j, val);
		}
 
		void update_range(int node, int b, int e, int i, int j, int val) {
			if (i > e || j < b)
				return;
			if (b >= i && e <= j) {
				sTree[node] = 1L << val;
				lazy[node] = 1L << val;
			} else {
				int mid = b + e >> 1;
				propagate(node, b, mid, e);
				update_range(node << 1, b, mid, i, j, val);
				update_range(node << 1 | 1, mid + 1, e, i, j, val);
				sTree[node] = sTree[node << 1] | sTree[node << 1 | 1];
			}
		}
 
		void propagate(int node, int b, int mid, int e) {
			if(lazy[node] > 0){
				lazy[node << 1] = lazy[node];
				lazy[node << 1 | 1] = lazy[node];
				sTree[node << 1] = lazy[node];
				sTree[node << 1 | 1] = lazy[node];
				lazy[node] = 0;
			}
		}
 
		long query(int i, int j) {
			return query(1, 1, N, i, j);
		}
 
		long query(int node, int b, int e, int i, int j) // O(log n)
		{
			if (i > e || j < b)
				return 0;
			if (b >= i && e <= j)
				return sTree[node];
			int mid = b + e >> 1;
			propagate(node, b, mid, e);
			long q1 = query(node << 1, b, mid, i, j);
			long q2 = query(node << 1 | 1, mid + 1, e, i, j);
			return q1 | q2;
		}
	}
 
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;
 
		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}
 
		public Scanner(FileReader fileReader) {
			br = new BufferedReader(fileReader);
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