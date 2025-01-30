import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        String[][] campus = new String[n][m];

        int targetX = 0;
        int targetY = 0;

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                campus[i][j] = line[j];
                if (campus[i][j].equals("I")) {
                    targetX = i;
                    targetY = j;
                }
            }
        }

        System.out.println(bfs(campus, n, m, targetX, targetY));

        br.close();
    }

    private static String bfs(String[][] maze, int n, int m, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{targetX,targetY});

        boolean[][] isVisited = new boolean[n][m];
        isVisited[targetX][targetY] = true;

        int res = 0;

        while (!queue.isEmpty()) {
            int[] step = queue.poll();
            int x = step[0];
            int y = step[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maze[nx][ny].equals("X")) {
                    continue;
                }

                if(isVisited[nx][ny])
                    continue;

                if (maze[nx][ny].equals("P")) {
                    res++;
                }

                queue.offer(new int[]{nx, ny});
                isVisited[nx][ny] = true;
            }
        }

        if (res == 0) {
            return "TT";
        } else return String.valueOf(res);
    }
}
