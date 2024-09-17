import java.io.*;
import java.util.*;



public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> queue = new LinkedList<>();
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			String cmd = sc.next();
			if(cmd.equals("push")) {
				int n = sc.nextInt();
				queue.addLast(n);
			}
			else if(cmd.equals("pop")) {
				if(queue.isEmpty())
					System.out.println("-1");
				else
					System.out.println(queue.pollFirst());
			}
			else if(cmd.equals("size")) {
				System.out.println(queue.size());
			}
			else if(cmd.equals("empty")) {
				if(queue.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
			}
			else if(cmd.equals("front")) {
				if(queue.isEmpty())
					System.out.println("-1");
				else
					System.out.println(queue.peekFirst());
			}
			else {
				if(queue.isEmpty())
					System.out.println("-1");
				else
					System.out.println(queue.peekLast());
			}
		}
	}
}