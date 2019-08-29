package com.javaxpert.test;
import java.io.*;
import java.util.*;
public class D{
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int [] a=new int [n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		if(n==1) {
			System.out.println(a[0]+1);
			return;
		}
		int [] b=Arrays.copyOf(a, n);
		Arrays.sort(b);
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
			map.put(b[i], i+1);
		b=Arrays.copyOf(a, n);
		int [] pos=new int [n+1];
		for(int i=0;i<n;i++) {
			b[i]=map.get(b[i]);
			pos[b[i]]=i;
		}
		map.clear();
		for(int i=0;i<n;i++)
			map.put(b[i],a[i]);
		int maxCntLoc=0;
		int ans=Integer.MAX_VALUE;
		
		DSU d=new DSU(n);
		int cntLoc=0;
		HashMap<Integer, Integer> szMap=new HashMap<>();
		for(int i=1;i<=n;i++) {
			int p=pos[i];
			if((p==0 || b[p-1]>b[p]) && (p==n-1 || b[p+1]>b[p])) {
				cntLoc++;
				szMap.put(1,szMap.getOrDefault(1, 0)+1);
			}else
				if(p>0 && p<n-1 && b[p-1]<b[p] && b[p+1]<b[p]) {
					int sz1=d.setSize[d.findSet(p-1)];
					int sz2=d.setSize[d.findSet(p+1)];
					d.union(p, p+1);
					d.union(p, p-1);
					szMap.put(sz1, szMap.get(sz1)-1);
					szMap.put(sz2, szMap.get(sz2)-1);
					if(szMap.get(sz1)==0)
						szMap.remove(sz1);
					if(szMap.containsKey(sz2) && szMap.get(sz2)==0)
						szMap.remove(sz2);
					szMap.put(sz1+sz2+1, szMap.getOrDefault(sz1+sz2+1, 0)+1);
					cntLoc--;
				}else
					if(p>0 && b[p-1]<b[p]) {
						int sz1=d.setSize[d.findSet(p-1)];
						szMap.put(sz1, szMap.get(sz1)-1);
						if(szMap.get(sz1)==0)
							szMap.remove(sz1);
						szMap.put(sz1+1, szMap.getOrDefault(sz1+1, 0)+1);
						d.union(p, p-1);
					}else {
						int sz1=d.setSize[d.findSet(p+1)];
						szMap.put(sz1, szMap.get(sz1)-1);
						if(szMap.get(sz1)==0)
							szMap.remove(sz1);
						szMap.put(sz1+1, szMap.getOrDefault(sz1+1, 0)+1);
						d.union(p, p+1);
					}
			if(szMap.size()==1 && cntLoc>maxCntLoc) {
				ans=map.get(i)+1;
				maxCntLoc=cntLoc;
			}
		}
		pw.println(ans);
		pw.flush();
		pw.close();
    }
	
	static class DSU {
		int n,cntSets;
		int [] rank,parent,setSize;
		
		public DSU(int n) {
			cntSets=n;
			this.n=n;
			rank=new int [n];
			parent=new int [n];
			setSize=new int [n];
			for(int i=0;i<n;i++){
				setSize[i]=1;
				parent[i]=i;
			}
		}
		
		public int findSet(int i){
			return parent[i]==i? i : (parent[i]=findSet(parent[i]));
		}
		
		public boolean union(int u,int v){
			int x=findSet(u);
			int y=findSet(v);
			if(x==y)
				return false;
			if(rank[x]<rank[y]){
				setSize[y]+=setSize[x];
				parent[x]=y;
			}else{
				setSize[x]+=setSize[y];
				if(rank[x]==rank[y])
					rank[x]++;
				parent[y]=x;
			}
			cntSets--;
			return true;
		}
		
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}
} 