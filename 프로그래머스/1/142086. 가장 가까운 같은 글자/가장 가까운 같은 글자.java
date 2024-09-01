import java.util.*;

class Solution {
    public int[] solution(String s) {

        int[] answer = new int[s.length()];
        Arrays.fill(answer,-1);
        
        for(int i=0;i<s.length();i++){
            for(int j=0;j<i;j++){
                if(s.charAt(i)==s.charAt(j))
                    answer[i]=Math.abs(i-j);
            }
        }
        
        
        return answer;
    }
}