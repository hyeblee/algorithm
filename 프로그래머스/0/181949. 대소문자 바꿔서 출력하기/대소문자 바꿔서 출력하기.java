import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        char[] arr = a.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>='a' && arr[i]<='z')
                answer += (char)(arr[i]-'a'+'A');
            else
                answer += (char)(arr[i]-'A'+'a');
        }
        System.out.print(answer);
    }
}