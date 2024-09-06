import java.util.*;

public class Main{

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		sc.close();
		
		boolean[] prime = new boolean[N+1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		for(int i=2;i<=Math.sqrt(N);i++) {
			for(int j=i;i*j<=N;j++) {
				prime[i*j] = false;
			}
		}
		
		for(int i=M;i<=N;i++) {
			if(prime[i]==true)
				System.out.println(i);
		}
		
	}
}