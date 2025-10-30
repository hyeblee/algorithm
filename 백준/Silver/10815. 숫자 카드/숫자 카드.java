import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    
    static boolean binarySearch(int target, int s, int e) {
        int mid = (s + e) / 2;

        if (target == arr[mid]) {
            return true;
        }

        if (s >= e) {
            return false;
        }

        if (arr[mid] > target) {
            return binarySearch(target, s, mid);
        } else {
            return binarySearch(target, mid + 1, e);
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(x, 0, n-1)? "1 ": "0 ");
        }

        System.out.println(sb);
    }
}