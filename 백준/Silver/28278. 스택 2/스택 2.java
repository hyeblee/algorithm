import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> stack = new LinkedList<>();
		
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if(cmd==1) {
				int n = Integer.parseInt(st.nextToken());
				stack.push(n);
			}
			else if(cmd==2) {
				if(stack.isEmpty()) {
					bw.write(-1 + "\n");
				}
				else
					bw.write(stack.pop() + "\n");
			}
			else if(cmd==3) {
				bw.write(stack.size()+"\n");
			}
			else if(cmd==4) {
				if(stack.isEmpty())
					bw.write(1+"\n");
				else
					bw.write(0+"\n");
			}
			else if(cmd==5) {
				if(stack.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(stack.peekFirst()+"\n");
			}
		}
		bw.flush();
		bw.close();
		
		
	}
}