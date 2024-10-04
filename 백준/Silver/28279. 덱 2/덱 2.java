import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("1")) {
				int n = Integer.parseInt(st.nextToken());
				queue.offerFirst(n);
			}
			else if(cmd.equals("2")) {
				int n = Integer.parseInt(st.nextToken());
				queue.offerLast(n);
			}
			else if(cmd.equals("3")) {
				if(queue.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(queue.pollFirst()+"\n");
			}
			else if(cmd.equals("4")) {
				if(queue.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(queue.pollLast()+"\n");
			}
			else if(cmd.equals("5")) {
				bw.write(queue.size()+"\n");
			}
			else if(cmd.equals("6")) {
				if(queue.isEmpty())
					bw.write(1 + "\n");
				else
					bw.write(0+"\n");
			}

			else if(cmd.equals("7")) {
				if(queue.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(queue.peekFirst()+"\n");
			}
			else if(cmd.equals("8")) {
				if(queue.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(queue.peekLast()+"\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}