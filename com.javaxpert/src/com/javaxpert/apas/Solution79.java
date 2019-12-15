package com.javaxpert.apas;

public class Solution79 {
	
	public boolean exist(char[][] board, String word) {
		if(board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}
		
		if(word.length() == 0) {
			return true;
		}
		
		for(int i=0;i<board.length ;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j] == word.charAt(0)) {
					if(backtrack(board,i,j,word,0)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean backtrack(char[][] board,int i,int j,String word,int pos) {
		if(word.length() == pos) {
			return true;
		}
		
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(pos)) {
			return false;
		}
		
		board[i][j] = '#'; // instead of using another 2D boolean array,
		boolean res = backtrack(board,i-1,j,word,pos+1)
		|| backtrack(board,i+1,j,word,pos+1)
		|| backtrack(board,i,j-1,word,pos+1)
		|| backtrack(board,i,j+1,word,pos+1);
		
		board[i][j] = word.charAt(pos);	// reset
		return res;
		
	}
	
}
