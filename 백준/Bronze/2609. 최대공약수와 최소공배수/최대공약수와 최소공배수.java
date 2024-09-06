import java.util.*;
// 최대공약수는 유클리드호제법을 사용한다.
// 최소공배수는 A X B / gcd(A, B)
public class Main{
	public static int gcd(int a, int b) {
		int mod = a % b;
		if(mod==0)
			return b;
		else
			return gcd(b,mod);
	}
	
	public static int lcm(int a, int b) {
		return(a*b/gcd(a,b));
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		System.out.println(gcd(a,b));
		System.out.println(lcm(a,b));
		
		
	}
}