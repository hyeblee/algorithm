class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for(int i = 0; i< my_string.length(); i++){
            char ch = my_string.charAt(i);
            if(ch >= 'a' && ch <= 'z')
                ch = (char)(ch - 'a' + 'A');
            else
                ch = (char)(ch - 'A' + 'a');
            answer+=ch;
        }
        return answer;
    }
}