import java.util.*;
import java.io.*;


public class Main {

  public static int n;
  public static int[] arr;
  public static int result = 0;

  public static boolean isAvailable(int depth) {
    for (int i = 0; i < depth; i++) {
      // 세로 중복 확인
      if (arr[depth] == arr[i]) { // 현재depth의 col위치와 모든 depth의 col위치 비교
        return false;
      }
      // 대각선 중복 확인
      if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
        return false;
      }
    }
    return true;
  }

  public static void dfs(int depth) {
    if (depth == n) {
      result++;
      return;
    }
    for (int i = 0; i < n; i++) {
      arr[depth] = i;
      if (isAvailable(depth)) {
        dfs(depth + 1);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    dfs(0);

    System.out.println(result);
  }


}