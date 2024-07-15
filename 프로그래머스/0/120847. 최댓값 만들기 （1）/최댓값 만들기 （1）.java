class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int max1 = numbers[0];
        int max2 = numbers[1];
        
        for(int i = 2; i< numbers.length; i++){
            if(numbers[i] >= max1){
                max2 = max1;
                max1 = numbers[i];
            }
            else if(numbers[i] > max2)
                max2 = numbers[i];
        }
        return max1*max2;
    }
}