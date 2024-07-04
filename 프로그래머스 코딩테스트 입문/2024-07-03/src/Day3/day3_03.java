package Day3;
import java.util.*;


public class day3_03 {
		
		public int solution(int[] array) {
			int[] count = new int[1000];
			int max = 0;
			int maxIndex = 0;
			boolean isMultiple = false;
			for(int i = 0; i<array.length; i++) {
				count[array[i]]++;
				if(count[array[i]] > max) {
					isMultiple = false;
					max = count[array[i]];
					maxIndex = array[i];
				}
				else if (count[array[i]] == max) {
					isMultiple = true;
				}
			}
			if(isMultiple == true)
				return -1;
			else
				return maxIndex;
		}

		public static void main(String[] args) {
		day3_03 my = new day3_03();
		int result = my.solution(new int[] {9, 3,3, 0});
		System.out.println(result);
	}
}
