import java.util.*;
import java.io.*;


public class Main {
    // 노드 갯수 n
    // 노드별 부모정도 n개
    // 루트는 1, 그 외는 부모 노드
    // 리프노드 개수 출력 (서브트리 사이즈 0인 친구들!)

    public static int n;
    public static boolean[] visited;
    public static List<Integer>[] adjList;
    public static int removedNode = 1;
    public static int[] subtree;
    public static int root = 0;
    public static int result = 0;

    // 루트노드에서 탐색 시작하여 모든 서브트리의 사이즈를 기록한다.
    // removedNode와 하위 노드는 탐색하지 않는다.
    public static int dfs(int start) {
        visited[start] = true;
        int currentSize = 1; // 서브트리에 자식 없고 나만 있으면 사이즈 1
        
        for(int next: adjList[start]) {
            // 방문한 친구는 탐색하지 않는다.
            if (visited[next]) {
                continue;
            }

            currentSize += dfs(next);
        }

        subtree[start] = currentSize;
        if (currentSize == 1) {
            result++;
        }
        return currentSize;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        adjList = new ArrayList[n+1];
        for(int i=0;i<n+1;i++) {
            adjList[i] = new ArrayList<>();
        }
        subtree = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                continue; // 루트노드의 부모는 기록하지 않는다.
            }
            adjList[parent].add(i); // 부모에만 연결 (부모 -> 자식 방향으로 탐색해야 하므로)
        }

        removedNode = Integer.parseInt(br.readLine());
        visited[removedNode] = true;

        // 루트노드에서 시작하여 모든 서브트리 사이즈를 배열에 기록한다.
        // 루트노드가 removedNode면 탐색하지 않는다.
        if (!visited[root])
            dfs(root);

        System.out.println(result);
    }

}