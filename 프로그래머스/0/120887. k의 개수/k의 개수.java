class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int start = i; i <= j; i++){
            String str = Integer.toString(i);
            String n = Integer.toString(k);
            if(str.contains(n)){
                int number = i;
                while(number > 0){
                    if(number % 10 == k)
                        answer++;
                    number/=10;
                }
            }
                
        }
        return answer;
    }
}