class Solution {
    int subtract(int a, int n){
        return Math.abs(a-n);
    }
    public int[] solution(int[] numlist, int n) {
        int length = numlist.length;
        int[] answer = new int[length];
        for(int i = 0; i < length - 1; i++){
            for(int j = 0; j < length - 1; j++){
                 if(subtract(numlist[j], n) == subtract(numlist[j + 1], n) && numlist[j] > numlist[j+1])
                     continue;
                if(subtract(numlist[j], n) >= subtract(numlist[j + 1], n)){
                    int tmp = numlist[j];
                    numlist[j] = numlist[j+1];
                    numlist[j+1] = tmp;
                }
            }
        }
        answer = numlist;
        return answer;
    }
}