import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

  static int N, M;
  static int[] arr, printArr;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    arr = new int[N];
    printArr = new int[M];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);

    dfs(0,0);
    System.out.println(sb);
  }

  private static void dfs(int start, int depth) {
    if(depth == M) {
      for(int i=0;i<M;i++){
        sb.append(printArr[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    int before = -1;
    for(int i = start; i < N; i++) {
      int now = arr[i];
      if (before != now) { // 전이랑 같은 숫자가 아니면 dfs 탐색 가능
        before = now;
        printArr[depth] = arr[i];
        dfs(i, depth + 1); // 현재 인덱스 또 넣어도 됨
      }
    }
  }


}