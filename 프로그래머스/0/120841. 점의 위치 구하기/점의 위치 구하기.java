class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        int product = dot[0]*dot[1];
        
        if(product < 0){
            if(dot[0] < 0)
                return 2;
            else
                return 4;
        }
        
        else {
            if(dot[0] < 0)
                return 3;
            else
                return 1;
        }

    }
}