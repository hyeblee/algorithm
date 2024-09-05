import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close(); //사용끝났으면 닫아주기
		int[] arr = new int[26];
		Arrays.fill(arr,-1);
		
		for(int i=0;i<str.length();i++) {
			int n = str.charAt(i) - 'a';
			if(arr[n]==-1)
				arr[n] = i;
			
		}
		
		
		for(int i=0;i<26;i++)
			System.out.printf("%d ",arr[i]);
	}
}