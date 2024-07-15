class Solution {
    public int[][] solution(int[] num_list, int n) {
        int listLength = num_list.length / n;
        
        int[][] answer = new int[listLength][n];
        
        int k = 0;
        for(int i = 0; i < listLength; i++){
            for(int j = 0; j < n ; j++){
                answer[i][j] = num_list[k++];
            }
        }
        return answer;
    }
}