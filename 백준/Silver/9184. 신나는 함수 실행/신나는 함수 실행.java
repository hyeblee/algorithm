import java.util.*;
import java.io.*;


public class Main {

  public static int MAX_SIZE = 50;
  public static int[][][] dp = new int[2 * MAX_SIZE + 1][2 * MAX_SIZE + 1][2 * MAX_SIZE + 1];

  public static void getDp() {
    for (int a = -50; a <= 20; a++) {
      for (int b = -50; b <= 20; b++) {
        for (int c = -50; c <= 20; c++) {
          int i = a + 50;
          int j = b + 50;
          int k = c + 50;
          if (a <= 0 || b <= 0 || c <= 0) {
            dp[i][j][k] = 1; // 1로 만들어주는 부분
          } else if (a < b && b < c) {
            dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
          } else {
            dp[i][j][k] =
                dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k
                    - 1];
          }
        }
      }
    }

    int tmp = dp[70][70][70];
//    System.out.println(tmp);
    for (int a = -50; a <= 50; a++) {
      for (int b = -50; b <= 50; b++) {
        for (int c = -50; c <= 50; c++) {
          int i = a + 50;
          int j = b + 50;
          int k = c + 50;
          if (a <= 0 || b <= 0 || c <= 0) {
            dp[i][j][k] = 1; // 1로 만들어주는 부분
          } else if (a > 20 || b > 20 || c > 20) {
            dp[i][j][k] = tmp;
            if (a==20 && b==20 && c==21){
//              System.out.printf("%d %d %d - %d\n",a,b,c,dp[i][j][k]);
            }
          } else if (a < b && b < c) {
            dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
          } else {
            dp[i][j][k] =
                dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1]
                    - dp[i - 1][j - 1][k - 1];
          }
        }
      }
    }

  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    getDp();

    while (true) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      if (a == -1 && b == -1 && c == -1) {
        break;
      }

      System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, dp[a + 50][b + 50][c + 50]);
    }

  }


}