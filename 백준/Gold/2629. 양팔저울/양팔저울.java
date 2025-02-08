import java.util.*;
import java.io.*;

public class Main {
	public static int n; // 추의 갯수
	public static int m; // 구슬의 갯수
	public static int[] weights;
	public static int[] marbles;
	public static boolean[][] dp;
	
	// cnt는 추 사용 갯수, 추로 만든 무게
	public static void dp(int cnt, int sum) {
		if(dp[cnt][sum])
			return;
		dp[cnt][sum] = true;
		if(cnt==n)
			return;
		dp(cnt+1, sum+weights[cnt]); // 추를 오른쪽에 올려둔 경우
		dp(cnt+1, sum); // 추를 사용하지 않은 경우
		dp(cnt+1, Math.abs(sum-weights[cnt])); // 추를 왼쪽에 올려둔 경우
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		n = Integer.parseInt(br.readLine());
		weights = new int[n+1];
		dp = new boolean[31][40001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		dp(0,0);
		m = Integer.parseInt(br.readLine());
		marbles = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			marbles[i] = Integer.parseInt(st.nextToken());
			if(dp[n][marbles[i]])
				sb.append("Y ");
			else
				sb.append("N ");
		}
		
		System.out.println(sb.toString());
	}
}