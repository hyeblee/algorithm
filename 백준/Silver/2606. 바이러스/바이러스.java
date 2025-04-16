

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

  /*
   *  깊이 우선 탐색
   *  후입 선출 구조의 stack을 활용하거나 재귀호출을 이용한다.
   *  시작 노드에서 출발해 한 방향으로 갈 수 있는 ㅁ나큼 깊이 탐색한 후,
   *  더 이상 진행할 수 없을 때 이전 분기점으로 돌아가 다른 경로를 탐색하는 알고리즘이다.
   * */
  public static int node, edge;
  public static int[][] map;
  public static boolean[] visit;
  public static int count = 0;


  public static void DFS(int start) {
    visit[start] = true;
    for (int i = 1; i <= node; i++) {
      if (map[start][i] == 1 && !visit[i]) {
        DFS(i);
        count++;
      }
    }
  }


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    node = Integer.parseInt(br.readLine());
    edge = Integer.parseInt(br.readLine());
    map = new int[node + 1][node + 1];
    visit = new boolean[node + 1];
    for (int i = 0; i < edge; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      map[a][b] = 1;
      map[b][a] = 1;
    }

    DFS(1);
    System.out.println(count);
  }
}
