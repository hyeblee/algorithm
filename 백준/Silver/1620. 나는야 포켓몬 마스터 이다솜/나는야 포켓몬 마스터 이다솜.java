import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, String> map = new HashMap<>();
		Map<String, Integer> reverseMap = new HashMap<>();
		
		StringBuilder sb = new StringBuilder("");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			String name = br.readLine();
			map.put(i,name);
			reverseMap.put(name,i);
		}
		for(int i=0;i<M;i++) {
			String cmd = br.readLine();
			
			if(cmd.matches("-?\\d+")) { // 숫자면
				int num = Integer.parseInt(cmd);
				sb.append(map.get(num)+"\n");
			}
			else {
				sb.append(reverseMap.get(cmd)+"\n");
			}
		}
		System.out.println(sb);
	}
}