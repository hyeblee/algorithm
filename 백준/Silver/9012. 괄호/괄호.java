import java.util.*;



public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Character> stack = new LinkedList<>();
		for(int i=0;i<N;i++) {
			String result = "YES";
			stack.clear();
			String str = sc.next();
			for(int j=0;j<str.length();j++) {
//				System.out.printf("%c %c\n",str.charAt(j),stack.peekFirst());
				if(str.charAt(j)=='(') {
					stack.addFirst('(');
				}
				else if(stack.isEmpty()) { //짝 맞춰야하는데 비어있으면 NO
					result = "NO";
					break;
				}
				else if(str.charAt(j)==')'&&(char)stack.pollFirst()=='(')
					continue;
				else {
//					System.out.printf("%d %c\n",j,stack.peekFirst());
					result = "NO";
					break;
				}
					
//				// 짝 맞춰야하는데 꺼낼 게 없거나, 비어있으면 NO
//				else if(stack.isEmpty() || (char)stack.peekFirst()!='(') { 
//					result = "NO";
////					System.out.println(str.charAt(j)+"꺼냄");
//					break;
//				}
//				else
//					stack.pollFirst();
			}
//			System.out.print(stack.peek());
			if(!stack.isEmpty()) // 문자열 순회 끝났는데 스택에 원소 있으면 NO
				result = "NO";
			System.out.println(result);
		}
		sc.close();
		
		

	}
}