import java.io.*;
import java.util.*;

// binarySearch가 처음찾은 mid가 시작이 아니라면?
// 양옆에 있던 같은 숫자들 갯수는 어떻게 셀건지.
// n보다 작은 것 중 제일 큰 것을 찾아야지,,
// start와 end의 경계를 찾아야한다.
// 트리 맵은 key를 정렬해서 저장한다.



public class Main {
	
	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		for(int i=1;i<=N;i++) {
			queue.offer(i);
		}
		int[] arr = new int[N];
		int idx = 0;
		StringBuilder result = new StringBuilder("<");
		while(queue.size()>1) {
			for(int i=0;i<K-1&&queue.size()>0;i++) {
				queue.offer(queue.poll());
			}
		result.append(queue.poll() + ", ");	
		}
		result.append(queue.poll()+">");
		System.out.print(result);
	}
}