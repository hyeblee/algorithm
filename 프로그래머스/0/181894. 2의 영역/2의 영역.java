class Solution {
    public int[] solution(int[] arr) {
        int start = -1;
        int end=-1;
        int[] answer = {};
        for(int i=0;i<arr.length;i++){
            if(arr[i]==2){
                if(start==-1){
                    start=i;
                    end=i;
                }
                else
                    end=i;
            }
        }
        System.out.printf("%d %d\n",start,end);
        if(start==-1){
            return new int[]{-1};
        }
        answer = new int[end-start+1];
        for(int i=start;i<=end;i++){
            answer[i-start]=arr[i];
        }
        return answer;
    }
}