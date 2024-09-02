import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        boolean same = true;
        
        while(true){
            same = true;
            for(int i=0;i<arr.length;i++){
                int n = arr[i];
                if(arr[i]>=50 && n%2==0)
                    n = n/2;
                
                else if(arr[i]<50 && arr[i]%2==1)
                    n = n*2 + 1;
                
                if(same==true && n!=arr[i])
                    same = false;
                arr[i] = n;
            }
            if(same==true)
                break;
            answer++;
            // System.out.println(Arrays.toString(arr));
        }
        
        return answer;
    }
}