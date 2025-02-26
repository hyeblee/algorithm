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
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static final int[] dx = {-1,0,0,1,0,0};
	public static final int[] dy = {0,1,0,0,-1,0};
	public static final int[] dz = {0,0,-1,0,0,1};
	
	public static int N,M,H;
	public static int[][][] box;	
	public static boolean[][][] visit;
	public static Queue<int[]> queue = new LinkedList<>();
	public static int day = 0;
	
	public static int isRipe() {
		int day = Integer.MIN_VALUE;
		for(int i=0;i<H;i++) {
			for(int j=0;j<M;j++) {
				for(int k=0;k<N;k++) {
					if(box[i][j][k]==0)
						return 0;
					day = Integer.max(day, box[i][j][k]);
				}
			}
		}
		return day;
	}
	
	public static boolean isValid(int x, int y, int z) {
		return x>=0&&x<N&&y>=0&&y<M&&z>=0&&z<H;
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int h = cur[0];
			int m = cur[1];
			int n = cur[2];
			
			visit[h][m][n] = true;
			
			
			for(int i=0;i<6;i++) {
				int x = n + dx[i];
				int y = m + dy[i];
				int z = h + dz[i];
				if(isValid(x,y,z)&&box[z][y][x]==0) {
					box[z][y][x]=box[h][m][n]+1;
					queue.offer(new int[] {z,y,x});
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][M][N];
		visit = new boolean[H][M][N];
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<M;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k]==1) {
						queue.offer(new int[] {i,j,k});
					}
				}
			}
		}
		bfs();
		System.out.println(isRipe()-1);
	}
}