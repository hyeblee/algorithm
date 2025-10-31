import java.io.*;
import java.util.*;

public class Main {
    

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;

        for(int i=0; i<n;i++) {
            long target = arr[i];
            int l = 0;
            int r = n-1;
            while (l < r) {
                if (l == i) {
                    l++; 
                    continue;
                }
                if (r == i) {
                    r--;
                    continue;
                }
                long sum = arr[l] + arr[r];
                
                if (sum == target) {
                    // System.out.println(arr[l] + " " + arr[r] + " " + target);
                    cnt++;
                    break;
                }
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }        
        System.out.println(cnt);
    }
}
