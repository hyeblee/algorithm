import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
  public static int N, M;
  public static int[] result;
  public static StringBuilder sb = new StringBuilder();

  // 오름차순인 수열 만들기
  public static void dfs(int depth, int cur) {
    if (depth == M) {
      for(int n: result) {
        sb.append(n).append(" ");
      }
      sb.append("\n");
      return;
    }

    for(int i=cur;i<N;i++) {
      result[depth] = i+1;
      dfs(depth+1, i+1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    result = new int[M];

    dfs(0, 0);
    System.out.println(sb);
  }

}