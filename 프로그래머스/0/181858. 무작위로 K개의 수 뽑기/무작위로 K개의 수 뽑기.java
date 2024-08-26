import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        int idx = 0;
        for(int i = 0; i <arr.length && idx<k; i++){
            int j;
            for(j = 0; j < k;j++){
                if(answer[j]==arr[i]) //이미 answer에 해당 원소 있다면 다음 arr로
                    break;
                    
                 if(answer[j]==-1){ //더 볼 answer 원소가 없다면 순회 중지
                     answer[idx++] = arr[i];
                     break;
                }
                    
            }

        }
        return answer;
    }
}