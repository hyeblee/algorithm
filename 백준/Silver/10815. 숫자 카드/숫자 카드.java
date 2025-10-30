import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    
    // 반닫힌 구간 [s, e)
    static boolean binarySearch(int target, int s, int e) {
        if (s >= e) return false; // 더 이상 탐색할 구간이 없으면 false
        
        int mid = (s + e) / 2;

        if (arr[mid] == target) return true;

        if (arr[mid] > target) {
            return binarySearch(target, s, mid); // mid는 포함하지 않음
        } else {
            return binarySearch(target, mid + 1, e); // mid 제외, 오른쪽 구간 탐색
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

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
            sb.append(binarySearch(x, 0, n) ? "1 " : "0 "); // n은 포함하지 않음
        }

        System.out.println(sb);
    }
}
