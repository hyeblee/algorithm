import java.util.*;

public class Main {
  public static final int MAX_SIZE = 100;
  public static long[] result = new long[MAX_SIZE+1];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    result[1] = 1;
    result[2] = 1;
    result[3] = 1;

    for(int i=4; i<=MAX_SIZE; i++){
      result[i] = result[i-3] + result[i-2];
    }

    for (int i = 0; i < T; i++) {
      int n = sc.nextInt();
      System.out.println(result[n]);
    }
  }

}