import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		C = A*B*C;
		String str = String.valueOf(C);
		int[] cnt = new int[10];
		for(int i=0;i<str.length();i++) {
			int n = str.charAt(i) - '0';
			cnt[n]++;
		}
		for(int n : cnt) {
			System.out.println(n);
		}
	}
}