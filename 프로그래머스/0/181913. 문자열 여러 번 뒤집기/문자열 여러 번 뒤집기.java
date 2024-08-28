class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        for(int i=0;i<queries.length;i++){
            int s = queries[i][0];
            int e = queries[i][1];
            String forward = my_string.substring(0,s);
            String reverse = my_string.substring(s,e+1);
            String back = my_string.substring(e+1,my_string.length());
            reverse = new String(new StringBuilder(reverse).reverse());
            my_string = forward + reverse + back;

        }
        return my_string;
    }
}