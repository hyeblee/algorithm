class Solution {
    public int solution(int n) {
        int answer = 1;
        int i;
        for(i = 1; answer <= n; i++){
            answer *= i;
        }
        return (i-2);
    }
}