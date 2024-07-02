package Day2;

public class day2_04 {
    public int[] solution(int[] numbers) {
        for(int i = 0; i< numbers.length; i++){
            numbers[i] *= 2;
        }
        int[] answer = new int[numbers.length];
        System.arraycopy(numbers, 0, answer, 0, numbers.length);
        
        return answer;
    }
}
