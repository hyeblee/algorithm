import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        int answer = 1;
        
        if(dots[0][0] != dots[1][0])
            answer *= Math.abs(dots[0][0] - dots[1][0]);
        else
            answer *= Math.abs(dots[0][0] - dots[2][0]);
        
        if(dots[0][1] != dots[1][1])
            answer *= Math.abs(dots[0][1] - dots[1][1]);
        else
            answer *= Math.abs(dots[0][1] - dots[2][1]);
        return answer;
    }
}