import java.util.*;
import java.io.*;


public class Main {
    
    // 정점 n, 루트 r, 쿼리 수 q
    // 간선 정보 (n-1개) -> 트리니까 단방향으로 연결해야함.
    // 쿼리의 루트노트 q개

    public static List<Integer>[] adjList;
    public static boolean[] visited;
    public static int[] parent;
    public static int[] subtreeCnt;
    public static int n, r, q;

    // r이 루트인 트리에서 모든 정점별로 루트일 때의 서브트리의 정점 갯수를 구한다.
    public static int dfs(int start) {
        int cnt = 1; // 자기 자신
        visited[start] = true;

        for(int next: adjList[start]) {
            // 인접한 노드가 부모이거나 방문한 적 있으면 탐색하지 않는다.
            if (next == parent[start] || visited[next]) {
                continue;
            }
            cnt += dfs(next);
        }
        subtreeCnt[start] = cnt;
        return cnt;
    }

    // r을 루트로 하는 트리의 정점별 부모를 기록한다.
    public static void writeParent(int cur) {
        visited[cur] = true;
        for(int next: adjList[cur]) {
            if (visited[next]) {
                continue;
            }
            parent[next] = cur;
            writeParent(next);
        }
    }


    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("");

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        
        adjList = new ArrayList[n+1];
        for(int i=0;i<n+1;i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        parent = new int[n+1];
        subtreeCnt = new int[n+1];
       

        // 간선 연결하기
        for(int i=0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        // r을 루트로 하는 트리에서, 각 노드의 정점 기록하기
        parent[r] = r;
        writeParent(r);
        Arrays.fill(visited, false);
        dfs(r);

        // 쿼리 실행하며 결과 출력하기
        for(int i=0;i<q;i++) {
            int u = Integer.parseInt(br.readLine());
            int result = subtreeCnt[u];
            sb.append(result + "\n");
        }

        System.out.println(sb);
    
    }
}