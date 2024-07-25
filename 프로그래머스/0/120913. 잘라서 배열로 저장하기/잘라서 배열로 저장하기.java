import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        int i;
        for(i = 0; i + n <= my_str.length(); i += n){
            list.add(my_str.substring(i, i + n));
        }
        if(i < my_str.length()){
            list.add(my_str.substring(i));
        }
        answer = list.toArray(new String[0]);
        
        return answer;
    }
}