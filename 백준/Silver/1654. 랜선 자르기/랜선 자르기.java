import java.util.*;
import java.io.*;

// 길이의 최대/최소 경계값에서 시작하면 된다.
// 최소길이 : 제일 짧은 랜선/(N/K)
// 최대길이 : 전체합/K



public class Main {
	public static int getNumber(long length, int[] arr) {
		int result = 0;
		if (length==0)
			length=1;
		for(int n : arr) {
			result+=n/length;
		}
		return result;
	}
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		long max = 0;

		for(int i=0;i<K;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>max)
				max=arr[i];
		}
		
		max++;
		long min = 0;
		
		while(min<max) {
			long mid = (min+max)/2;
			
			if(getNumber(mid,arr)<N)
				max = mid;
			else
				min = mid + 1;
		}
		
	
	
	System.out.println(min-1);
	}
}