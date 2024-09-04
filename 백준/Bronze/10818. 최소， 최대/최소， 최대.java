import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = sc.nextInt();
		int min = max;
		for(int i=0;i<N-1;i++) {
			int num = sc.nextInt();
			if(num > max)
				max = num;
			if(num < min)
				min = num;
		}
		
		System.out.printf("%d %d\n",min, max);
	}
}