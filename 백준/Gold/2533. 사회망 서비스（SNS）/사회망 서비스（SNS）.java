import java.util.*;
import java.io.*;

public class Main {

  // 정점개수 N
  // N-1개의 간선 정보
  // 부모가 얼리어답터면, 자식은 아니어도 됨
  // 부모가 얼리어답터아니면, 자식은 무조건이어야함.

  public static int n;
  public static boolean[] visited;
  public static List<Integer>[] graph;
  public static int[][] dp;

  public static void dfs(int depth) {
    visited[depth] = true;
    dp[depth][0] = 0;
    dp[depth][1] = 1;

    for (int child : graph[depth]) {
      if (visited[child]) {
        continue;
      }

      dfs(child);
      dp[depth][0] += dp[child][1];
      dp[depth][1] += Math.min(dp[child][0], dp[child][1]);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    dp = new int[n + 1][2];
    visited = new boolean[n + 1];
    graph = new ArrayList[n + 1];
    for (int i = 0; i < n + 1; i++) {
      graph[i] = new ArrayList<>();
    }

    StringTokenizer st;
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u].add(v);
      graph[v].add(u);
    }

    dfs(1);
    System.out.println(Math.min(dp[1][1], dp[1][0]));
  }
}
