import java.util.*;


// int형의 범위 2^31+1 ~ 2^31-1
// binarySearch는 중간값과 작은지 큰지 비교하면서 값 찾는 것임
// ->배열 정렬 필수

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		for(int i=0;i<M;i++) {
			int n = sc.nextInt();
			if(Arrays.binarySearch(arr, n)>=0)
				System.out.println("1");
			else
				System.out.println("0");
		}
		
		sc.close();

	}
}