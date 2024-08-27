import java.util.*;
class Solution {
    public String solution(String a, String b) {
        int length = a.length()>b.length()? a.length():b.length();
        int[] arrayA = new int[length];
        int[] arrayB = new int[length];
        String[] answer = new String[length + 1];
        Arrays.fill(answer,"0");
        
        for(int i=0;i<a.length();i++){
            arrayA[a.length()-i-1] = a.charAt(i) - '0';
        }
       for(int i=0;i<b.length();i++){
            arrayB[b.length()-i-1] = b.charAt(i) - '0';
        }
        for(int i=0;i<length;i++){
            int result = arrayA[i] + arrayB[i] + Integer.valueOf(answer[i]);
            // System.out.printf("%d %d %d %d\n",arrayA[i],arrayB[i],Integer.valueOf(answer[i]),result);
            if(result >= 10)
                answer[i+1] = "1";
            answer[i] = String.valueOf(result % 10);
        }
        String finalAnswer = "";
        for(int i=0;i<answer.length;i++){
            if(i==answer.length-1 && answer[i].equals("0"))
                break;
            finalAnswer += answer[i];
        }
        finalAnswer = new String(new StringBuilder(finalAnswer).reverse());

        return finalAnswer;
    }
}