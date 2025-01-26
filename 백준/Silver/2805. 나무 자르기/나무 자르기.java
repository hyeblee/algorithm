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
	public static List<Integer> trees = new ArrayList<>();
	
	public static long getSum(long height) {
		long sum = 0;
		for(int tree: trees) {
			if(tree>height)
				sum += tree - height;
			
		}
		return sum;
	}
	
	public static long binarySearch(long left, long right, long target) {
		
		while(left <= right) {
			long mid = (right+left)/2;
			long sum = getSum(mid);
			if(sum>=M)
				left = mid+1;
			else
				right = mid-1;
			
		}
		return right;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreElements()) {
			int n = Integer.parseInt(st.nextToken());
			trees.add(n);
		}
		Collections.sort(trees);
		
		br.close();
		long max = trees.get(N-1);
		long result = binarySearch(0,max,M);
		System.out.println(result);
	}
}