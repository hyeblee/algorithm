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
	public static int[] result = new int[301];
	public static int[] stair = new int[301];
	

	
	public static void main(String[] args) throws IOException{
		
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			stair[i]=sc.nextInt();
		}
		result[1] = stair[1];
		result[2] = stair[1]+stair[2];
		result[3] = Math.max(stair[1], stair[2])+stair[3];
		for(int i=4;i<=n;i++) {
			result[i] = Integer.max(stair[i-1]+result[i-3],result[i-2])+stair[i];
		}
		System.out.println(result[n]);
	}
}