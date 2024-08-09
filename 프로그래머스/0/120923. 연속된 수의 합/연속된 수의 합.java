class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        double avg = (double)(total)/num;
        for(int i=0;i<num/2;i++){
            double gap = num - 1 - i - i;//i랑 대칭인애랑 차이가 gap

            answer[i] = (int)(avg - gap/2);
            answer[num - i - 1] = (int)(avg + gap/2);
        }
        if(avg % 1 == 0)
            answer[num/2] = (int)avg;
        return answer;
    }
}