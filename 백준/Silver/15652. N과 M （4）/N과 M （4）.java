import java.io.*;
import java.util.*;

// 최단 경로는 bfs로

public class Main {
	public static int N, M;
	public static int[] nums;
	public static StringBuilder result = new StringBuilder("");
	
	public static void dfs(int depth, String str, int before) {
		if(depth == M) {
			result.append(str+"\n");
			return;
		}
		for(int i=1;i<=N;i++) {
			if(before<=i)
				dfs(depth+1,str+i+" ", i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dfs(0,"",0);
		System.out.println(result);
	}
}
