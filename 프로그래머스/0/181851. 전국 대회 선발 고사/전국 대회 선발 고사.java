import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        for(int i=0;i<rank.length;i++){
            if(attendance[i]==false)
                rank[i]=101; //등수가 100일수도 잇음
        }
        int first=-1,second=-1,third=-1;
        for(int i=0;i<rank.length;i++){
            if(first==-1||rank[i]<rank[first]){ // first에 아무것도 없으면 i 저장
                third = second;
                second = first;
                first = i;
            }
            else if(second==-1||rank[i]<rank[second]){ // second에 아무것도 없고 first보다 안작으면 저장
                third = second;
                second = i;
            }
            else if (third==-1||rank[i]<rank[third]){ // third에 아무것도 없고 second보다 안작으면 저장
                third = i;
            }
        }
        
        return 10000*first+100*second+third;

    }
}