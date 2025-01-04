import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	public static int N, K;
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		ArrayList<Integer> coins = new ArrayList<>();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			int coin = Integer.parseInt(br.readLine());
			coins.add(coin);
		}
		for(int i=N-1;i>=0;i--) {
			while(K>=coins.get(i))
			{
				K-=coins.get(i);
				result++;
			}
		}
		
		System.out.println(result);

	}
}