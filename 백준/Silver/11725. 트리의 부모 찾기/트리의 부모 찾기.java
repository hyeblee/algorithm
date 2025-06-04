import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;


public class Main {

  public static int n;
  public static List<Integer>[] graph;
  public static int[] visited;

  public static void DFS(int n) {
    for (int next : graph[n]) {
      if (visited[next] == 0) {
        visited[next] = n;
        DFS(next);
      }
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new List[n + 1];
    visited = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      // 무방향 그래프니까 우선 둘 다 연결
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    // 빠른 탐색은 DFS
    visited[1] = 1;
    DFS(1);
    for (int i = 2; i <= n; i++) {
      System.out.println(visited[i]);
    }
  }

}