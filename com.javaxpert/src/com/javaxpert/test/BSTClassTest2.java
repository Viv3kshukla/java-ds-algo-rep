package com.javaxpert.test;

class Node {
	int data;
	Node left,right;
	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class BST2{
	private Node root;
	
	BST2() {
		this.root = null;
	}
	
	public void inorder(Node node ) {
		if(node != null) {
			inorder(node.left);
			System.out.print(node.data + " -> ");
			inorder(node.right);
		}
	}
	
	
	public void insert(Node node,int data) {
		if(this.root == null) {
			this.root = new Node(data);
			return;
		}
		
		if(node.data < data) {
			if(node.right == null) {
				node.right = new Node(data);
				return;
			}
			insert(node.right,data);
		}
		else {
			
			if(node.left == null) {
				node.left = new Node(data);
				return;
			}
			insert(node.left,data);
			
		}
		
	}
	
	public void inorder() {
		inorder(this.root);
		System.out.println();
	}
	
	public void insert(int data) {
		insert(this.root, data);
	}
	
	public Node findNode(Node node, int data) {
		
		if(node == null) return null;
		if(node.data == data) return node;
		else if(node.data < data) return findNode(node.right,data);
		else return findNode(node.left,data);
		
	}
	
	public Node findMin(Node node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public Node findNode(int data) {
		return findNode(this.root, data);
	}
	
	public Node getSuccessor(int data) {		// time complexity O(h)
		Node node = findNode(data);
		if(node.right != null) {
			return findMin(node.right);
		}
		else {	// deepest element for which current element would be in its left subtree
			Node successor = null;
			Node ancestor = this.root;
			while(ancestor != node) {
				if(node.data < ancestor.data) {
					successor = ancestor.right;
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

public class BSTClassTest2 {
	public static void main(String args[]) {
		
		BST2 bst = new BST2();
		bst.insert(3);
		bst.insert(54);
		bst.insert(1);
		bst.inorder();
		
		
		
		
		
	}
}
