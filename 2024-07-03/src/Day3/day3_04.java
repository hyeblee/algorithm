package Day3;

import java.util.Arrays;

public class day3_04 {
	public int[] solution(int n) {
		int[] answer = new int[(n+1)/2];
		if(n%2 == 0) 
			n -= 1;
		
		for(int i = 1; i<= n; i++) {
			answer[i/2] = i;
		}
		return answer;
	}

	public static void main(String[] args) {
		day3_04 my = new day3_04();
		int[] result = my.solution(10);
		System.out.println(Arrays.toString(result));
	}
}
