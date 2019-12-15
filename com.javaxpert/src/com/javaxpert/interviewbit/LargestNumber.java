package com.javaxpert.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        
        List<String> B = new ArrayList<String>();
        for(int i=0;i<A.size();i++) {
            B.add(Integer.toString(A.get(i)));
        }
        
        Collections.sort(B, (String aStr, String bStr) -> {
            if((aStr+bStr).compareTo(bStr+aStr) > 0) {
                return -1;
            }
            else if( (aStr+bStr).equals(bStr+aStr)) {
                return 0;
            }
            else {
                return 1;
            }
        });
        StringBuilder str = new StringBuilder();
        for(int i=0;i<B.size();i++) {
            str.append(B.get(i));
        }
        String answer = str.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }
        else {
            return answer;
        }
    
    }
}
