import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	public static int N, M;
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Set<String> set = new TreeSet<>();
		Set<String> hasTwo = new TreeSet<>();
		StringBuilder sb = new StringBuilder("");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			String name = br.readLine();
			set.add(name);
		}
		for(int i=0;i<M;i++) {
			String name = br.readLine();
			if(set.contains(name)) {
				result++;
				hasTwo.add(name);
			}
		}
		for(String name : hasTwo) {
			sb.append(name+"\n");
		}
		System.out.println(result);
		System.out.println(sb);
	}
}