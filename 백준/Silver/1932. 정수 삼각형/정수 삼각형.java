import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

  public static int n;
  public static int[][] grid;
  public static int[][] result;
  public static int max = Integer.MIN_VALUE;
  // 위로 올라가면서 j, j-1 탐색 가능
  // 왼쪽 끝이면 j만 가능, 오른쪽 끝이면 j-1만 가능


  public static void search(int depth) {
    for (int i = 0; i <= depth; i++) {
      result[depth][i] = Math.max(result[depth + 1][i], result[depth + 1][i + 1]) + grid[depth][i];
    }
    if (depth <= 0) {
      return;
    }
    search(depth-1);

  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    grid = new int[n + 1][n + 1];
    result = new int[n + 1][n + 1];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j <= i; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for(int i=0;i<n;i++){
      result[n-1][i] = grid[n-1][i];
    }
    search(n-2);

    System.out.println(result[0][0]);

  }


}