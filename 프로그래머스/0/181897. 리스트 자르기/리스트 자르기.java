import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        int start,end,delta=1;
        List<Integer> list = new ArrayList<>();
        
        if(n==1){
            start=0;
            end=slicer[1];
        }
            
        else if(n==2){
            start=slicer[0];
            end=num_list.length-1;
        }
        else if(n==3){
            start = slicer[0];
            end=slicer[1];
        }
        else{
            start = slicer[0];
            end=slicer[1];
            delta = slicer[2];
        }
            
        
        for(int i=start;i<=end;i+=delta){
            list.add(num_list[i]);
        }
        System.out.println(list.toString());
        answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}