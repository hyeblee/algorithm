import java.io.*;
import java.util.*;

// binarySearch가 처음찾은 mid가 시작이 아니라면?
// 양옆에 있던 같은 숫자들 갯수는 어떻게 셀건지.
// n보다 작은 것 중 제일 큰 것을 찾아야지,,
// start와 end의 경계를 찾아야한다.
// 트리 맵은 key를 정렬해서 저장한다.



public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(st.nextToken());
			map.put(n, map.getOrDefault(n, 0)+1);
			
		}
		
		// BinarySearch를 위한 배열 정렬

		
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(num, 0)).append(' ');
		}

		System.out.print(sb);
		
	}
}