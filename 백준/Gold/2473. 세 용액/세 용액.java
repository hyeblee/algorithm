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

        
        long[] result = new long[3];
        long min = Long.MAX_VALUE;
        
        

        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                long sum = arr[i] + arr[l] + arr[r];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    result[0] = arr[i];
                    result[1] = arr[l];
                    result[2] = arr[r];
                }

                if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
                
            }
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
