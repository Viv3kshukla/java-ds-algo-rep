package com.javaxpert.geeksforgeeks.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestSubarrayMaxKDistinct {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		input = br.readLine();
		int n = Integer.parseInt(input);
		input = br.readLine();
		int k = Integer.parseInt(input);
		input = br.readLine();
		
		List<Integer> list = Arrays.asList(input.trim().split(" "))
				.stream().map(s -> Integer.parseInt(s))
				.collect(Collectors.toList());
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
}
