package com.javaxpert.geeksforgeeks.microsoft;

import java.util.Scanner;
import java.util.TreeSet;

public class UglyNumbers {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int n = scan.nextInt();
	
		int i1 = 0,i2 = 0,i3 = 0, na = a,nb = b, nc = c, x;
		
		int arr[] = new int[n+1];
		arr[0] = 1;
		for(int i=1;i<=n;i++) {
			x = Math.min(Math.min(na, nb), nc);
			arr[i] = x;
			if(x == na) {
				i1++;
				na = arr[i1]*a;
			}
			if(x == nb) {
				i2++;
				nb = arr[i2]*b;
			}
			if(x == nc) {
				i3++;
				nc = arr[i3]*c;
			}
		}
		
		for(int i=1;i<=n;i++) {
			System.out.print(arr[i] + " ");
		}
	
	}
}
