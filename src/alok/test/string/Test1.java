package alok.test.string;

import java.io.*;
import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        //String A=sc.next();
        //String B=sc.next();
        String A="hello";
        String B="hi";
        
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(findLengthSum(A, B));
        System.out.println(isLexicographicalyLarger(A, B) ? "Yes" : "No");
        System.out.println(capatializeFirst(A) + " " + capatializeFirst(B));
        
        
    }
    
    static int findLengthSum(String str1, String str2) {
        int length = 0;
        if (str1 != null) {
            length = str1.length();
        }
        
        if (str2 != null) {
            length += str2.length();
        }
        
        return length;
    }
    
    static Boolean isLexicographicalyLarger(String str1, String str2) {
        char[] charStr1 = str1.toCharArray();
        char[] charStr2 = str2.toCharArray();
        int length = charStr1.length < charStr2.length ? charStr1.length : charStr2.length;
        
        for (int i = 0; i < length; i++) {
            if (charStr1[i] == charStr2[i]) {
                continue;
            }
            
            if (charStr1[i] < charStr2[i]) {
                return false;
            }
            
            return true;
        }
        
        return false;
    }
    
    static String capatializeFirst(String str) {
        if (str.length() == 0)
            return str;
        
        char[] charStr = str.toCharArray();
        
        if (charStr[0] >= 97 && charStr[0] <= 122 ) 
        	charStr[0] -= 32;
        
        return String.valueOf(charStr);
    }
}
