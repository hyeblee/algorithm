import java.util.*;

class Solution {
    public String solution(int age) {
        String answer = "";
        
        while(age>0){
            answer = (char)('a' + age % 10) + answer;//맨 앞으로 추가 가능
            age/=10;
        }

        return answer;
    }
}