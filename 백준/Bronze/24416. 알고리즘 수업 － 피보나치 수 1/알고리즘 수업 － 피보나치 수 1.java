import java.util.*;
import java.io.*;


public class Main {

  static long result1 = 0;
  static long result2 = 0;
  public static int[] dp;

  public static void recursiveFactorial(int n) {
    if (n==1 || n==2) {
      result1++;
      return;
    }
    recursiveFactorial(n-1);
    recursiveFactorial(n-2);
  }

  public static void dpFactorial(int n) {
    dp[1] = 1;
    dp[2] = 1;
    for(int i=3; i<=n; i++) {
      result2++;
    }
  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    dp = new int[n + 1];

    recursiveFactorial(n);
    dpFactorial(n);
    System.out.println(result1);
    System.out.println(result2);

  }


}