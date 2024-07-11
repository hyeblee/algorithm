import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        
        char [] charArray = my_string.toCharArray();
        
        for(char ch : charArray){
            for(int i = 0; i<n;i++){
                sb.append(ch);
            }
        }
        String answer = sb.toString();
        return answer;
    }
}