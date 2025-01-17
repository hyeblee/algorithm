import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	public static final int MAX_N = 50000;
	public static long[] dp = new long[MAX_N+1];
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 1;
 		for(int i=5;i<=n;i++) {
 			dp[i] = 5;
			for(int j=1;j<=Math.sqrt(i);j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		System.out.println(dp[n]);
	}
}