import java.io.*;
import java.util.*;

public class Main {

    static int N, M, MAX_LOG = 17; // 2^17 = 131072 > 100000
    static List<Integer>[] adj;
    static int[][] parent;
    static int[] depth;
    static boolean[] visited;

    public static void dfs(int cur, int d) {
        visited[cur] = true;
        depth[cur] = d;

        for (int next : adj[cur]) {
            if (!visited[next]) {
                parent[next][0] = cur; // 2^0 번째 조상 = 바로 위 부모
                dfs(next, d + 1);
            }
        }
    }

    public static void fillParents() {
        // parent[i][k] = parent[parent[i][k-1]][k-1]
        for (int k = 1; k <= MAX_LOG; k++) {
            for (int v = 1; v <= N; v++) {
                parent[v][k] = parent[parent[v][k - 1]][k - 1];
            }
        }
    }

    public static int lca(int a, int b) {
        // 1️⃣ 깊이 맞추기
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // a를 b의 깊이까지 끌어올리기
        for (int k = MAX_LOG; k >= 0; k--) {
            if (depth[a] - (1 << k) >= depth[b]) {
                a = parent[a][k];
            }
        }

        // 같으면 바로 반환
        if (a == b) return a;

        // 2️⃣ 조상 다를 때까지 동시에 올리기
        for (int k = MAX_LOG; k >= 0; k--) {
            if (parent[a][k] != parent[b][k]) {
                a = parent[a][k];
                b = parent[b][k];
            }
        }

        // 3️⃣ 바로 위 부모가 LCA
        return parent[a][0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        parent = new int[N + 1][MAX_LOG + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(1, 0);        // 1번을 루트로 DFS
        fillParents();    // 희소 테이블 채우기

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append('\n');
        }

        System.out.print(sb);
    }
}
