import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<my_string.length(); i++){
            char ch = my_string.charAt(i);
            if(ch >= '0' && ch <= '9'){
                list.add(ch - '0');
            }
        }
        answer = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}