class Solution {
    public String solution(String code) {
        String answer = "";
        char[] arr = code.toCharArray();
        int mode = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='1'){// 1이면 모드 바꾸고 다음 인덱스로 넘어가기
                mode = mode==0? 1:0;
                continue;
            }
            if(mode==0&&i%2==0)// mode=0이면서 짝수인덱스이면 더하기
                answer+=arr[i];
            else if(mode==1&&i%2==1) //mode=1이면서 홀수인덱스이면 더하기
                answer+=arr[i];
        }
        if(answer.equals(""))
            return "EMPTY";
        return answer;
    }
}