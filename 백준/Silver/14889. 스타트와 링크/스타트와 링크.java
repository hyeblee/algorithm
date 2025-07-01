import java.util.*;
import java.io.*;


public class Main {

  // n 추가 -> Sin + Sni 더해야함 (i는 A팀의 원소들)
  public static int n;
  public static int[][] arr;
  public static boolean[] isStart;
  public static int min = Integer.MAX_VALUE;

  public static void combi(int idx, int count) {
    if (count == n / 2) {
      diff();
      return;
    }

    for (int i = idx; i < n; i++) {
      isStart[i] = true;
      combi(i + 1, count + 1);
      isStart[i] = false;
    }
  }

  public static void diff() {
    int start = 0;
    int link = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (isStart[i] && isStart[j]) {
          start += arr[i][j];
        } else if (!isStart[i] && !isStart[j]) {
          link += arr[i][j];
        }
      }
    }

    int diff = Math.abs(start - link);
    min = Math.min(diff, min);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    arr = new int[n][n];
    isStart = new boolean[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) { // j가 항상 i보다 크다.
        arr[i][j] += arr[j][i];
      }
    }

    isStart[0] = true; // 0번째 사람은 항상 start팀
    combi(1, 1);
    System.out.println(min);

  }


}