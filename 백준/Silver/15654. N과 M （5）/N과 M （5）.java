import java.io.*;
import java.util.*;

public class Main {
  public final static int MAX_SIZE = 8;

  public static int N, M;
  public static int[] nums = new int[MAX_SIZE];
  public static boolean[] visited = new boolean[MAX_SIZE];
  public static StringBuilder result = new StringBuilder("");

  public static void dfs(int depth, String str) {
    if(depth==M) {
      result.append(str+"\n");
    }
    for(int i=0;i<N;i++) {
      if(!visited[i]) {
        visited[i] = true;
        dfs(depth+1, str+nums[i]+" ");
        visited[i] = false;
      }
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    nums = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(nums);
    dfs(0, "");
    System.out.println(result);
  }
}
