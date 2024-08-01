class Solution {
    public boolean check(int n){
        //3의 배수인 경우
        if(n % 3 == 0)
            return false;
        String str = String.valueOf(n);
        if(str.contains("3"))
            return false;
        return true;
    }
    
    public int solution(int n) {
        int answer = 0;
        int[]arr = new int[100];
        int number = 1;
        for(int i = 0; i < 100; i++){
            while(!check(number))
                number++;
            arr[i] = number;
            number++;
        }
        return arr[n-1];
    }
}