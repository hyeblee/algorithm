import java.io.*;
import java.util.*;

public class Main {

  public static int n, m;
  public static List<List<Integer>> adjList; // 인접리스트
  public static Queue<Integer> q = new ArrayDeque<>();
  public static int[] inDegree; // 진입차수 저장하는 배열
  public static List<Integer> result = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    adjList = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adjList.add(new ArrayList<>());
    }

    inDegree = new int[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adjList.get(a).add(b);
      inDegree[b]++;
    }

    for (int i = 1; i <= n; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int cur = q.poll();
      result.add(cur);
      for (int next : adjList.get(cur)) {
        inDegree[next]--;
        if (inDegree[next] == 0) {
          q.add(next);
        }
      }
    }

   for(int v: result) {
     System.out.print(v + " ");
   }
  }
}
