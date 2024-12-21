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
	public static int T, n;
	public static Map<String, Integer> map = new HashMap<String, Integer>();
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i=0;i<T;i++) {
			n = sc.nextInt();
			map.clear();
			for(int j=0;j<n;j++) {
				String clothes = sc.next();
				clothes = sc.next();
				map.put(clothes, map.getOrDefault(clothes, 0)+1);
			}
			int result = 1;
			for(String clothes : map.keySet()) {
				result *= map.get(clothes)+1;
			}
			result-=1;
			System.out.println(result);
		}
	
	}
}