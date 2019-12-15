package com.javaxpert.dsalgoimpl.trees;

import java.util.Scanner;

class BSTNode {
	int data;
	BSTNode left,right;
	
	public BSTNode(int data) {
		this.data  = data;
		this.left = null;
		this.right = null;
	}
	
}


class BST {
	BSTNode root;
	
	BST() {
		root = null;
	}
	
	public void insert(BSTNode node,int value) {
		if(root == null) {
			root = new BSTNode(value);
			return;
		}
		
		if(node.data < value) {
			if(node.right != null)  {
				insert(node.right,value);
			}
			else {
				node.right = new BSTNode(value);
			}
		}
		else {
			if(node.left != null) {
				insert(node.left,value);
			}
			else {
				node.left = new BSTNode(value);
			}
		}
		
	}
	
	
	public void inorder(BSTNode node) {
		if(node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}
	
	
	public int height(BSTNode node) {
		
		if(node == null) {
			return 0;
		}
		
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
		
	}
	
	public int height() {
		return height(this.root);
	}
	
	public void insert(int value) {
		insert(this.root,value);
	}
	
	public void inorder() {
		inorder(this.root);
		System.out.println();
	}
	
	
}


public class BSTTest {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		BST tree = new BST();
		int n = scan.nextInt();
		for(int i = 0;i<n;i++) {
			int x = scan.nextInt();
			tree.insert(x);
		}
		
		tree.inorder();
		System.out.println(tree.height());
	}
}

