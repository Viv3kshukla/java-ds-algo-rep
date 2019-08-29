package com.javaxpert.test;
import java.io.*;
import java.util.*;
 
public class DD implements Runnable{
	public static void main (String[] args) {new Thread(null, new DD(), "_cf", 1 << 28).start();}
 
	public void run() {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("Go!");
 
		int n = fs.nextInt();
		int[] a = fs.nextIntArray(n);
		int[] b = a.clone();
		sort(b);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++)
			map.put(a[i], i);
		
		DSU ds = new DSU(n);
		
		int loc = -1, res = -1;
		HashMap<Integer, Integer> sizes = new HashMap<>();
		for(int i = 0; i < n; i++) {
			int k = b[i] + 1;
			int pos = map.get(b[i]);
			if(pos + 1 < n && a[pos + 1] < b[i]) {
				remove(sizes, ds.size[ds.find(pos + 1)]);
				ds.union(pos, pos + 1);
			}
			if(pos - 1 >= 0 && a[pos - 1] < b[i]) {
				remove(sizes, ds.size[ds.find(pos - 1)]);
				ds.union(pos, pos - 1);
			}
			add(sizes, ds.size[ds.find(pos)]);
			if(sizes.size() == 1) {
				int num = sizes.get(ds.size[ds.find(pos)]);
				if(num > loc) {
					loc = num;
					res = k;
				}
			}
		}
		
		out.println(res);
		out.close();
	}
	
	void remove(HashMap<Integer, Integer> map, int x) {
		int fr = map.get(x) - 1;
		if(fr == 0) map.remove(x);
		else map.put(x, fr);
	}
 
	void add(HashMap<Integer, Integer> map, int x) {
		if(!map.containsKey(x)) map.put(x, 0);
		map.put(x, map.get(x) + 1);
	}
	
	
	class DSU {
		int n;
		int[] par, size, rank;
		DSU (int a) {
			n = a;
			par = new int[n];
			size = new int[n];
			rank = new int[n];
			for(int i = 0; i < n; i++) par[i] = i;
			Arrays.fill(size, 1);
		}
		int find(int u) {
			if(par[u] == u) return u;
			return par[u] = find(par[u]);
		}
		boolean union(int u, int v) {
			int pu = find(u);
			int pv = find(v);
			if(pu == pv) return false;
			if(rank[pu] >= rank[pv]) {
				if(rank[pu] == rank[pv]) rank[pu]++;
				size[pu] += size[pv];
				par[pv] = pu;
			}
			else {
				size[pv] += size[pu];
				par[pu] = pv;
			}
			return true;
		}
	}
 
	void sort (int[] a) {
		int n = a.length;
		for(int i = 0; i < 50; i++) {
			Random r = new Random();
			int x = r.nextInt(n), y = r.nextInt(n);
			int temp = a[x];
			a[x] = a[y];
			a[y] = temp;
		}
		Arrays.sort(a);
	}
 
	class FastScanner {
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;
 
		public FastScanner() {
			in = new BufferedInputStream(System.in, BS);
		}
 
		public FastScanner(String s) throws FileNotFoundException {
			in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
		}
 
		public char nextChar(){
			while(bId==size) {
				try {
					size = in.read(buf);
				}catch(Exception e) {
					return NC;
				}                
				if(size==-1)return NC;
				bId=0;
			}
			return (char)buf[bId++];
		}
 
		public int nextInt() {
			return (int)nextLong();
		}
 
		public long nextLong() {
			num=1;
			boolean neg = false;
			if(c==NC)c=nextChar();
			for(;(c<'0' || c>'9'); c = nextChar()) {
				if(c=='-')neg=true;
			}
			long res = 0;
			for(; c>='0' && c <='9'; c=nextChar()) {
				res = (res<<3)+(res<<1)+c-'0';
				num*=10;
			}
			return neg?-res:res;
		}
 
		public double nextDouble() {
			double cur = nextLong();
			return c!='.' ? cur:cur+nextLong()/num;
		}
 
		public String next() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c>32) {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}
 
		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c!='\n') {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}
 
		public boolean hasNext() {
			if(c>32)return true;
			while(true) {
				c=nextChar();
				if(c==NC)return false;
				else if(c>32)return true;
			}
		}
		
		public int[] nextIntArray(int n) {
			int[] res = new int[n];
			for(int i = 0; i < n; i++) res[i] = nextInt();
			return res;
		}
		
	}
 
}