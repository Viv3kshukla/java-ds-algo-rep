package com.javaxpert.apas;

/*
 * Given a list of words and two words word1 and word2 , return the shortest
 * distance between these two words in the list.
 * 
 * Example:
 * Assume that words = ["participate", "makes","perfect","coding","makes"]
 * Input : word1 = "coding", word2 = "practice"
 * Output: 3
 * Note: You may assume that word1 does not equal to word2, and word1 and word2
 * are both in the list.
 */

public class Solution243 {
	public int shortestDistanceBrute(String [] words, String word1, String word2) {
		int minDistance = words.length;
		for(int i = 0;i<words.length;i++) {
			if(words[i].equals(word1)) {
				for(int j = 0;j < words.length;j++) {
					if(words[j].equals(word2)) {
						minDistance = Math.min(minDistance, Math.abs(i-j));
					}
				}
			}
		}
		return minDistance;
	}
	
	public int shortestDistanceOptimized(String[] words, String word1, String word2) {
		int i1 = -1, i2 = -1;
		int minDistance = words.length;
		int currentDistance;
		
		for(int i = 0;i< words.length;i++) {
			if( words[i].equals(word1)) {
				i1 = i;
			}
			else if(words[i].contentEquals(word2)) {
				i2 = i;
			}
			
			if(i1 != -1 && i2 != -1) {
				minDistance = Math.min(minDistance, Math.abs(i1 - i2));
			}
			
		}
		return minDistance;
	}
	
}
