class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int plus = 0;
        int max;
        
        if(sides[0] > sides[1] && sides[0] > sides[2])
        {
            max = sides[0];
            plus = sides[1] + sides[2];
        }   
        else if(sides[1] > sides[2] && sides[1] > sides[0])
         {
            max = sides[1];
            plus = sides[0] + sides[2];
        }   
        else
           {
            max = sides[2];
            plus = sides[1] + sides[0];
        }   
        
        
        if(max < plus)
        return 1;
        else
            return 2;
    }
}