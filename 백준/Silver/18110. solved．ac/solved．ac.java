import java.io.*;
import java.util.*;



public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> deque = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		long cutline = Math.round((double)n*0.15);
//		System.out.println(cutline);
		for(int i=0;i<n;i++) {
			int opinion = Integer.parseInt(br.readLine());
			deque.offerLast(opinion);
			
		}

        List<Integer> sortedList = new ArrayList<>(deque);
        // 오름차순 정렬
        Collections.sort(sortedList);
        deque.clear();  // Deque를 비우고
        deque.addAll(sortedList);
		for(int i=0;i<cutline;i++) {
			deque.pollFirst();
			deque.pollLast();
		}
		double avg = 0;
		int size = deque.size();
		for(int i=0;i<size;i++) {
//			System.out.println(deque.peekFirst());
			avg+=deque.pollFirst();
		}
		avg/=size;
		System.out.print(Math.round(avg));
	}
}