import java.io.*;
import java.util.*;

// new LinkedList()로 만들어서 메모리 초과가 나왔다,


class Ballon{
	int order;
	int paper;
	
	Ballon(int order, int paper){
		this.order = order;
		this.paper = paper;
	}
}




public class Main{
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Ballon> deque = new ArrayDeque<>();
		
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(st.nextToken());
			Ballon ballon = new Ballon(i+1, n);
			deque.offerLast(ballon);
		}
		br.close();
		Ballon ballon = deque.pollFirst();
		bw.write(ballon.order+" ");
		while(!deque.isEmpty()) {
			int size = deque.size();
			if(ballon.paper>0) { // 양수는 앞에서부터 차례로 꺼낸다
				for(int i=0;i<ballon.paper-1;i++) {
					deque.offerLast(deque.pollFirst());	
				}
				ballon = deque.pollFirst();
			}
			else { // 음수는 뒤에서부터 차례로 꺼낸다.
				for(int i=0;i<Math.abs(ballon.paper)-1;i++) {
					deque.offerFirst(deque.pollLast());
				}
				ballon = deque.pollLast();
			}
			bw.write(ballon.order+" ");
		}
		bw.flush();
		bw.close();
		
	}
	
}