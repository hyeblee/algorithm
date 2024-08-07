import java.util.*;
class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        char[] arr = new char[13];
        Arrays.fill(arr,'0');
        int i;
        for(i = 0; i < bin1.length() && i < bin2.length(); i++){
            int n = bin1.charAt(bin1.length() - i - 1) + bin2.charAt(bin2.length() - 1 - i) - 3 * '0' + arr[i];
            if(n == 3){
                arr[i] = '1';
                arr[i + 1] = '1';
            }
            else if (n == 2){
                arr[i + 1] = '1';
                arr[i] = '0';
            }
            else if (n == 1){
                arr[i] = '1';
            }
            System.out.printf("n = %d\n",n);
        }
        //둘이 길이 다른 경우 남은 애(더 긴 친구) 더해주기
        for(;i<bin1.length() || i < bin2.length(); i++){
            int n;
            if(bin1.length()>bin2.length())
                n = bin1.charAt(bin1.length() - 1 - i) - 2*'0' + arr[i];
            else
                n = bin2.charAt(bin2.length() - 1 - i) - 2*'0' + arr[i];
            System.out.println(n);
            if(n == 3){
                arr[i] = '1';
                arr[i + 1] = '1';
            }
            else if (n == 2){
                arr[i + 1] = '1';
                arr[i] = '0';
            }
            else if (n == 1){
                arr[i] = '1';
            }
        }
        
        i = 11;
        for(; i >= 0; i--){
            if(arr[i]!='0')
                break;
        }
        for(; i >= 0; i--){
            answer+=arr[i];
        }
        
        if(answer.equals(""))
            return "0";
        
        return answer;
    }
}