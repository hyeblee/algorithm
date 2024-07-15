class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int length = numbers.length;
        
        answer += 2 * (k - 1);
        
        answer %= (length);
        
        answer = numbers[answer];
        return answer;
    }
}