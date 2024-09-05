import java.util.*;

public class Main{
	public static boolean isPrime(int n) {
		if(n == 1) //1은 예외처리 해주기
			return false;
		
		for(int i=2;i<=n/2;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int N;
		int cnt = 0;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int i=0;i<N;i++) {
			int n = sc.nextInt();
			if(isPrime(n)==true)
				cnt++;
			
		}
		System.out.println(cnt);
		
	}
}