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
	public static ArrayList<Integer>[] adjList;
	public static int n;

	public static boolean[] visit = new boolean[101];
	public static int count=0;
	
	public static int dfs(int node) {
		visit[node] = true;
		for(int a : adjList[node]) {
			if(visit[a]==false) {
				count++;
				dfs(a);
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int t = sc.nextInt();
		
		adjList = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		
		for(int i=0;i<t;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		System.out.println(dfs(1));
		
	}
}