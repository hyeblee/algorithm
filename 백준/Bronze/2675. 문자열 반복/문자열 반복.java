import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int R = sc.nextInt();
			String S = sc.next();
			String P = "";
			for(int j=0;j<S.length();j++) {
				P += String.valueOf(S.charAt(j)).repeat(R);
			}
			System.out.println(P);
		}
	}
}