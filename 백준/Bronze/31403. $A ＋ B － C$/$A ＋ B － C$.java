import java.util.Scanner;
import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		String n = "";
		n += String.valueOf(A) + String.valueOf(B);
		int result = Integer.valueOf(n) - C;
		System.out.println(A+B-C);
		System.out.println(result);
	}
}