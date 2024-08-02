class Solution {
    public double gradient(int[] a, int[] b){
        return (double)(a[0] - b[0])/(a[1] - b[1]);
    }
    
    public int solution(int[][] dots) {
        //(점1, 점2) 와 (점3, 점4)가 평행인 경우
        if(gradient(dots[0],dots[1]) == gradient(dots[2],dots[3]))
            return 1;
        //(점1, 점3) 와 (점2, 점4)가 평행인 경우
        else if(gradient(dots[0],dots[2]) == gradient(dots[1],dots[3]))
            return 1;
        //(점1, 점4) 와 (점2, 점3)가 평행인 경우
        else if (gradient(dots[0],dots[3]) == gradient(dots[1],dots[2]))
            return 1;
        //평행인 점이 없는 경우
        else
            return 0;
    }
}