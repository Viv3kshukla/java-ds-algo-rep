package com.javaxpert.test;
import java.io.*;
import java.util.*;
 
public class D219{
 
   public static ArrayList<ArrayList<Edge>> adj;
   public static int[] dp;
   
   public static void main(String[] args)throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      
      int n = Integer.parseInt(f.readLine());
      
      adj = new ArrayList<ArrayList<Edge>>(n+1);
      
      for(int k = 0; k <= n; k++){
         adj.add(new ArrayList<Edge>());
      }
      
      for(int k = 0; k < n-1; k++){
         
         StringTokenizer st = new StringTokenizer(f.readLine());
         
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         
         adj.get(a).add(new Edge(b,true));
         adj.get(b).add(new Edge(a,false));
      }
      
      dp = new int[n+1];                  //num arrows pointed the CORRECT way relative to that vertex
      
      dp[1] = dfs1(1,-1);
      
      dfs2(1,-1);
      
      
      
      
      //for debugging
      /*
      for(int k = 1; k <= n; k++){
         out.print(dp[k] + " ");
      }*/
      
      ArrayList<Integer> alist = new ArrayList<Integer>();
      
      int max = 0;
      
      for(int k = 1; k <= n; k++){
         if(dp[k] == max){
            alist.add(k);
         } else if(dp[k] > max){    
            max = dp[k];
            alist = new ArrayList<Integer>();
            alist.add(k);
         }
      }
      
      out.println(n-1-max);
      for(int i : alist){
         out.print(i + " ");
      }
      
      
      
      out.close();
   }
   
   //"re-root"
   public static void dfs2(int v, int p){
      
      for(Edge e : adj.get(v)){
         if(e.v == p) continue;
         dp[e.v] = dp[v] + (e.dir ? -1 : 1);
         dfs2(e.v,v);
      }
   }
   
   
   //set dp[1]
   public static int dfs1(int v, int p){
      int count = 0;
      
      for(Edge e : adj.get(v)){
         if(e.v == p) continue;
         if(e.dir) count++;
         count+=dfs1(e.v,v);
      }
      
      return count;
   }
      
      
 
   
   
   public static class Edge{
      int v;
      boolean dir;                           //true means edge is going toward the vertex
      public Edge(int a, boolean b){
         v = a;
         dir = b;
      }
   }
      
      
   
}