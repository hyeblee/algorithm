class Solution {
    public int solution(int hp) {
        int answer = 0;
        int a = hp / 5;
        hp -= a*5;
        int b = hp / 3;
        int c = hp % 3;
        answer = a + b + c;
        return answer;
    }
}