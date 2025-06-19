import java.io.*;
import java.util.*;

public class Main {

  public static int N, M;
  public static int[] dist;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Node>> adjList;

  public static class Node implements Comparable<Node> {

    int value;
    int weight;

    public Node(int next, int weight) {
      this.value = next;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return weight - o.weight;
    }
  }

  private static void dijkstra(int start, int end) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0)); // 시작 지점 추가

    while (!pq.isEmpty()) {
      Node curNode = pq.poll();
      int curValue = curNode.value;
      if (visited[curNode.value]) {
        continue;
      }
      visited[curNode.value] = true;
      for (Node neighbor : adjList.get(curValue)) {
        if (dist[neighbor.value] > dist[curValue] + neighbor.weight) {
          dist[neighbor.value] = dist[curValue] + neighbor.weight;
          pq.offer(new Node(neighbor.value, dist[neighbor.value]));
        }
      }

    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine()); // 도시의 수
    M = Integer.parseInt(br.readLine()); // 버스의 수
    adjList = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      adjList.add(new ArrayList<>());
    }
    dist = new int[N + 1];
    visited = new boolean[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE); // 거리 저장배열 무한대로 초기화

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      // 간선 저장하기
      adjList.get(a).add(new Node(b, weight));
    }

    st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    dist[start] = 0;
    dijkstra(start, end);

    System.out.println(dist[end]);


  }


}