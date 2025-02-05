import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static int N, M;
	public static int[][] maze;
	public static boolean[][] visit;
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1, 0,0};
	
	public static boolean isValid(int nx, int ny) {
		return nx>=0&&nx<M&&ny>=0&&ny<N;
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0,0});
		maze[0][0] = 1;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			visit[cur[1]][cur[0]] = true;
			if(cur[0]==M-1&&cur[1]==N-1)
				break;
			for(int i=0;i<4;i++) {
				int nx = cur[0]+dx[i];
				int ny = cur[1]+dy[i];
				if(isValid(nx,ny)&&maze[ny][nx]==1&&!visit[ny][nx]) {
					queue.offer(new int[] {nx, ny});
					maze[ny][nx] = maze[cur[1]][cur[0]]+1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String cmd = br.readLine();
			for(int j=0;j<M;j++) {
				maze[i][j] = cmd.charAt(j)-'0';
			}
		}
		
		bfs();
		System.out.println(maze[N-1][M-1]);
	}
}