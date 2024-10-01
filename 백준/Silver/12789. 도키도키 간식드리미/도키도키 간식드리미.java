import java.util.*;
import java.io.*;

// n(순서)를 입력받으면, stack에 넣거나 아님 바로 간식받는 곳으로 가거나 2가지 중 하나이다.
// stack을 다 꺼내서 12345를 만들면 성공(빈 스택을 만들면 성공)

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int order=1;
		Deque<Integer> stack = new LinkedList<>();
		int n=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			n = Integer.parseInt(st.nextToken());
			if(n==order) // 간식받는 곳으로 가기
				order++;
			else { // n의 순서가 아니라면
				// 대기스택에서 간식받는 곳으로 보낼 수 있는지 확인
				while(!stack.isEmpty()&&stack.peekFirst()==order) {
					stack.pop();
					order++;
				}
				
				// 그리고 현재(n)이 대기스택으로 보내기
				stack.push(n);
			}
		}
		
		while(!stack.isEmpty()&&stack.peekFirst()==order) {
			stack.pop();
			order++;
		}
	
		if(stack.isEmpty()) // 스택을 다 꺼내서 1234~N을 만들었다면
			System.out.println("Nice\n");
		else
			System.out.println("Sad\n");
		
		
		
	
	}		
}