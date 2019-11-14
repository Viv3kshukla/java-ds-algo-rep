package com.javaxpert.apas;

/*
 * Given inorder and postorder traversal of a tree, construct the binary tree .
 * Note : You may assume that duplicates do not exist in the tree.
 * 
 * 
 */


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		this.val = x;
		this.left = null;
		this.right = null;
	}
}


public class Solution106 {

	int curr;
	public TreeNode buildTree(int [] inorder, int [] postorder) {
		this.curr = postorder.length - 1;
		return buildTree(inorder,postorder,0,inorder.length -1);

	}
	
	public TreeNode buildTree(int [] inorder,int [] postorder, int left,int right) {
		if(left > right) return null;
		TreeNode root = new TreeNode(postorder[curr]);

		int index = findIdx(inorder, postorder[curr]);
		curr--;
		root.right = buildTree(inorder, postorder, index+1, right);
		root.left = buildTree(inorder, postorder, left, index-1);
		return root;
	}
	
	private int findIdx(int [] inorder,int val) {
		for(int i=0;i<inorder.length;i++) {
			if(inorder[i] == val) {
				return i;
			}
		}
		return 0;
	}
	
	
	
}
