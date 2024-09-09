import java.util.*;

public class Main{
	public static void main(String[] args) {
		// 객체의 메서들을 호출하기 위한 객체 생성
		Main mainClass = new Main();
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int n = sc.nextInt();
		System.out.println(str.charAt(n-1));
	}
}