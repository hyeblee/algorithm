import java.util.*;

class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        
        while(age>0){
            int n = age % 10;
            sb.append((char)('a'+n));
            System.out.println(sb);
            age/=10;
        }
        String answer = sb.reverse().toString();
        return answer;
    }
}