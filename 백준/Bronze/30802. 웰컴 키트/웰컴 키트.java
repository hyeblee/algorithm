import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] tShirt = new int[6];
		
		for(int i=0;i<6;i++)
			tShirt[i] = sc.nextInt();
		int t = sc.nextInt();
		int p = sc.nextInt();
		
		int tShirtCount = 0;
		for(int i=0;i<6;i++) 
			tShirtCount+=(tShirt[i]+t-1)/t;
			
		System.out.println(tShirtCount);
		System.out.printf("%d %d\n",n/p,n%p);
		
		
		
		
		
	}
}