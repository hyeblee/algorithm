import java.util.*;
import java.math.*;

// 10을 곱하면 0이 1개 생긴다. -> 5가 1개
// 100을 곱하면 0이 2개 생긴다. -> 5가 2개
// 1000을 곱하면 0이 3개 생긴다. -> 5가 3개
// 10000을 곱하면 0이 4개 생긴다. -> 5개 4개. 그치만 500까지니까 5가 4개가 되는 경우는 없다.

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger factorial = new BigInteger("1");
		
		int cnt=0;
		for(int i=2;i<=N;i++) {
			if(i%5==0)
				cnt++;
			if(i%25==0)
				cnt++;
			if(i%125==0)
				cnt++;
		}
		
		System.out.println(cnt);
	}
}