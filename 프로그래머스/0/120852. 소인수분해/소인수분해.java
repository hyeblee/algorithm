import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        ArrayList <Integer> list = new ArrayList<>();
        for(int i = 2; i<= n; i+=2){
            if(n % i == 0){
                list.add(i);
                n/=i;
                while(n % i == 0){
                    n/=i;
                }
            }
            
            
            if(i == 2){
                i--;
            }
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}