class Solution {
    public String solution(int age) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        while(age>0){
            int n = age%10;
            sb.append((char)('a' + n));
            age/=10;
        }
        
        answer = sb.reverse().toString();
        
        return answer;
    }
}