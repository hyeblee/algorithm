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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static int N,M;
	public static char[][] grid;
	public static boolean[][] visit;
	public static int cnt = 0;
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	
	public static boolean isValid(int x, int y) {
		return (x>=0&&x<M&&y>=0&&y<N);
	}
	public static void dfs(int curX, int curY) {
		if(grid[curY][curX]=='P')
			cnt++;
		visit[curY][curX] = true;
		for(int i=0;i<4;i++) {
			int x = curX + dx[i];
			int y = curY + dy[i];
			if(!isValid(x,y))
				continue;
			if(!visit[y][x]&&grid[y][x]!='X')
				dfs(x,y);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new char[N][M];
		visit = new boolean[N][M];
		int curX=0,curY=0;
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				grid[i][j] = str.charAt(j);
				if(grid[i][j]=='I') {
					curX = j;
					curY = i;
				}
			}
		}
		dfs(curX,curY);
		if(cnt==0)
			System.out.println("TT");
		else		
			System.out.println(cnt);
	}
}