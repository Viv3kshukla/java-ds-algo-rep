package com.javaxpert.hackerearth.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TotalPairs {
	
	public static final Long MODN = 1000000007L; 
	
	public static long powm(long x,long n) {
		long res = 1;
		while(n > 0) {
			if((n & 1) == 1) {
				res = (res * x) % MODN;
			}
			x = (x*x) % MODN;
			n = n >> 1;
		}
		return res;
	}
	
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int t = Integer.parseInt(input);
		
		while(t-- > 0) {
			input = br.readLine().trim();
			long n = Long.parseLong(input.split(" ")[0]);
			long k = Long.parseLong(input.split(" ")[1]);
			long totalPairs = powm(k,n);
			long ppairs;
			if((n&1) == 1) {
				ppairs = powm(k,n/2);
				ppairs = (ppairs*k) % MODN;
			}
			else {
				ppairs = powm(k,n/2);

			}
			long npairs = (totalPairs - ppairs + MODN) % MODN;
			long answer = (npairs * ppairs) % MODN;
			
			System.out.println(answer);
			
		}
		
	}
}
