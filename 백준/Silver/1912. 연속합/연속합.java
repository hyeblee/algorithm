import java.util.*;
import java.io.*;


public class Main {

  public static int n;
  public static int[] arr;
  public static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    dp = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }


    // 이전 값에 현재값을 더하는 것이 나은지, 현재값만 쓰는게 나은지 판단
    dp[0] = arr[0];
    int max = dp[0];
    for(int i=1;i<n;i++) {
      dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
      max = Math.max(max, dp[i]);
    }
    // dp[n-1]은 이전 값 + 현재 vs 현재만 판단이라 정답이 아님.
    System.out.println(max);




  }


}