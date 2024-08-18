import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        List <Integer> list = new ArrayList<>();
        int start = 0, end = arr.length - 1;
        
        for(int i=0;i<query.length;i++){
            if(i%2==0){//짝수면 뒤를 버린다
                end = start + query[i];
            }
            else{//홀수면 앞을 버린다
                start += query[i];
            }
        }
        int[] result = new int[end - start + 1];
        int index = 0;
        for (int i = start; i <= end; i++) {
            result[index++] = arr[i];
        }

        return result;
    }
}