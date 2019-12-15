package com.javaxpert.interviewbit;

import java.util.Arrays;
import java.util.List;

public class HammingDistance {
    
    public static final Integer MOD = 1000000007;
    
    public int hammingDistance(final List<Integer> A) {
        Integer temp;
        int bits[] = new int[64];
        int j = 0;
        for(int i=0;i<A.size();i++) {
            temp = A.get(i);
            j = 0;
            System.out.println(temp);
            while(temp > 0) {
                if((temp & 1) == 1) {
                    bits[j]++;
                }
                j++;
                temp = temp >> 1;
            }
            for(int k = 0;k < 4;k++) {
                System.out.print(bits[k] + "   ");
            }
            System.out.println();
        }
        int ans = 0;
        for(int i = 0;i< 4;i++) {
            System.out.print(bits[i] + "   ");
        }
        System.out.println();
        for(int i = 0;i < 64;i++) {
            ans += bits[i] * (A.size() - bits[i]);
            ans = ans % MOD;
        }
        return (2*ans) % MOD;
    }
    
    public static void main(String args[]) {
    	HammingDistance solution = new HammingDistance();
    	final List<Integer> arr = Arrays.asList(2,4,6);
    	int ans = solution.hammingDistance(arr);
    	System.out.println(ans);
    }
    
    
}
