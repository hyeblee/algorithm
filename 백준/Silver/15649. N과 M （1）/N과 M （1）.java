import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
  public static int N, M;
  public static int[] result;
  public static boolean[] visited;
  public static StringBuilder sb = new StringBuilder();

  public static void dfs(int depth) {
    if (depth == M) {
      for(int n: result) {
        sb.append(n + " ");
      }
      sb.append("\n");
      return;
    }

    for(int i = 0; i < N; i++) {
      if(!visited[i]) {
        visited[i] = true;
        result[depth] = i+1;
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    result = new int[M];
    visited = new boolean[N];
    dfs(0);
    System.out.println(sb.toString());
  }

}