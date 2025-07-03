import java.util.*;
import java.io.*;


public class Main {

  public static int[][][] dp = new int[21][21][21];

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    for (int a = 0; a < 21; a++) {
      for (int b = 0; b < 21; b++) {
        for (int c = 0; c < 21; c++) {
          if (a <= 0 || b<= 0 || c<= 0) {
            dp[a][b][c] = 1;
          }
          else if (a < b && b < c) {
            dp[a][b][c] = dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c];
          } else {
            dp[a][b][c] =
                dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1] - dp[a - 1][b - 1][c
                    - 1];
          }
        }
      }
    }

    while (true) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      if (a == -1 && b == -1 && c == -1) {
        break;
      }
      int result = 1;
      if (a <= 0 || b <= 0 || c <= 0) {
        result = 1;
      } else if (a > 20 || b > 20 || c > 20) {
        result = dp[20][20][20];
      } else {
        result = dp[a][b][c];
      }
      System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, result);
    }

  }


}