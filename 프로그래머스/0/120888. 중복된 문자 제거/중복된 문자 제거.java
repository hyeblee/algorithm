import java.util.Set;
import java.util.LinkedHashSet;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for(int i = 0; i<my_string.length(); i++){
            set.add(my_string.charAt(i));
        }
        
        for(char ch : set){
            answer += ch;
        }
        
        return answer;
    }
}