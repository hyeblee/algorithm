import java.util.*;
import java.io.*;

public class Main {
	// 상하좌우
	public static final int[] dx = {0,0,-1,1};
	public static final int[] dy = {-1,1,0,0};
	
	public static int N,M;
	public static int max = Integer.MIN_VALUE;
	public static int[][] arr;
	public static boolean[][] visit;
	
	
	public static boolean isInRange(int row, int col) {
		return row>=0&&row<N&&col>=0&&col<M;
	}
	
	public static void solve(int row, int col, int sum, int count) {
		if(count==4) {
			max = Math.max(max, sum);
			return;
		}
		
		// 상하좌우 탐색
		for(int i=0;i<4;i++) {
			int curRow = row + dy[i];
			int curCol = col + dx[i];
			
			if(!isInRange(curRow, curCol))
				continue;
			
			if(!visit[curRow][curCol]) {
				if(count==2) {
					visit[curRow][curCol] = true;
					solve(row,col,sum+arr[curRow][curCol],count+1);
					visit[curRow][curCol] = false;
				}
				
				visit[curRow][curCol] = true;
				solve(curRow,curCol,sum+arr[curRow][curCol],count+1);
				visit[curRow][curCol] = false;
			
			}
		}
			
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visit[i][j] = true;
				solve(i,j,arr[i][j],1);
				visit[i][j] = false;
			}
		}
		
		System.out.println(max);
	}
}