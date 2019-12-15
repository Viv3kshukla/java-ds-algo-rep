package com.javaxpert.test;

public class TestClass24 {
	public int isPower(int A) {
        int temp;
        for(int i=2;i*i <= A;i++) {
            temp = A;
            while(temp % i == 0) {
                temp = temp / i;
            }
            if(temp == 1) return 1;
        }
        return 0;
    }
	public static void main(String args[]) {
		TestClass24 solution = new TestClass24();
		System.out.println(solution.isPower(4));
	}
}


