import java.util.*;
import java.io.*;

public class Main {

  /* dp[i][w] i번째 아이템까지 고려했을때, 무게 제한이 w일때의 최대 가치
   * dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i])
   * 이전 아이템까지의 고려 or 현재아이템까지의 고려 중에서, w-weight[i]가 무게제한일때 + 현재가치
   *  */
  public static int N, K;
  public static int[][] dp;
  public static int[] weight;
  public static int[] value;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    dp = new int[N + 1][K + 1];
    weight = new int[N + 1];
    value = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      weight[i] = Integer.parseInt(st.nextToken());
      value[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= K; j++) {
        if (weight[i] > j) { // 무게를 담을 수 없는 경우
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
        }
      }
    }

    System.out.println(dp[N][K]);


  }
}