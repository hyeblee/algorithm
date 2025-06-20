import java.util.*;
import java.io.*;

public class Main {

  public static int[] dx = {-1, 0, 1};
  public static int N;
  public static int[][] arr;
  public static int[][] dpMax;
  public static int[][] dpMin;

  public static boolean isInRange(int x) {
    return 0 <= x && x < 3;
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N][3];
    dpMax = new int[N][3];
    dpMin = new int[N][3];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
      arr[i][2] = Integer.parseInt(st.nextToken());
    }

    dpMax[0][0] = arr[0][0];
    dpMax[0][1] = arr[0][1];
    dpMax[0][2] = arr[0][2];
    dpMin[0][0] = arr[0][0];
    dpMin[0][1] = arr[0][1];
    dpMin[0][2] = arr[0][2];

    for (int i = 1; i < N; i++) {
      for (int j = 0; j < 3; j++) {
        dpMax[i][j] = arr[i][j];
        dpMin[i][j] = arr[i][j] + dpMin[i - 1][j];
        for (int k = 0; k < 3; k++) {
          int x = j + dx[k];
          if (isInRange(x)) {
            dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i - 1][x] + arr[i][j]);
            dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i - 1][x] + arr[i][j]);
          }
        }
      }
    }

    System.out.print(Math.max(Math.max(dpMax[N - 1][0], dpMax[N - 1][1]), dpMax[N - 1][2]) + " ");
    System.out.println(Math.min(Math.min(dpMin[N - 1][0], dpMin[N - 1][1]), dpMin[N - 1][2]));


  }
}