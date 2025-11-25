import java.util.*;
import java.io.*;


public class Main {

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int n, e;
    static int[] dist;
    static boolean[] visited;
    static int v1, v2;
    static List<List<Node>> list = new ArrayList<>();

    // 1. 1 -> v1 -> v2 -> n
    // 2. 1 -> v2 -> v1 -> n

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.to;

            while (!visited[cur]) {
                visited[cur] = true;

                for (Node n : list.get(cur)) {
                    if (!visited[n.to] && dist[n.to] > dist[cur] + n.weight) {
                        dist[n.to] = dist[cur] + n.weight;
                        pq.add(new Node(n.to, dist[n.to]));
                    }
                }
            }
        }

        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, weight));
            list.get(b).add(new Node(a, weight));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        int d1 = dijkstra(1, v1);
        int d2 = dijkstra(v1, v2);
        int d3 = dijkstra(v2, n);

        if (d1 == INF || d2 == INF || d3 == INF) {
            result1 = INF;
        } else {
            result1 = d1 + d2 + d3;
        }

        int result2 = 0;
        d1 = dijkstra(1, v2);
        d2 = dijkstra(v2, v1);
        d3 = dijkstra(v1, n);

        if (d1 == INF || d2 == INF || d3 == INF) {
            result2 = INF;
        } else {
            result2 = d1 + d2 + d3;
        }

        if (result1 == INF && result2 == INF) {
            System.out.println("-1");
        } else {
            System.out.println(Math.min(result1, result2));
        }

    }
}