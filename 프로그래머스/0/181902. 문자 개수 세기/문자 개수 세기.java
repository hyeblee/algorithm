import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        System.out.printf("%d\n",Integer.valueOf('a'));
        for(int i=0;i<my_string.length();i++){
            char ch = my_string.charAt(i);
            int idx;
            if(Character.isUpperCase(ch))
                idx = ch - 'A';
            else
                idx = ch - 'a' + 26;
            answer[idx]++;
        }
        return answer;
    }
}