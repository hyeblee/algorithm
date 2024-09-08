import java.util.*;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 1;
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		sc.close();
		for(int i=N;i>N-K;i--)
			result*=i;
		for(int i=K;i>=2;i--)
			result/=i;
		System.out.println(result);
		
	}
}