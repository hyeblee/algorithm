import java.util.*;
import java.io.*;

public class Main {
  // LCA(Least Common Ancestor): 최소 공통 조상
  // 트리에서 a, b의 가장 가까운 공통 조상을 찾는다.
  // 1. DFS로 모든 정점의 부모와 depth 기록하기
  // 2. depthA <= depthB 일때까지 depthA 올리기
  // 3. depthB <= depthA 일때까지 depthB 올리기
  // 4. A의 원소와 B의 원소가 같을때까지 둘 다 올리기

  public static int T, N;
  public static List<Integer>[] adjList;
  public static int[] parent, depth;
  public static boolean[] visited;

  public static int getLCA(int a, int b) {
    int depthA = depth[a];
    int depthB = depth[b];

    // 1. a 올리기
    while (depthA > depthB) {
      a = parent[a];
      depthA = depth[a];
    }

    // 2. b 올리기
    while(depthB > depthA) {
      b = parent[b];
      depthB = depth[b];
    }

    // 3. 둘이 같아질때까지 올리기
    while (a != b && parent[a] != 0) {
      if (parent[a] == 0) {
        break;
      }
      a = parent[a];
      b = parent[b];
    }

    return b;
  }

  public static int getRoot() {
    int root = 1;
    for (root = 1; root <= N; root++) {
      if (parent[root] == 0) {
        break;
      }
    }
    return root;
  }

  public static void writeDepth(int root, int d) {
    depth[root] = d;
    visited[root] = true;
    for (int next : adjList[root]) {
      if (!visited[next]) {
        writeDepth(next, d + 1);
      }
    }
  }
//  public static
//  public static
//  public static
//  public static
//  public static


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      N = Integer.parseInt(br.readLine());

      adjList = new ArrayList[N + 1];
      for (int i = 0; i < N + 1; i++) {
        adjList[i] = new ArrayList<>();
      }
      parent = new int[N + 1];
      depth = new int[N + 1];
      visited = new boolean[N + 1];

      for (int i = 0; i < N - 1; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        adjList[u].add(v);
        parent[v] = u;
      }
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      int root = getRoot();
      writeDepth(root, 0);

      System.out.println(getLCA(a, b));

    }
  }
}
