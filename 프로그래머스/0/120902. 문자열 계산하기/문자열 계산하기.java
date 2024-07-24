import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] strs = my_string.split(" ");
        answer += Integer.valueOf(strs[0]);
        for(int i = 1; i<strs.length - 1;i+=2){
            int n = Integer.valueOf(strs[i + 1]);
            if(strs[i].equals("+"))
                answer+=n;
            else
                answer-=n;
        }
        return answer;
    }
}