import java.util.*;
import java.io.*;

public class Main {

    public static int n, m;
    public static boolean[] visited;
    public static List<Integer>[] link;    
    public static int result = 0;

    public static void dfs(int start, int depth) {
        if (depth == 4) { // e까지 탐색이 4번째 호출이므로
            result = 1;
            return;
        }

        visited[start] = true;
        for(int next: link[start]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[start] = false; // start에서 dfs해보고 안되면 원래대로 돌리기
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n];
        link = new ArrayList[n];
        for(int i=0;i<n;i++) {
            link[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            link[u].add(v);
            link[v].add(u);
        }

        for (int i=0;i<n;i++) {
            dfs(i, 0);
            if (result == 1)
                break;
        }

        System.out.println(result);
    }

}