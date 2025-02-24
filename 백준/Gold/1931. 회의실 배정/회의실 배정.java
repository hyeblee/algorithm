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
	public static int[][] meetings;
	
	public static class myComparator implements Comparator<int[]>{
		@Override
		public int compare(int[] a, int[] b) {
			if(a[1]==b[1]) { // 끝나는 시간이 같은 짧은 회의 기준으로 정렬
				return Integer.compare(a[0], b[0]);
			}
			return Integer.compare(a[1], b[1]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int cnt = 0;
		meetings = new int[n][2];
		for(int i=0;i<n;i++) {
			meetings[i][0] = sc.nextInt();
			meetings[i][1] = sc.nextInt();
		}
		
		Arrays.sort(meetings,new myComparator());
		int before = 0;
		for(int i=0;i<n;i++) {
			if(before<=meetings[i][0]) {
				cnt++;
				before = meetings[i][1];
			}
		}
		System.out.println(cnt);
	}
	
}