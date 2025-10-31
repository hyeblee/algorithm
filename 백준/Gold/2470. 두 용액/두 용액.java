import java.io.*;
import java.util.*;

public class Main {
    
    // 산성은 1~10^9
    // 알칼리성은 -10^-9~-1
    // 2개 선택 -> 가장 가까운 용액
    
    static long[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];

        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int l = 0;
        int r = arr.length - 1;

        long[] result = new long[2];
        long min = Long.MAX_VALUE;
        
        while (l < r) {
            long sum = arr[l] + arr[r];
            
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                result[0] = arr[l];
                result[1] = arr[r];
            }
            if (sum < 0) { // 합이 음수라면 음수값이 너무 큰 것이므로 
                l++;
            } else {
                r--;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
