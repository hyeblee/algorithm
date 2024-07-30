class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board[0].length;
        int [][] arr = new int[n + 2][n + 2];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    for(int x = i - 1; x <= i + 1; x++){
                        for(int y = j - 1; y <= j + 1; y++){
                            arr[x + 1][y + 1] = 1;
                        }
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                if(arr[i][j] == 0)
                    answer++;
            }
        }
        
        return answer;
    }
}