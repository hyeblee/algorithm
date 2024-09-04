import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=1;i<=N;i++) {
			String str = " ".repeat(N-i);
			str += "*".repeat(i);
			System.out.println(str);
		}
	}
}