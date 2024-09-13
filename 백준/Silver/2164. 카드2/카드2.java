import java.util.*;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1;i<=N;i++)
			queue.offer(i);
		
		while(queue.size()>1) {
			queue.poll(); // 제일 위에 있는 카드는 바닥에 버린다
			queue.offer(queue.poll()); // 그 다음카드는 제일 아래로 옮긴다.
		}
		System.out.println(queue.peek());
		

	}
}