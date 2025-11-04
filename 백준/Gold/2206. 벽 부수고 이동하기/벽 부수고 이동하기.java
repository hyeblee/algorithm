import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int y, x, broken;
        Node(int y, int x, int broken) {
            this.y = y;
            this.x = x;
            this.broken = broken;
        }
    }

    static int n, m;
    static int[][] grid;
    static int[][][] dist;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0));
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.y == n - 1 && cur.x == m - 1) {
                return dist[cur.y][cur.x][cur.broken];
            }

            for (int dir = 0; dir < 4; dir++) {
                int ny = cur.y + dy[dir];
                int nx = cur.x + dx[dir];

                if (!inRange(ny, nx)) continue;

                // 벽이 아닌 경우 
                if (grid[ny][nx] == 0 && dist[ny][nx][cur.broken] == 0) {
                    dist[ny][nx][cur.broken] = dist[cur.y][cur.x][cur.broken] + 1;
                    q.add(new Node(ny, nx, cur.broken));
                }

                // 벽인데 아직 안 부쉈을 경우 -> 부쉇다고 node로 알리고, 부순 dist에 기록한다.
                if (grid[ny][nx] == 1 && cur.broken == 0 && dist[ny][nx][1] == 0) {
                    dist[ny][nx][1] = dist[cur.y][cur.x][cur.broken] + 1;
                    q.add(new Node(ny, nx, 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        dist = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
}
