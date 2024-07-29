import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        char[] arr = my_string.toCharArray();
        int n = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= '0' && arr[i] <= '9'){
                n *= 10;
                n += arr[i] - '0';
            }
            else{
                answer += n;
                n = 0;
            }
        }
        answer += n;
        return answer;
    }
}