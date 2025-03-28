import java.io.*;
import java.util.*;

public class Main {
	public static int cnt;
	public static String T;
	public static int result = 0;
	public static Set<String> set = new HashSet<>();

	public static String operation1(String str) { // 끝에 A 붙이는 연산
		return str + "A";
	}

	public static String operation2(String str) { // 끝에 B 붙이고 뒤집는 연산
		String result = "B";
		for(int i=str.length()-1;i>=0;i--) {
			result+=str.charAt(i);
		}
		return new String(result);
	}

	public static void operations(String str, int n) {
		

		if (n == cnt ||( !T.contains(str)&& !T.contains(new StringBuilder(str).reverse()))) { // 연산 n번 수행하면 재귀 종료
			return;
		} else {
			String str1 = operation1(str);
			String str2 = operation2(str);
//			System.out.println(str1+": "+str2);
			
			operations(str1, n + 1);
			operations(str2, n + 1);
			if (str1.equals(T)||str2.equals(T)) { // S를 T로 만들 수 있으면 결과 1
				result = 1;
				return;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		T = sc.next();

		cnt = T.length() - S.length(); // 연산할 횟수

		operations(S, 0);
		System.out.println(result);
	}
}
