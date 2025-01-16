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
	public static final int MAX_N = 1000;
	public static long[] dp = new long[MAX_N+1];
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=n;i++) {
			dp[i] = (dp[i-1]+dp[i-2]) % 10007;
		}
		System.out.println(dp[n]);
	}
}