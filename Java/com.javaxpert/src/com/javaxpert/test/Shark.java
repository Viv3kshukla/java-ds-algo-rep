package com.javaxpert.test;
import java.io.*;
import java.util.*;
 
public class Shark {
 
    public static class Node {
        boolean loc = false;
        int count = 1;
        Node left = null;
        Node right = null;
    }
 
    public static void main (String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] sp = in.readLine().split(" ");
        Node last = null;
 
        int[] arr = new int[n];
        Map<Integer, Node> nodeMap = new HashMap<>();
 
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sp[i]);
            Node node = new Node();
            if (i > 0) {
                node.left = last;
                last.right = node;
            }
            last = node;
            nodeMap.put(arr[i], node);
        }
 
        Arrays.sort(arr);
 
        int best = 0;
        int bk = 0;
        Map<Integer, Integer> locCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Node node = nodeMap.get(arr[i]);
            node.loc = true;
            if (node.left != null && node.left.loc) {
                locCount.put(node.left.count, locCount.get(node.left.count) -1);
                if (locCount.get(node.left.count) == 0) {
                    locCount.remove(node.left.count);
                }
                node.count += node.left.count;
                if (node.left.left != null) node.left.left.right = node;
                node.left = node.left.left;
 
            }
            if (node.right != null && node.right.loc) {
                locCount.put(node.right.count, locCount.get(node.right.count) -1);
                if (locCount.get(node.right.count) == 0) {
                    locCount.remove(node.right.count);
                }
                node.count += node.right.count;
                if (node.right.right != null) node.right.right.left = node;
                node.right = node.right.right;
            }
 
            int cnt = locCount.containsKey(node.count) ? locCount.get(node.count) : 0;
            locCount.put(node.count, cnt + 1);
 
 
            if (locCount.size() == 1) {
                int val = locCount.values().iterator().next();
                if (val > best) {
                    best = val;
                    bk = arr[i];
                }
            }
        }
 
        System.out.println(bk + 1);
 
 
    }
}