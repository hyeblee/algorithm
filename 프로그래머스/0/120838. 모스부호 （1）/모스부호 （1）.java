import java.util.*;

class Solution {
    public String solution(String letter) {
        String answer = "";
        String [] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String [] split = letter.split(" ");
        Map <String, Character> map = new HashMap<>();
        
        int i = 0;
        for(String ms : morse){
            map.put(ms, (char)('a' + i));
            i++;
        }
        for(String str : split){
            answer += map.get(str);
        }
        
        return answer;
    }
}