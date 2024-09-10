import java.util.*;



public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt=0;
		for(long i=666;;i++) {
			if(String.valueOf(i).contains("666"))
				cnt++;
			if(cnt==N) {
				System.out.println(i);
				break;
			}
		}
		
		
	}
}