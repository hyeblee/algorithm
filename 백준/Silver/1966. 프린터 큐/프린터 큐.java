import java.util.*;

// priorityQueue는 순서를 보장하지 않는 데이터구조이다.
// 우선순위가 같을 시, 삽입 순서로 처리를 보장할 수 없다.
// Comparable인터페이스의 compareTo는 this가 o보다 클 때 양수를 반환한다.
// o1.compareTo(o2) 이렇게 하쟈나. . .
// Queue를 인자로 받은 메서드에서, Queue를 조작하면 원래 큐도 조작된다.
// 원래큐는 그대로 두고 싶으면 깊은 복사한 큐를 조작해야한다.
// 얕은 복사는 주소를 참조하는 것이기 때문에, 원래 큐의 값이 변형된다.


public class Main {
	public static void printQueue(Queue<Document> queue) {
		Queue<Document> copy = new LinkedList<>(queue);
		while(copy.size()>0) {
			Document document = copy.poll();
			System.out.print("printing"+document.priority+"["+document.order+"]");
		}
		System.out.println();
	}
	
	public static class Document {
		int order;
		int priority;
	}

	public static boolean hasLargeElementAfter(int priority, int order, Queue<Document> queue) {
		Queue<Document> copy = new LinkedList<>(queue);
		while(copy.size()>0) {
			Document tmp = copy.poll();
			if(tmp.priority>priority)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i=0; i < T; i++) {
			Queue<Document> queue = new LinkedList<>();
			
			boolean flag = true;
			int N = sc.nextInt();
			int M = sc.nextInt();
			for (int j = 0; j < N; j++) {
				int priority = sc.nextInt();
				Document document = new Document();
				document.order = j;
				document.priority = priority;
				queue.offer(document);
			}
			int cnt = 0;

			
			while (queue.size() > 0) {
				Document tmp = queue.peek();

				if (hasLargeElementAfter(tmp.priority, tmp.order, queue)) {
					queue.offer(tmp);
					queue.poll();
				}
				else { //출력해도 괜찮은 상태
					queue.poll();
					cnt++;

					if(tmp.order==M) {
						break;
					}
				}
			}
			
			System.out.println(cnt);
		

		}

	}
}