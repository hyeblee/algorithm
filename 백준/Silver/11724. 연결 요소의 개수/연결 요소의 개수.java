import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static int N, M;
	public static int[][] graph;
	public static boolean[] visit;
	
	public static void dfs(int u) {
		visit[u] = true;
		for(int i=1;i<=N;i++) {
			if(graph[u][i]==1&&!visit[i]) {
				visit[i] = true;
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u][v] = 1;
			graph[v][u] = 1;
		}
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			if(!visit[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}