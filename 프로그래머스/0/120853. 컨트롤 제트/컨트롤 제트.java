
class Solution {
    public int solution(String s) {
        int answer = 0;
        String [] sep = s.split(" ");
        int len = sep.length;
        
        for(int i = 0; i<len; i++){
            if(sep[i].equals("Z") && i != 0){
                answer -= Integer.valueOf(sep[i - 1]);
                continue;
            }
            answer+=Integer.valueOf(sep[i]);
        }
        return answer;
    }
}