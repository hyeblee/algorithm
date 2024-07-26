import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        int tmp1 = numbers[0]*numbers[1];
        int tmp2 = numbers[numbers.length - 1]*numbers[numbers.length - 2];
        answer = (tmp1 > tmp2)? tmp1 : tmp2;
        return answer;
    }
}