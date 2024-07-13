import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int length = emergency.length;
        int[] answer = new int[length];
        
        for(int i = 0; i<length;i++){
            for(int j = 0; j<length; j++){
                if(emergency[i] <= emergency[j])
                    answer[i]++;
                    
            }
        }
        
        return answer;
    }
}