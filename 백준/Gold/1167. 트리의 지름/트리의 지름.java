import java.util.*;
import java.io.*;


public class Main {
    // 트리의 지름 구하기
    // 1. 임의의 정점에서 제일 멀리 떨어진 정점 x 찾는다
    // 2. x와 제일 멀리 떨어진 정점까지의 거리가 트리의 지름이다.

    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int v;
    public static List<Edge>[] adjList;
    public static boolean[] visited;
    public static int furthestVertex = 1;
    public static int furthestDistance = 0;


    // start에서 출발하여 제일 먼 정점과 거리 갱신하기
    public static void dfs(int start, int distance) {
        visited[start] = true;

        for(Edge next: adjList[start]) {
            int to = next.to;
            int weight = next.weight;

            if (visited[to]) {
                continue;
            }

            // 만약 지금 정점까지의 거리가 최장거리보다 크면 furthestVertex와 furthestDistance 갱신
            if (distance + weight > furthestDistance) {
                furthestVertex = to;
                furthestDistance = distance + weight;
            }

            dfs(to, distance + weight);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        v = Integer.parseInt(br.readLine());
        adjList = new ArrayList[v+1];
        for(int i=0;i<v+1;i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[v+1];

        // 간선 연결하여 트리 완성하기
        for(int i=0;i<v;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            
            while(true) {
                int to = Integer.parseInt(st.nextToken());
                
                if (to == -1)  
                    break;
                
                int weight = Integer.parseInt(st.nextToken());

                adjList[start].add(new Edge(to, weight));
            }
        }

        // dfs로 트리 탐색하여 제일 먼 정점 x구하기
        dfs(1, 0);
        int x = furthestVertex;

        // x에서 다시 dfs 탐색하여 제일 먼 거리 구하기
        Arrays.fill(visited, false);
        furthestVertex = x;
        furthestDistance = 0;
        dfs(x, 0);

        System.out.println(furthestDistance);
        
    }

}