package Day3;
import java.util.Arrays;


public class day3_02 {
	public int solution(int[] array) {
        Arrays.sort(array);
        int length = array.length;
        return array[length/2];
    }
	public static void main(String[] args) {
		day3_02 my = new day3_02();
		int result = my.solution(new int[] {9, -1, 0});
		System.out.println(result);
	}
}
