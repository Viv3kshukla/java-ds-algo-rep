package com.javaxpert.test;

import java.util.HashMap;
import java.util.Map;

public class TestClass25 {
	public String convertToTitle(int A) {
        StringBuilder s = new StringBuilder();
        Map<Integer,Character> map = new HashMap<Integer,Character>();
        for(int i=1; i<=26;i++) {
            map.put(i,(char)(64+i));
        }
 
        while(A > 0) {
        	if(A%26 == 0) {
        		s.append(map.get(26));
        		A = A / 26 - 1;
        	}
        	else {
                s.append(map.get(A%26));      
                A = A / 26;
        	}
        }

        return s.reverse().toString();
    }
	
	public int reverse(int A) {
        int temp = Math.abs(A);
        int reverse = 0;
        while(temp > 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp = temp / 10;
        }
        return reverse;
    }
	
	public static void main(String args[]) {
		TestClass25 solution = new TestClass25();
		System.out.println(solution.convertToTitle(943566));
		System.out.println(solution.reverse(4353));
	}
	
	
}
