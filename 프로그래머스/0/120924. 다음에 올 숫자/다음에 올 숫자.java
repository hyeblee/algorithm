class Solution {
    public int solution(int[] common) {
        int answer = common[common.length - 1];
        int gap;
        //등차수열인 경우
        if(common[0] - common[1] == common[1] - common[2]){
            gap = common[1] - common[0];
            return answer + gap;
        }
        else{//등비수열인 경우            
            gap = common[1]/common[0];
            return answer * gap;
        }
    }
}