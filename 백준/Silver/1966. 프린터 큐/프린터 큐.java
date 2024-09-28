import java.util.*;



public class Main {
	
	public static class Document {
		int order;
		int priority;
	}
	// 뒤에 자신보다 큰 원소가 있는지 구하는 메서드 
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
				Document tmp = queue.poll();
				// 자신보다 우선순위가 큰 원소가 있다면
				if (hasLargeElementAfter(tmp.priority, tmp.order, queue)) {
					queue.offer(tmp); //다시 큐에 더한다.
				}
				else { //출력해도 괜찮은 상태
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