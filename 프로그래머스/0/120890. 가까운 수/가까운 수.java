import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        int diff = Math.abs(n-answer);
        
        for(int i = 1; i<array.length; i++){
            int tempDiff = Math.abs(n - array[i]);
            if(tempDiff == diff && answer > array[i]){
                answer = array[i];
            }
            else if (tempDiff < diff){
                answer = array[i];
                diff = tempDiff;
            }
        }
        
        return answer;
    }
}