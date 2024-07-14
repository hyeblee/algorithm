import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        HashMap <Integer, Integer> map = new HashMap<>();
        double squareRoot = Math.sqrt(n);
        for(int i = 1; i< squareRoot; i++){
            if(n % i == 0){
                map.put(i, n/i);
                answer++;
            }
        }
        answer *= 2;
        System.out.println(map);
        if(squareRoot % 1 == 0)
            answer+=1;
        return answer;
    }
}