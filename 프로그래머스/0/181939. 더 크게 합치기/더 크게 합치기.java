import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String str1 = String.valueOf(a) + String.valueOf(b);
        String str2 = String.valueOf(b) + String.valueOf(a);
        int n1 = Integer.valueOf(str1);
        int n2 = Integer.valueOf(str2);
        
        if(n1 >= n2)
            return n1;
        else
            return n2;
        

    }
}