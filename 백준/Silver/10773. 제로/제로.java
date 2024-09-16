import java.util.*;



public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Deque<Integer> stack = new LinkedList<>();
		
		int K = sc.nextInt();
		
		for(int i=0;i<K;i++) {
			int n = sc.nextInt();
			if(n==0)
				stack.pollFirst();
			else
				stack.addFirst(n);
		}
		int sum = 0;
		while(!stack.isEmpty()) {
			sum+=(int)stack.pollFirst();
		}
		System.out.println(sum);

	}
}