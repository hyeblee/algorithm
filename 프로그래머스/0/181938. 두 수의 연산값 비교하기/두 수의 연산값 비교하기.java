class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String str = "";
        str = String.valueOf(a)+String.valueOf(b);
        answer = Integer.valueOf(str);
        answer = 2*a*b > answer? 2*a*b : answer;
        
        
        
        return answer;
    }
}