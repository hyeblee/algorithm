import java.util.*;
import java.io.*;

public class Main {
	// 상 하 좌 우
	public static final int[] dx = {0,0,-1,1};
	public static final int[] dy = {-1,1,0,0};
	
	
	public static int N;
	public static char[][] grid;
	public static char[][] colorGrid;
	public static boolean visit[][];
	public static boolean colorVisit[][];
	
	public static boolean isValid(int y, int x) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	
	public static void dfs(int curY, int curX) {
		visit[curY][curX] = true;
		char cur = grid[curY][curX];
		for(int i=0;i<4;i++) {
			int x = curX + dx[i];
			int y = curY + dy[i];
			if(isValid(y,x)&&!visit[y][x]&&cur==grid[y][x]) {
				dfs(y,x);
			}
		}
	}
	
	public static void colorDfs(int curY, int curX) {
		colorVisit[curY][curX] = true;
		char cur = colorGrid[curY][curX];
		for(int i=0;i<4;i++) {
			int x = curX + dx[i];
			int y = curY + dy[i];
			if(isValid(y,x)&&!colorVisit[y][x]&&cur==colorGrid[y][x]) {
				colorDfs(y,x);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		colorGrid = new char[N][N];
		visit = new boolean[N][N];
		colorVisit = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<N;j++) {
				grid[i][j] = input.charAt(j);
				colorGrid[i][j] = grid[i][j];
				if(colorGrid[i][j]=='R')
					colorGrid[i][j] = 'G';
			}
		}
		
		int cnt = 0;
		int colorCnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					dfs(i,j);
					cnt++;
				}
				if(!colorVisit[i][j]) {
					colorDfs(i,j);
					colorCnt++;
				}
			}
		}
		System.out.println(cnt+" "+colorCnt);
	}
}