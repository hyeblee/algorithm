import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Deque<Integer> stack = new LinkedList<>();
		StringBuilder sb = new StringBuilder("");
		int idx=0;
		for(int i=1;i<=n;i++) {
			
			if(i==arr[idx]) {
				sb.append("+\n-\n");
				idx++;
			}
			else {
				stack.push(i);
				sb.append("+\n");
			}
			while(stack.size()>0&&arr[idx]==stack.peekFirst()) {
				stack.pollFirst();
				sb.append("-\n");
				idx++;
			}
		}

		if(idx==n)
			System.out.println(sb);
		else
			System.out.println("NO");
		
		
	}
}