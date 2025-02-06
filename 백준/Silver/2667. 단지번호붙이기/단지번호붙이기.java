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
	public static int N;
	public static int[][] map;
	public static boolean [][] visit;
	public static int[] houses;
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	
	public static boolean isValid(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	
	public static void dfs(int x, int y, int number) {
		visit[y][x] = true;
		map[y][x] = number;
		houses[number]++;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(isValid(nx,ny)&&!visit[ny][nx]&&map[ny][nx]==1) {
				dfs(nx,ny,number);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		houses = new int[N*N+1];
		for(int i=0;i<N;i++) {
			String cmd = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = cmd.charAt(j)-'0';
			}
		}
		
		int count = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]&&map[i][j]==1) {
					dfs(j,i,++count);
				}
			}
		}
		
		System.out.println(count);
		Arrays.sort(houses);
		for(int house:houses) {
			if(house==0)
				continue;
			System.out.println(house);
		}
	}
}