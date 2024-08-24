import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> list = new ArrayList<>();
        String [] answer = {};
        for(int i=0;i<picture.length;i++){
            String str = "";
            for(int j=0;j<picture[i].length();j++){
                for(int cnt=0;cnt<k;cnt++)
                    str += picture[i].charAt(j);
            }
            for(int cnt=0;cnt<k;cnt++){
                list.add(str);

            }
                
        }
        answer = list.toArray(new String[0]);
        return answer;
    }
}