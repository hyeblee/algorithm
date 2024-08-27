class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            answer[i] = -1;
            for(int j=queries[i][0];j<=queries[i][1];j++){
                if(arr[j]>queries[i][2]&&(answer[i]==-1 || arr[j]<answer[i]))
                    answer[i]=arr[j];
            }
        }
        
        return answer;
    }
}