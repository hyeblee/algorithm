import java.util.*;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		sc.close();
		int days = (V - A)/(A-B) + 1; //매일 총 올라가는 높이 + 마지막 A 올라가기
		
		if((V-A)%(A-B)!=0) //나머지가 0이 아니면(예:5.5일) +1일
			days++;
		
		System.out.println(days);
		
	}
}