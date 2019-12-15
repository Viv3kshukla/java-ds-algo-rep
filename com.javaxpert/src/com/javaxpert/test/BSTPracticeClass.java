package com.javaxpert.test;


class BSTNode {
	int data;
	BSTNode left,right;
	BSTNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}


class BST {
	
	BSTNode root;
	
	BST() {
		this.root = null;
	}
	
	public void insert(BSTNode node, int value) {
		if(root == null) {
			root = new BSTNode(value);
			return;
		}
		
		if(node.data < value) {
			if(node.right != null) {
				insert(node.right,value);
			}
			else {
				node.right = new BSTNode(value);
				return;
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
	
	public void inorder() {
		inorder(this.root);
	}
	
	public void insert(int value) {
		insert(this.root,value);
	}
	
	public int height(BSTNode node) {
		if(node == null) {
			return 0;
		}
		int left = height(node.left);
		int right = height(node.right);
		return Math.max(left, right) + 1;
	}
	
	public int height() {
		return this.height(this.root);
	}
	
}



public class BSTPracticeClass {
	
	public static void main(String args[]) {
		
		BST tree = new BST();
		tree.insert(3);
		tree.insert(5);
		tree.insert(2);
		tree.insert(8);
		tree.inorder();
		System.out.println("height of tree is " + tree.height());
		
		
	}
	
	
}
