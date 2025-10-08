import java.util.*;
import java.io.*;

public class Main {

  // 트리의 지름을 구하는 방법은 다음과 같다.
  // 1. 임의의 정점에서 제일 멀리 떨어진 정점 x를 구한다.
  // 2. x에서 제일 멀리 떨어진 정점까지의 거리가 트리의 지름 r이다.

  public static class Edge {

    int to;
    int weight;

    public Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  public static int n, furthestVertext, furthestDistance;
  public static ArrayList<Edge>[] edges;
  public static int[] dist; // start에서 떨어진 거리 기록하는 배열
  public static boolean[] visited;

  // start에서 떨어진 거리를 dist에 저장한다.
  // start에서 제일 멀리 떨어진 정점과 그 거리를 furthestVertext와 furthestDistance에 저장한다.
  public static void dfs(int start, int totalDistance) {
    visited[start] = true;

    for (int i = 0; i < edges[start].size(); i++) {
      int to = edges[start].get(i).to;
      int weight = edges[start].get(i).weight;

      if (visited[to]) { // 방문한 정점은 탐색하지 않는다.
        continue;
      }

      dist[to] = totalDistance + weight;
      if (dist[to] > furthestDistance) {
        furthestDistance = dist[to];
        furthestVertext = to;
      }
      dfs(to, totalDistance + weight);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    edges = new ArrayList[n+1];
    for(int i=0;i<n+1;i++) {
      edges[i] = new ArrayList<>();
    }
    dist = new int[n+1];
    visited = new boolean[n+1];

    for(int i=0;i<n-1;i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      edges[a].add(new Edge(b, weight));
      edges[b].add(new Edge(a, weight));
    }

    dfs(1,0);

    Arrays.fill(dist, 0);
    Arrays.fill(visited, false);
    dfs(furthestVertext, 0);

    System.out.println(furthestDistance);
  }

}