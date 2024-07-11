class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int length = num_list.length;
        int evenCount = 0;
        for(int i = 0; i<length;i++){
            if(num_list[i]%2==0)
                evenCount++;
        }
        answer[0] = evenCount;
        answer[1] = length - evenCount;
        return answer;
    }
}