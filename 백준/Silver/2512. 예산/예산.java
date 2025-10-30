import java.io.*;
import java.util.*;

public class Main {
    // 정해진 총액 이하에서 가능한 최대의 총 예상
    // 1. 모든 요청 가능 -> 그대로 배정
    // 2. 아니면, 초과하는건 상한액, 나머지는 그대로

    static int n, total; 
    static int[] arr;

    static boolean can(int d) {

        int sum = 0;
        for(int v: arr) {
            if (v > d) {
                sum += d;
            } else {
                sum += v;
            }
        }

        if (sum > total) return false;
        else return true;
    }
    
    // static 
    // static 
    // static 
    

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        total = Integer.parseInt(br.readLine());

        int l = 0;
        int r = arr[n-1] + 1;

        // 만족하는 애들 중 최댓값 -> UpperBound
        while (l < r) {
            int mid = (l + r) / 2;

            if (can(mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        System.out.println(l-1);
    }
}
