class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n%2!=0)
            n--;
        for(int i = 2; i<=n;i+=2)
            answer+=i;
        return answer;
    }
}