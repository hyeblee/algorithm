import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));

        for(int i = 0; i< strings.length - 1;i++){
            for(int j = 0; j < strings.length - i - 1; j++){
                if(strings[j].charAt(n)>strings[j+1].charAt(n)){
                    String tmp = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = tmp;
                }
            }
        }
               
        
        return strings;
    }
}