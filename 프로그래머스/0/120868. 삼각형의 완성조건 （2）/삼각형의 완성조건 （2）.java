class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int big = sides[0] > sides[1] ? sides[0]: sides[1];
        int small = sides[0] < sides[1]? sides[0] : sides[1];
        
        //제일 긴 변인 경우
        for(int i = big; i < big + small; i++)
            answer++;
        //긴 변이 아닌 경우
        for(int i = 1; i < big; i++){
            if(i + small > big)
                answer++;
        }
        return answer;
    }
}