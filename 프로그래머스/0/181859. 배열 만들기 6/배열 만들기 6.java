import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] stk = new int[arr.length];
        int idx=0;
        Arrays.fill(stk,-1);
        for(int i=0;i<arr.length;i++){
            if(idx==0)
                stk[idx++]=arr[i];
            else if(stk[idx-1]==arr[i]){
                stk[idx-1]=-1;
                idx--;
            }
            else
                stk[idx++]=arr[i];
        }
        if(idx==0){
            int[] answer = {-1};
            return answer;
        }
        System.out.println(idx);
        int[] answer = new int[idx];
        
        for(int i=0;i<idx;i++){
            answer[i]=stk[i];
        }
        return answer;
    }
}