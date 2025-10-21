import java.util.*;
import java.io.*;

public class Main {

  // 정점 n개를 모두 연결하면서, 사이클이 없으려면 최소 n-1개의 간선이 필요하다.
  // 정점 n개가 연결가능하다면, 간선은 n-1개만 있으면 된다.
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      for (int i = 0; i < m; i++) {
        br.readLine();
      }
      System.out.println(n - 1);
    }
  }

}
