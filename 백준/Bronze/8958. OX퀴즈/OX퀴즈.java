import java.util.*;

public class Main{
	public static int calScore(String str) {
		int consecutiveCount = 0;
		int total = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='O'){
				consecutiveCount++;
				total+=consecutiveCount;
			}
			else
				consecutiveCount=0;
		}
		return total;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String str = sc.next();
			System.out.printf("%d\n",calScore(str));
		}
	}
}