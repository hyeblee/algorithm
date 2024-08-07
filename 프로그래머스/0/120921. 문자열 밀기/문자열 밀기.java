class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        int length = A.length();
        for(int i = 0; i < length; i++){//밀 수 있는 경우의 수
            int flag = 1;
                for(int k = 0; k < length; k++){//A와 B 인덱스 훑을 범위
                    if(A.charAt(k) != B.charAt((k + i)%length)){
                        flag = 0;
                        break;
                    }
                        
                
            }
            if(flag == 1)
                return i;
        }
        return -1;
    }
}