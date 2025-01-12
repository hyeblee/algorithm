import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main{
	public static int[][] result = new int[41][41];
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		result[0][0] = 1;
		result[1][1] = 1;
		
		for(int i=2;i<=40;i++) {
			result[i][0] = result[i-1][0] + result[i-2][0];
			result[i][1] = result[i-1][1] + result[i-2][1];
		}
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(result[num][0] + " " + result[num][1] + "\n");
		}
		System.out.println(sb);
	}
}