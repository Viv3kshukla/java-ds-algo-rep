package com.javaxpert.test;

import java.util.*;

class TestClass {
    
    static class Pair<K,V> {
        private K key;
        private V value;
        public Pair(K key,V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return this.key;
        }
        
        public V getValue() {
            return this.value;
        }
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int t  = scan.nextInt();
        while(t-- > 0) {
            int n = scan.nextInt();
            Pair<Integer,Integer> p[] = new Pair[n];
            for(int i = 0;i<n;i++) {
                int x = scan.nextInt();
                p[i] = new Pair(x,i);
            }
            
            Arrays.sort(p,(a,b) -> a.getKey() > b.getKey() ? 1: a.getKey() == b.getKey() ? 0:-1);
            System.out.println("Printing out the array ");
            for(int i = 0; i<n;i++) {
                System.out.println(p[i].getKey());
            }
            
            Arrays.sort(p,(a,b) -> a.getValue() > b.getValue() ? 1: a.getValue() == b.getValue() ? 0:-1);
            for(int i = 0; i<n;i++) {
                System.out.println(p[i].getValue());
            }
            
        }
    }
}
