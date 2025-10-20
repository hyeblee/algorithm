import java.util.*;

public class Main {

  // T
  // 국가 수 N, 비행기 종류 M
  // a,b 쌍 M 개
  // 모든 정점을 잇는 간선 조합 찾기~


  public static int t;
  public static int n, m;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      n = sc.nextInt();
      m = sc.nextInt();

      for (int j = 0; j < m; j++) {
        sc.nextInt();
        sc.nextInt();
      }

      // 연결그래프에서 모든 정점을 잇는 최소 간선의 수는 항상 n-1개이다.
      System.out.println(n - 1);

    }
  }
}
