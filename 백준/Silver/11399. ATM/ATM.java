import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
	public static int n;
	public static PriorityQueue<Integer> queue = new PriorityQueue<>();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			queue.add(num);
		}
		int result = 0;
		while(!queue.isEmpty()) {
			result += queue.size()*queue.poll();
//			System.out.println(result);
		}
		System.out.println(result);

	}
}