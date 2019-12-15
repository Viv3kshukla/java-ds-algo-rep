//package com.javaxpert.apas;
//
//public class Solution105 {
//	/*
//	 * Given preorder and inorder traversal of a tree, construct the binary tree.
//	 * Note : You may assume that duplicates do not exist in the tree
//	 * 
//	 * Example : preorder = [3,9,20,15,7]
//	 * 			 inorder = [9,3,15,20,7]
//	 * Answer : return a binary tree
//	 * 
//	 */
//	
//	
//	public static int curr = 0;
//	
//	static {
//		curr = 0;
//	}
//	
//	class Node {
//		int data;
//		Node left,right ;
//		Node (int data) {
//			this.data = data;
//			this.left = null;
//			this.right = null;
//		}
//	}
//	
//	private int getIndex(int [] in,int start,int end,int val) {
//		System.out.println("the value of val is " + val);
//		for(int i=start; i<=end;i++) {
//			if(in[i] == val) {
//				sysout
//				return i;
//			}
//		}
//		return 0;
//	}
//	
//	
//	private Node construct(int [] in, int [] pre, int start,int end) {
//		if(start > end) return null;
//		System.out.println(curr + " val is ");
//		int index = getIndex(in,start,end,pre[curr]);
//		System.out.println(index + "  " + start + "   " + end);
//		Node root = new Node(pre[curr++]);
//		root.right = construct(in,pre,index+1,end);
//		root.left = construct(in,pre,start,index);
//
//		return root;
//	}
//	
//	
//	public Node buildTree() {
//		int [] inorder = {3,9,20,15,7};
//		int [] preorder = {9,3,15,20,7};
//		
//		Node root = construct(inorder,preorder,0,inorder.length-1);
//		
//		return root;
//	}
//	
//	public void inOrder(Node root) {
//		if(root != null) {
//			inOrder(root.left);
//			System.out.print(root.data + " ");
//			inOrder(root.right);
//		}
//	}
//	
//	
//	
//	public static void main(String args[]) {
//		Solution105 answer = new Solution105();
//		System.out.println("the value of curr is " + curr);
//		Node root = answer.buildTree();
//		
//		answer.inOrder(root);
//		
//	}
//	
//	
//	
//}
