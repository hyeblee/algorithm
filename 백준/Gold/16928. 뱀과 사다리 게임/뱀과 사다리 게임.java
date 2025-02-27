import java.util.*;
import java.io.*;

public class Main {
	public static final int SIZE = 100;
	
	public static int N, M;
	public static int[] grid = new int[SIZE+1];
	public static boolean[] visit = new boolean[SIZE+1];
	public static int[] result = new int[SIZE+1];
	public static Queue<Integer> queue = new ArrayDeque<>();
	
	public static boolean isInRange(int n) {
		return n>=1&&n<=100;
	}
	
	public static void bfs() {
		queue.offer(1);
		visit[1] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(grid[cur]==100)
				return;
			for(int i=1;i<=6;i++) {
				int pos = grid[cur]+i;
				if(isInRange(pos)&&!visit[pos]) {
					queue.offer(pos);
					visit[pos] = true;
					visit[grid[pos]] = true;
					result[pos] = result[cur]+1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1;i<=100;i++) {
			grid[i] = i;
		}
		
		for(int i=0;i<N+M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			grid[a] = b;
		}
		
		bfs();
		
		System.out.println(result[100]);
	}
}