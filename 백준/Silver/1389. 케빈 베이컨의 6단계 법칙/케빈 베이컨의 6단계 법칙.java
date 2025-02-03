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
	public static final int INF = Integer.MAX_VALUE;
	public static int N, M;
	public static int[][] dist;
	public static int[] kevinBacon;

	public static void floydWarshall() {
		for (int i = 1; i <= N; i++) { // 경유 지점
			for (int j = 1; j <= N; j++) { // 시작 지점
				for (int k = 1; k <= N; k++) { // 출발 지점
					// 중간 지점까지의 거리가 무한대가 아니라면
					if (dist[i][j] != INF && dist[i][k] != INF) {
						dist[j][k] = Math.min(dist[j][k], dist[i][j] + dist[i][k]);
					}
				}
			}

		}
	}

	public static void getKevinBacon() {
		for (int i = 1; i <= N; i++) {
			kevinBacon[i] = Arrays.stream(dist[i]).sum();
		}
	}

	public static int findMin() {
		int minPerson = 1;
		for (int i = 1; i <= N; i++) {
			if (kevinBacon[i] < kevinBacon[minPerson])
				minPerson = i;
		}
		return minPerson;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dist = new int[N + 1][N + 1];
		kevinBacon = new int[N + 1];

		// dist 배열 초기화
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dist[i][j] = INF;
				if (i == j)
					dist[i][j] = 0;
			}
		}

		// 친구 관계인 사람들 거리 1로 연결
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			dist[u][v] = 1;
			dist[v][u] = 1;
		}

		floydWarshall();
		getKevinBacon();
		System.out.println(findMin());
	}
}