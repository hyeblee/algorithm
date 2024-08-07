class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        int length = before.length();
        int[] match = new int[length];
        int i,j;
        for(i = 0; i < length; i++){
            for(j = 0; j < length;j++){
                if(before.charAt(i) == after.charAt(j) && match[j] != 1){
                    match[j] = 1;
                    System.out.println(j);
                    break;
                }
            }
            if(j == length || match[j] == 0)
                return 0;
        }
        return 1;
    }
}