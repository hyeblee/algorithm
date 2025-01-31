import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static int N, M;
	public static int[] trees;
	
	public static long getSum(int height) {
		long sum = 0;
		for(int tree: trees) {
			if(tree > height)
				sum += tree-height;
		}
		return sum;
	}
	
	public static int binarySearch(int target) {
		int left = 0;
		int right = trees[N-1];
		
		while(left <= right) {
			int mid = (int)((long)left + (long)right)/2;
			long result = getSum(mid);
			if(result >= target) {
				left = mid + 1;
			}
			else // 나무 합이 목표가 안되면 절단기 높이 줄이기
				right = mid - 1;
		}
		
		return right;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trees = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(trees);
		System.out.println(binarySearch(M));
		
	}
}