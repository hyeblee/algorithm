import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	public static final int MAX_N = 100;
	public static int T;
	public static long[] result = new long[MAX_N+1];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		result[1] = result[2] = result[3] = 1;
		
		for(int i=4;i<=100;i++) {
			result[i] = result[i-3]+result[i-2];
		}
		
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			System.out.println(result[n]);
		}
	
	}
}