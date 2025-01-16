import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	public static final int MAX_N = 100000;
	public static long[] arr = new long[MAX_N+1];
	
	public static long sum(int i, int j) {
		return arr[j]-arr[i-1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=2;i<=n;i++) {
			arr[i] = arr[i] + arr[i-1];
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			bw.write(sum(i,j)+"\n");
		}
		bw.flush();
	}
}