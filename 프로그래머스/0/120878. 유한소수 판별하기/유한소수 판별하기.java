class Solution {
    public int solution(int a, int b) {

        //기약분수로 만들기
        for(int i = 2; i <= b/2; i++){
            if(a % i == 0 && b % i == 0){
                a/=i;
                b/=i;
            }
        }
        
        while(b % 2 == 0){
            b/=2;
        }
         System.out.printf("%d\n",b);
        while(b % 5 == 0){
            b/=5;
        }
        System.out.printf("%d\n",b);
        if(b!=1)
            return 2;
        else
            return 1;
        
 
    }
}