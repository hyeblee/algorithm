import java.util.*;

public class Main{

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		double[] subjects = new double[n];
		double sum = 0;
		for(int i=0;i<n;i++) {
			subjects[i] = sc.nextDouble();
		}
		Arrays.sort(subjects);
		double max = subjects[n - 1];
		for(int i=0;i<n;i++) {
			subjects[i] = subjects[i]/max*100;
			sum += subjects[i];
		}
		System.out.println(sum/n);
		sc.close();
		
		
	}
}