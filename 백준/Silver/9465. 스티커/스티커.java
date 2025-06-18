import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

  /* dp[0][j]의 이전 선택하는 dp[1][j-1]과 dp[1][j-2]가 있다.
   *  dp[0][j-2]는 dp[1][j-1]의 이전 선택이 될 수도 있기 때문에 제외한다.
   *  <점화식>
   *  dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2])
   *  dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) */

  public static int n;
  public static int[][] cost;
  public static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      n = Integer.parseInt(br.readLine());
      cost = new int[2][n];
      dp = new int[2][n];
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        cost[0][j] = Integer.parseInt(st1.nextToken());
        cost[1][j] = Integer.parseInt(st2.nextToken());
      }
      dp[0][0] = cost[0][0];
      dp[1][0] = cost[1][0];
      int max = Math.max(dp[0][0], dp[1][0]);
      for (int j = 1; j < n; j++) {
        if (j == 1) { // 전전칸이 존재하지 않는 경우
          dp[0][1] = dp[1][0] + cost[0][j];
          dp[1][1] = dp[0][0] + cost[1][j];
          max = Math.max(dp[0][1], dp[1][1]);
          continue;
        }
        // 점화식에 dp[0][j-2]를 포함하지 않는 이유는 dp[1][j-1]의 이전선택일수도 있기 때문
        dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + cost[0][j];
        dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + cost[1][j];
        max = Math.max(max, Math.max(dp[0][j], dp[1][j]));
      }
      System.out.println(max);
    }

  }


}