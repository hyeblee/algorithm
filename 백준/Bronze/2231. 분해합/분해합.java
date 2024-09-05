import java.util.*;

public class Main{

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		int generator = 0;
		String strN = String.valueOf(N);
		
		for(int i=N-9*strN.length();i<N;i++) {
			int sum = i;
			int n = i;
			while(n>0) {
				sum += n % 10;
				n/=10;
			}
			if(sum==N) {
				generator = i;
				break;
			}
		}
		
		System.out.println(generator);
		
	}
}