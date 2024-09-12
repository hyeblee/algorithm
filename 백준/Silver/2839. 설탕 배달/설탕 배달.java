import java.util.*;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		int cnt=0;
		cnt = N/5;
		int n = N-cnt*5;
		while(cnt>=0&&n<=n) {
		if(n%3!=0) {
			cnt--;
			n+=5;
		}
			
		else {
			cnt+=n/3;
			break;
		}

		
		}
		System.out.println(cnt);

	}
}