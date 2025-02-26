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
	// 좌 우 상 하
	public static final int[] dx = {-1,1,0,0};
	public static final int[] dy = {0,0,1,-1};
	
	public static int N,M;
	public static int[][] box;
	public static Queue<int[]> queue = new LinkedList<>();
	
	public static int isRipe() {
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(box[i][j]==0)
					return 0;
				max = Integer.max(max,box[i][j]);
			}
		}
		return max;
	}
	
	public static boolean isValid(int x, int y) {
		return x>=0&&x<M&&y>=0&&y<N;
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int n = cur[0];
			int m = cur[1];
			for(int i=0;i<4;i++) {
				int y = n+dy[i];
				int x = m+dx[i];
				if(isValid(x,y)&&box[y][x]==0) {
					box[y][x] = box[n][m]+1;
					queue.offer(new int[] {y,x});
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]==1) {
					queue.offer(new int[] {i,j});
				}
			}
		}
		
		bfs();
		System.out.println(isRipe()-1);
		
	}
}