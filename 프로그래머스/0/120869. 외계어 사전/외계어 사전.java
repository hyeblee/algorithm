import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        int[] has = new int[spell.length];
        int i,j = 0;
        for(i = 0; i < dic.length; i++){
            Arrays.fill(has,0);
            for(j =0; j < spell.length; j++){
                if(dic[i].contains(spell[j]))
                    has[j] = 1;
                else
                    break;
            }
            if(j == spell.length)
                return 1;
        
        }
        return 2;
    }
}