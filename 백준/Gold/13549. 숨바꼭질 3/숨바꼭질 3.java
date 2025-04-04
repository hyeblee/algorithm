import java.io.*;
import java.util.*;

// 최단 경로는 bfs로

public class Main {
	public static int N, K;
	public static int[] result = new int[100002];

	public static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int curSecond = result[cur];
			
			int a = cur+1;
			int b = cur-1;
			int c = cur*2;
			
			if(c<=100000&&result[c]>curSecond) {
				result[c] = curSecond;
				queue.offer(c);
			}
			if(a<=100000&&result[a]>curSecond+1) {
				result[a] = curSecond+1;
				queue.offer(a);
			}
			if(b>=0&&result[b]>curSecond+1) {
				result[b] = curSecond+1;
				queue.offer(b);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(result, Integer.MAX_VALUE);
		result[N] = 0;
		bfs();
		System.out.println(result[K]);
	}
}
