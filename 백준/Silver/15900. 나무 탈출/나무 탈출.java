import java.util.*;
import java.io.*;

public class Main {

	// 특정 리프노드에서, 루트까지의 거리가 홀수이면 된다.
	// 마지막 게임 말을 루트로 옮긴 사람이 승자가 된다 
	// -> depth 합이 홀수면 처음 시작한 사람이 승자가 된다.

	static int n;
	static int[] depths;
	static boolean[] visited;
	static List<Integer>[] adj;

	// 리프 노드에 대해서만 depth를 기록해야 한다.
	static void dfs(int start, int depth) {
		visited[start] = true;
		
		boolean isLeaf = true;
		for(int next: adj[start]) {
			if (visited[next]) {
				continue;
			}
			isLeaf = false;
			dfs(next, depth + 1);
		}

		if (isLeaf) {
			depths[start] = depth;
		}
	}

	static int getTotalDepth() {
		int sum = 0;
		for(int i=1;i<=n;i++) {
			sum += depths[i];
		}

		return sum;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		depths = new int[n+1];
		visited = new boolean[n+1];
		adj = new ArrayList[n+1];
		for(int i=0;i<n+1;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}

		dfs(1, 0);
		
		int depthSum = getTotalDepth();
		if (depthSum % 2 == 0) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	
	}

}
