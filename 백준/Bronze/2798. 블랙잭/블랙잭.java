import java.util.*;

public class Main{
    // total이 M을 넘는 경우를 고려하지 않아서 틀렸다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		int result = 0;
		for(int i=0;i<N;i++) {
			int total = 0;
			for(int j=i+1;j<N;j++) {
				for(int k=j+1;k<N;k++) {
					total = arr[i] + arr[j] + arr[k];
					if(total > M)
						continue;
					if(Math.abs(M-total)<Math.abs(M-result))
						result = total;
				}
			}
		}
		
		
		
		System.out.println(result);
		
	}
}