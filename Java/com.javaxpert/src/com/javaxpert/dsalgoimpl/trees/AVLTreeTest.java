package com.javaxpert.dsalgoimpl.trees;

import java.util.Scanner;

/*
 * 
 * AVL tree is self balancing binary tree. Difference of height of left or right subtree
 * cannot be greater than one.
 * 
 * There are four different use cases to insert into AVL tree
 * left left - needs ones right rotation
 * left right - needs one left and one right rotation
 * right left - needs one right and one left rotation
 * right right - needs one left rotation
 * 
 */


class Node {
	int data;
	int height;
	Node left,right;
	
	Node(int data) {
		this.data = data;
		this.height = 1;
		this.left = null;
		this.right = null;
	}
	
}


class AVLTree {
	Node root;
	
	AVLTree() {
		root = null;
	}
	
	private int height(Node root) {
		if(root == null) {
			return 0;
		}
		else {
			return root.height;
		}
	}
	
	private int setHeight(Node root) {
		if(root == null) {
			return 0;
		}
		else {
			return 1 + Math.max(height(root.left), height(root.right));
		}
	}
	
	private Node rightRotate(Node root) {
		Node newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		root.height = setHeight(root);
		newRoot.height = setHeight(newRoot);
		return newRoot;
	}
	
	private Node leftRotate(Node root) {
		Node newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		root.height = setHeight(root);
		newRoot.height = setHeight(newRoot);
		return newRoot;
	}
	
	private int balance(Node rootLeft,Node rootRight) {
		return height(rootLeft) - height(rootRight);
	}
	
	public void inorder() {
		inorder(root);
		System.out.println();
	}
	
	private void inorder(Node node) {
		if(node != null) {
			inorder(node.left);
			System.out.println(node.data + " " + node.height);
			inorder(node.right);
		}
	}
	
	public void insert(int value) {
		insert(root,value);
	}
	
	private void insert(Node node,int value) {
		if(root == null) {
			root = new Node(value);
			return;
		}
		
		if(node.data < value) {
			if(node.right != null) insert(node.right,value);
			else node.right = new Node(value);
		}
		else {
			if(node.left != null) insert(node.left,value);
			else node.left = new Node(value);
		}
		
		int balance = balance(node.left,node.right);
		if(balance > 1) {
			if(height(node.left.left) >= height(node.left.right)) {
				node = rightRotate(node);
			}
			else {
				node.left = leftRotate(node.left);
				node = rightRotate(node);
			}
		}
		else if(balance < -1) {
			if(height(node.right.right) >= height(node.right.left)) {
				node = leftRotate(node);
			}
			else {
				node.right = rightRotate(node.right);
				node = leftRotate(node);
			}
		}
		else {
			node.height = setHeight(node);
		}
	}
}

public class AVLTreeTest {
	public static void main(String args[]) {
		AVLTree tree = new AVLTree();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0;i<n;i++) {
			int x = scan.nextInt();
			tree.insert(x);
		}
		
		tree.inorder();
	}
}

