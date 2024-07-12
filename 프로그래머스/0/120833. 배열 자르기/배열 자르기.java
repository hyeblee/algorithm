import java.util.*;
class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = {};
        ArrayList <Integer> list = new ArrayList();
        for(int i = num1;i<=num2;i++){
            list.add(numbers[i]);
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}