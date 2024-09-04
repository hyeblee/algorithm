import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//바이트로 받아서 저장할건지? 문자열로 처리할건지?
		//숫자 갯수가 정해져있으므로 바이트로 받아서 저장할 것
		//InputStream은 바이트 단위로 받아서 아스키값을 저장한다. read()로!
		//그래서 n다음에 숫자들을 읽기 전에 개행을 읽어버릴수도,,
		
		int n = sc.nextInt();
		int sum = 0;
		String str = sc.next();
		sc.close();
		for(int i=0;i<n;i++) {
			int num = str.charAt(i) - '0';
			sum += num;
		}
		
		System.out.println(sum);
	}
	
}
