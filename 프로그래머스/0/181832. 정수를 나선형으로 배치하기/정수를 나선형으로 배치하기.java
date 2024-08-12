class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int x = 0, y = 0;
        int number = 1;
        String direction = "right";
        
    
        while(number <= n * n){
            if(direction.equals("right")){
                System.out.printf("%d %d\n",x,y);
                if(x == n || answer[y][x] !=0){ //오른쪽으로 더이상 못가면
                    direction = "down";
                    y++;
                    x--;
                }
                
                else
                    answer[y][x++] = number++;
            }
            if(direction.equals("down")){
                if(y == n || answer[y][x] !=0) { //아래로 더이상 못가면
                    direction = "left";
                    x--;
                    y--;
                }
                else
                    answer[y++][x] = number++;
            }
            if(direction.equals("left")){
                if(x == -1 || answer[y][x] !=0) { //왼쪽으로 더이상 못가면
                    direction = "up";
                    y--;
                    x++;
                }
                else
                    answer[y][x--] = number++;
            }
            if(direction.equals("up")){
                if(y == -1 || answer[y][x] !=0) { //위로 더이상 못가면
                    direction = "right";
                    x++;
                    y++;
                }
                else
                    answer[y--][x] = number++;
            }
        }
        return answer;
    }
}