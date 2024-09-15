import java.util.*;

// 스택에 원소가 있는 채로 끝나면 짝이 안맞은 것인데, 이 경우를 생각하지 못했다.
// 짝이 맞으면 시작하는 원소도 꺼내야하는데, 그러지 않았다.

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	
		Deque<Character> stack = new LinkedList<>();
		while(true) {
			stack.clear(); // 새 문장 시작하면 스택은 항상 비워주기
			String str = sc.nextLine();
			if(str.equals("."))
				break;
			String result = "yes";
			for(int i=0;i<str.length();i++) {
				char ch = str.charAt(i);
//				System.out.println("처음은, "+ stack.peekFirst());
				if(ch=='('||ch=='[') { // 시작하는 괄호면 스택에 넣는다.
					stack.addFirst(ch);

				}
				else if(ch==')') { // 끝나는 괄호면 스택에서 꺼내서 짝인지 비교한다.
					// 꺼낼 게 없거나 짝이 맞지 않다면 no
//					System.out.println(")와 짝은 "+stack.peekFirst() + " " + stack.isEmpty());
					if(stack.isEmpty() || stack.pollFirst()!='(') { 
						result = "no";
						break;
					}
					// 짝 맞으면 남은 짝도 꺼내고 계속 검사
				}
				else if(ch==']') { // 끝나는 괄호면 큐에서 꺼내서 짝인지 비교한다.
					// 꺼낼 게 없거나 짝이 맞지 않다면 no
					if(stack.isEmpty() || stack.pollFirst()!='[') { 
						result = "no";
						break;
					}
					
				}	
			}
			if(!stack.isEmpty())
				result = "no";
			System.out.println(result);
		}
		sc.close();
		
		

	}
}