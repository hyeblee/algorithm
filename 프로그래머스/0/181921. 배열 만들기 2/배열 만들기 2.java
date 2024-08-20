import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {-1};
        List<Integer> list = new ArrayList<>();
        
        for(int i = l;i<=r;i++){
            String str = String.valueOf(i);
            str = str.replace("5","0"); // 5와 0으로 이루어져있다면 정수값은 0이 된다.
            if(Integer.valueOf(str)==0)
                list.add(i);
        }
        if(list.size()==0){
            return answer;
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}