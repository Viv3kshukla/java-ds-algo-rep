package com.javaxpert.interviewbit.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given a BST node,
 *  return the node which has value just greater than the given node.
 */


class BSTNode {
	int data;
	BSTNode left,right;
	
	public BSTNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class BST {
	BSTNode root;
	
	BST() {
		root = null;
	}
	
	public void insert(BSTNode node, int x) {
	
		if(node.data < x) {
			if(node.right != null) {
				insert(node.right, x);
			}
			else {
				node.right = new BSTNode(x);
				return;
			}
		}
		else {
			if(node.left != null) {
				insert(node.left, x);
			}
			else {
				node.left = new BSTNode(x);
				return;
			}
		}
		
		
	}
	
	public void insert(int data) {
		if(root == null) {
			root = new BSTNode(data);
		}
		else {
			insert(root,data);
		}
	}
	
	public void inorder(BSTNode node) {
		if(node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}
	
	public void inorder() {
		inorder(this.root);
		System.out.println();
	}
	
	public BSTNode findNode(BSTNode node,int n) {
		if(node == null) return null;
		if(node.data == n) return node;
		else if(node.data < n) return findNode(node.right,n);
		else return findNode(node.left,n);
	}
	
	
	public BSTNode findNode(int n) {
		BSTNode node = null;
		node  = findNode(this.root, n);
		return node;
	}
	
	public BSTNode findMin(BSTNode node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public BSTNode getSuccessor(int n) {
		BSTNode node = findNode(n);
		if(node == null) {
			return null;
		}
		if(node.right != null) {
			return findMin(node.right);
		}
		else {
			BSTNode successor = null;
			BSTNode ancestor = this.root;
			while(ancestor != node) {
				if(node.data < ancestor.data) {
					successor = ancestor;
					ancestor = ancestor.left;
				}
				else {
					ancestor = ancestor.right;
				}
			}
			return successor;
		}
		
	}
	
	
}

public class NextGreaterBST {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] array = br.readLine().trim().split(" ");
		Integer [] arr = new Integer[array.length];
		for(int i=0;i<array.length;i++) {
			arr[i] = Integer.parseInt(array[i]);
		}
		
		BST tree = new BST();
		
		for(int i = 0;i<arr.length ;i++) {
			tree.insert(arr[i]);
		}
		
		tree.inorder();
			
	}
	
	
}
