class Solution {
    public int[] solution(int money) {
        int count;
        int change;
        
        count = money/5500;
        change = money%5500;
        
        int[] answer = {count, change};
        
        
        return answer;
    }
}