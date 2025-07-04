import java.util.*;
import java.io.*;


public class Main {

  //1, 00
  // N으로 만들수있는 가짓수 세기
  static int N;
  static int cnt;
  static int[] memo;

  public static int dp(int depth) {
    if (memo[depth] != -1) {
      return memo[depth];
    }
    if (depth == 1) {
      return 1;
    }
    if (depth == 2) {
      return 2;
    }
    memo[depth] = dp(depth - 1) + dp(depth - 2);
    memo[depth] %= 15746;
    return memo[depth] ;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    memo = new int[N + 1];
    Arrays.fill(memo, -1);

    System.out.println(dp(N));
  }


}