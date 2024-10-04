import java.util.*;
import java.io.*;

// Deque의 실패 시, 예외 말고 null을 던지는 메서드들
// offer, poll, peek

public class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if(cmd.equals("push")) {
				int n = Integer.parseInt(st.nextToken());
				queue.offerLast(n);
			}
			else if(cmd.equals("pop")) {
				if(queue.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(queue.pollFirst()+"\n");
			}
			else if(cmd.equals("size")) {
				bw.write(queue.size()+"\n");
			}
			else if(cmd.equals("empty")) {
				if(queue.isEmpty())
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
			}
			else if(cmd.equals("front")) {
				if(queue.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(queue.peekFirst()+"\n");
			}
			else if(cmd.equals("back")) {
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