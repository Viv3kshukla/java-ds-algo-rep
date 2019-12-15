package com.javaxpert.apas;

/*
 * Given a board with m by n cells , each cell has an initial state live(1)
 * or dead (0). Each cell interacts with its eight neighbours using four rules .
 * Any live cell with fewer than two live neighbours dies , as if caused by 
 * under population
 * Any live cell with two or three neighbours lives on to the next generation .
 * Any live cell with more than three live neighbours dies, as if by over population.
 * Any dead cell with exactly three live  neighbours becomes a live cell , as if 
 * by reproduction.
 * Write a function to compute the next state (after one update) of the board 
 * given its current state . The next state is created by applying the above
 * rules simultaneously to every cell in the current state, where births and
 * deaths occur simultaneously.
 * 
 * Input: [
	  	[0,1,0],
	  	[0,0,1],
	  	[1,1,1],
	  	[0,0,0]
		]
   Output: [
		  [0,0,0],
		  [1,0,1],
		  [0,1,1],
		  [0,1,0]
		]
 * 	
 * Follow up : Solve in-place .
 * 
 */

public class Solution289 {
	public void gameOfLife(int [][] board) {
		
	}
}
