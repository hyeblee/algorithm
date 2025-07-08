import java.util.*;
import java.io.*;

/* <i번째의 최댓값>
  dp[i] = Math.max(
  dp[i-1], // i-1까지만 마심
  dp[i-2] + wine[i], // i-2, i 마심
  dp[i-3] + wine[i-1] + wine[i] // i-1, i 마심 (i-2 안마시고 i-3에다가) */

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] dp = new int[n];
    for(int i=0;i<n;i++){
      arr[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = arr[0];
    if (n>=2)
      dp[1] = arr[0] + arr[1]; // 0, 1 같이 마시기는 가능
    if (n>=3)
      dp[2] = Math.max(Math.max(dp[1], dp[0] + arr[2]), arr[1] + arr[2]);

    for(int i=3;i<n;i++){
      dp[i] = Math.max(Math.max(dp[i-1], dp[i-2]+arr[i]), dp[i-3] + arr[i-1] + arr[i]);
    }

    System.out.println(dp[n-1]);
  }

}