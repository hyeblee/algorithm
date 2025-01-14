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
	public static int n;
	public static int[][] arr = new int[101][101];
	public static boolean[] check = new boolean[101];
	public static int result=0;
	
	public static void dfs(int node) {
		check[node] = true;
		result++;
		
		for(int i=1;i<=n;i++) {
			if(!check[i]&&arr[node][i]==1) {
				dfs(i);
			}
		}

		
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int t = sc.nextInt();

		for(int i=0;i<t;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		
		dfs(1);
		
		System.out.println(result-1);
	}
}