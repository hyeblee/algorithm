import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		// 바구니 번호와 배열에 들어있는 숫자 같음
		for(int x = 0 ; x < arr.length ; x++) {
			arr[x] = x+1;
		}
		
		// 공 바꾸는 횟수
		for(int x = 0 ; x < M ; x++) {
			
			// 바꿀 번호 입력
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			// 대입될 곳 index number 로 바꾸면 i-1
			// 두번째 입력 받은 숫자 대입될 곳 j-1  
			// 담아둘 곳 num
			int num = arr[i-1];
			arr[i-1] = arr[j-1];
			arr[j-1] = num;
			
			
		}
		
		// 출력
		for(int x = 0 ; x < arr.length ; x++) {
			System.out.print(arr[x] + " ");
		}
	}
}