import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int s = 0;
		M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String cmd = st.nextToken();
			if(cmd.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				if(((s>>x)&1)==0)
					s += 1<<x;
			}
			else if(cmd.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				if(((s>>x)&1)!=0)
					s-=1<<x;
			}
			else if(cmd.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				if(((s>>x)&1)!=0)
					sb.append(1+"\n");
				else
					sb.append(0+"\n");
			}
			else if(cmd.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				s ^= (1<<x);
			}
			else if(cmd.equals("all")) {
				s = (1<<21)-1;
			}
			else if(cmd.equals("empty")) {
				s = 0;
			}
		}
		System.out.println(sb);
	}
}