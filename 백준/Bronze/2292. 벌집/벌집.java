import java.util.*;

public class Main{

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 1;
		sc.close();
		if(N==1)
			count = 1;
		int start = 1;
		int end = 1;
		for(int i=1;i<=N;i++) {
			start = end + 1;
			end = start + 6*i - 1;
			if(N>=start&&N<=end) {
				count = i+1;
				break;
			}
		}
		
		System.out.println(count);
		
	}
}