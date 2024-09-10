import java.util.*;
import java.math.*;
import java.io.*;



public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String N = br.readLine();
		int n = Integer.parseInt(N);

		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		
		for (int val : list) {
			sb.append(val).append('\n');
		}
		System.out.println(sb);

		
		
	}
}