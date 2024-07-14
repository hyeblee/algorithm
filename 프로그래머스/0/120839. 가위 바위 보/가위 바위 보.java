import java.util.*;
class Solution {
    public String solution(String rsp) {
        String answer = "";
        Map <Character, Character> map = new HashMap<> () {{
            put('2','0'); 
             put('0','5'); 
             put('5','2');
        }};
        
        for(int i = 0; i<rsp.length(); i++){
            answer += map.get(rsp.charAt(i));
            
        }
        
        return answer;
    }
}