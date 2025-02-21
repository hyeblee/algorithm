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
	public static int n;
	public static int[][] adj;
	public static int[][] result;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		adj = new int[n+1][n+1];
		result = new int[n+1][n+1];
		StringTokenizer st;
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(adj[i][j]==1) {
					result[i][j] = 1;
					continue;
				}
				
				// 경유 가능한지 판단..
				for(int k=1;k<=n;k++) {
					if(k==i || k ==j)
						continue;
					if(adj[i][k]==1&&adj[k][j]==1 || result[i][k]==1&&result[k][j]==1) {
						result[i][j] = 1;
					}
						
				}
			}
		}
		 for (int k = 1; k <=n ; k++) {
	            for (int i = 1; i <= n; i++) {
	                for (int j = 1; j <= n; j++) {
	                    // 단순히 갈 수 있는 경로가 있는지만 체크함.
	                    if (adj[i][k] == 1 && adj[k][j] == 1) {
	                    	adj[i][j] = 1;
	                    }
	                }
	            }
	        }
	
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(adj[i][j]+ " ");
			}
			System.out.println();
		}
	}
}