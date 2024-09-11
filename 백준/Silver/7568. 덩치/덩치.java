import java.util.*;


public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] x = new int[N];
		int[] y = new int[N];
		
		for(int i=0;i<N;i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			int rank = 1;
			
			for(int j=0;j<N;j++) {
				if(x[j]>x[i]&&y[j]>y[i])
					rank++;
			}
			System.out.print(rank + " ");
		}
		
	}
}