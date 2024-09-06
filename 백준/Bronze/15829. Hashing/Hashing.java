import java.util.*;

public class Main{

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		String str = sc.next();
		sc.close();
		
		int result = 0;
		
		for(int i=0;i<str.length();i++) {
			int n = str.charAt(i) - 'a' + 1;
			result += (n*Math.pow(31, i))%1234567891;
		}
		
		
		System.out.println(result);
		
	}
}