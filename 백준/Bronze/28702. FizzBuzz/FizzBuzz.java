import java.util.*;


public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt;
		String str="";
		for(cnt=1;cnt<=3;cnt++) {
			str = sc.next();
			if(str.contains("Fizz")||str.contains("Buzz"))
				continue;
			else
				break;
		}
		int n = Integer.parseInt(str) + 4 - cnt;
		
		if(n%3==0)
			System.out.print("Fizz");
		if(n%5==0)
			System.out.println("Buzz");
		if(n%5!=0&&n%3!=0)
			System.out.println(n);
		
	}
}