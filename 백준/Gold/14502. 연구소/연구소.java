import java.util.*;
import java.io.*;

public class Main {

  public static class Node {

    int y, x;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  public static final int[] dy = {-1, 0, 1, 0};
  public static final int[] dx = {0, 1, 0, -1};

  public static int n, m;
  public static int[][] grid;
  public static int[][] tmp;
  public static boolean[][] visited;
  public static List<Node> viruses = new ArrayList<>();
  public static int max = 0;

  // 0인 칸 3곳 선택하기
  public static void buildWall(int depth) {
    if (depth == 3) { // 벽 3곳 다 세우면
      // 바이러스 퍼뜨리기
      spreadVirus();
//      for(int i=0;i<n;i++) {
//        for(int j=0;j<m;j++) {
//          System.out.print(grid[i][j] + " ");
//        }
//        System.out.println();
//      }
//      System.out.println("==============\n\n");
      // 안전 영역 세기
      max = Math.max(getSafeArea(), max);
      return;
    }

    // 벽 세울 수 있는 곳 정해서 다음벽 세우기로 넘어가기
    for (int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if (grid[i][j] == 0) {
          grid[i][j] = 1; // 벽세우기
//          System.out.print(i+", " + j + " -- ");
          buildWall(depth + 1);
          grid[i][j] = 0; // 원래대로 돌리기
        }
      }
    }
  }

  // 바이러스 퍼뜨리기
  public static void spreadVirus() {
    visited = new boolean[n][m];
    for(int i=0;i<n;i++) {
      for(int j=0;j<m;j++) {
        tmp[i][j] = grid[i][j];
      }
    }

    for(int i=0;i<viruses.size();i++) {
      int y = viruses.get(i).y;
      int x = viruses.get(i).x;
      if (!visited[y][x]) {
        dfs(y, x);
      }
    }
  }

  // 2인 영역 확장하기
  public static void dfs(int y, int x) {
    visited[y][x] = true;
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      if (!inRange(ny, nx)) {
        continue;
      }
      if (tmp[ny][nx] != 1 && !visited[ny][nx]) { // 벽이 아니면 탐색 진행 가능
        tmp[ny][nx] = 2;
        dfs(ny, nx);
      }
    }
  }

  public static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }

  // 안전 영역 세기
  public static int getSafeArea() {
    int safeArea = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (tmp[i][j] == 0) {
          safeArea++;
        }
      }
    }

    return safeArea;
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    grid = new int[n][m];
    tmp = new int[n][m];
    visited = new boolean[n][m];

    for(int i=0;i<n;i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0;j<m;j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
        if (grid[i][j] == 2) {
          viruses.add(new Node(i, j));
        }
      }
    }

    buildWall(0);

    System.out.println(max);
  }

}