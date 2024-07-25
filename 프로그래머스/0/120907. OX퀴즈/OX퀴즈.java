import java.util.*;

class Solution {
    public String cal(String str){
        String[] strs = str.split(" ");
        
        int x = Integer.valueOf(strs[0]);
        int y = Integer.valueOf(strs[2]);
        int z = Integer.valueOf(strs[4]);
        int result;
        if(strs[1].equals("+"))
            result = x + y;
        else
            result = x - y;
        
        if(result == z)
            return "O";
        else
            return "X";
        
    }
    
    public String[] solution(String[] quiz) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        for(String str : quiz){
            list.add(cal(str));
        }
        answer = list.toArray(new String[list.size()]);
        return answer;
    }
}