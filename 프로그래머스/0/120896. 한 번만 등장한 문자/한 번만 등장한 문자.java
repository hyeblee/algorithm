import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        int [] has = new int[26];
        
        for(int i = 0; i<s.length(); i++){
            int idx = (char)s.charAt(i) - 'a';
            System.out.println(idx);
            has[idx]++;
        }
        for(int i = 0; i < 26; i++){
            if(has[i] == 1)
                answer += (char)('a' + i);
        }
        
        
        
        return answer;
    }
}