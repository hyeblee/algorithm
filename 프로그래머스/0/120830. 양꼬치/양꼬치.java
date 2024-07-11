class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        answer+=12000*n;
        
        int drinkN = n / 10;
        k = k - drinkN;
        if(k<0)
            k = 0;
        answer+=2000*k;
        return answer;
    }
}