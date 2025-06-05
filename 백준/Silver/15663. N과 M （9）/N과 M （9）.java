import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
  public static int n, m;
  public static int[] arr;
  public static int[] result;
  public static boolean[] visited;
  public static StringBuilder sb = new StringBuilder("");

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n];
    result = new int[m];
    visited = new boolean[n];
    
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr); // 배열 정렬하고 시작하면 사전순 선택 가능
    DFS(0);
    System.out.println(sb.toString());

  
  }

  public static void DFS(int cnt) {
    if (cnt == m) {
      for(int i=0;i<m;i++) {
        sb.append(result[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    int cur = 0; // 한 깊이(cnt)에서 동일한 숫자로 시작되는 분기를 하나만 허용한다.
    for(int i=0;i<n;i++) {
     if (visited[i])
       continue;
     if (cur != arr[i]) {
       visited[i] = true;
       result[cnt] = arr[i];
       cur = arr[i];
       DFS(cnt+1);
       visited[i] = false;
     }
    }


  }

}