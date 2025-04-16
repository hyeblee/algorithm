import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static int N;
  public static Meeting[] meetings;

  public static class Meeting implements Comparable<Meeting> {

    int s;
    int e;

    public Meeting(int s, int e) {
      this.s = s;
      this.e = e;
    }

    @Override
    public int compareTo(Meeting o) { // 끝나는 시간이 빠른 순(작은 순)으로 정렬
      // 만약 끝나는 시간이 같다면, 시작하는 시간이 빠른순으로 정렬,,
      if (this.e == o.e) {
        return this.s - o.s;
      }
      return this.e - o.e;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    meetings = new Meeting[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      meetings[i] = new Meeting(s, e);
    }
    Arrays.sort(meetings);
    int count = 1;
    Meeting cur = meetings[0];
    for (int i = 1; i < N; i++) {
      if (meetings[i].s >= cur.e) {
        cur = meetings[i];
        count++;
      }
    }

    System.out.println(count);

  }
}