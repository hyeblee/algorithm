import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	public static int[] dp = new int[11];
	public static int T;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4;i<11;i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}