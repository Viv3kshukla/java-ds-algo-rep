package com.javaxpert.geeksforgeeks.microsoft;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int majorityElement(final int[] A) {
        Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
        int n = A.length / 2;
        int answer = A[0];
        for(int i : A) {
            if(mp.containsKey(i)) {
                mp.put(i,mp.get(i) + 1);
                if(mp.get(i) > n ) answer = i;
            }
            else {
                mp.put(i,1);
            }
        }
        return answer;
    }
}
