import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[8];
		for(int i=0;i<8;i++) {
			arr[i] = sc.nextInt();
		}
		
		int diff = arr[0] - arr[1];
		
		for(int i=1;i<7;i++) {
			if(arr[i]-arr[i+1]!=diff) {
				System.out.println("mixed");
				return;
			}
		}
		if(diff==-1)
			System.out.println("ascending");
		else
			System.out.println("descending");
	}
}