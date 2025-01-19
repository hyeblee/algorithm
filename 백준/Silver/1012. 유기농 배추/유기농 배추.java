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
	public static final int MAX_N = 50;
	public static final int MAX_M = 50;
	public static int t,m,n,k;
	public static int[][] grid = new int[MAX_N][MAX_M];
	public static boolean[][] visit = new boolean[MAX_N][MAX_M];
	public static int cnt = 0;
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	
	public static boolean isNotValid(int nx, int ny) {
		return (nx<0||nx>=m||ny<0||ny>=n);
	}
	
	public static void dfs(int x, int y) {
		visit[y][x] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(isNotValid(nx,ny))
				continue;
			if(grid[ny][nx]==1 && visit[ny][nx]==false) {
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		
		for (int l = 0; l < t; l++) {
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			for(int i=0;i<MAX_N;i++) {
				Arrays.fill(grid[i], 0);
				Arrays.fill(visit[i], false);
			}
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				grid[y][x] = 1;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (grid[i][j] == 1 && visit[i][j]==false) {
						dfs(j, i);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}