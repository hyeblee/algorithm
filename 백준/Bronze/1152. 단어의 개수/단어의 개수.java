import java.util.*;

// trim()메서드는 자바에서 문자열의 시작과 끝에 있는 공백 문자를 제거하는 데 사용된다.
// 공백 : 스페이스(' '), 탭('\t'), 개행('\n'), 캐리지 리턴('\r') 


public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		sc.close();
		sentence = sentence.trim(); // 앞 뒤 공백 제거 -> 한 개만 제거 되서 에러
		int cnt = 0;
		
		for(int i=0;i<sentence.length();i++) {
			if(sentence.charAt(i)!=' ') {
				//공백아니면 단어 끝날때까지(공백 만날때까지 or 문장 끝까지) i증가
				cnt++;
				// 단어가 끝나거나 문장 끝까지 오면 종료
				//i가 범위를 넘은 조건을 먼저 써야 i번째 문자를 가져오려는 outofrange 오류 없음.
				while(i<sentence.length()&&sentence.charAt(i)!=' ') {
					i++;
				}
			}
			// 공백인 경우엔 for문 돌면서 알아서 넘어감.
		}
		System.out.println(cnt);
	}
}