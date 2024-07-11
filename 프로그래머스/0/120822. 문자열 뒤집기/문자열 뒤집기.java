class Solution {
    public String solution(String my_string) {
        int length = my_string.length();
        char [] charArray = my_string.toCharArray();
        char [] answer = new char[length];
        for(int i = 0; i<length; i++){
            answer[i] = charArray[length - i - 1];
        }
        System.out.println(new String(answer));
        return new String(answer);
    }
}