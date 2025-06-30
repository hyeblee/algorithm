import java.util.*;
import java.io.*;


public class Main {

  public static int n;
  public static long[] nums;
  public static int[] operations = new int[4];
  public static long result = 0;
  public static long max = Long.MIN_VALUE;
  public static long min = Long.MAX_VALUE;

  public static long calculate(int operation, long number) {
    long tmp = result;
    if (operation == 0) {
      tmp += number;
    }
    if (operation == 1) {
      tmp -= number;
    }
    if (operation == 2) {
      tmp *= number;
    }
    if (operation == 3) {
      tmp /= number;
    }
    return (int) tmp;
  }

  public static void dfs(int depth) {
    if (depth == n) {
      max = Math.max(max, result);
      min = Math.min(min, result);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (operations[i] != 0) {
        long tmp = result;
        operations[i]--;
        result = calculate(i, nums[depth]);
        dfs(depth + 1);
        result = tmp;
        operations[i]++;
      }
    }

  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    nums = new long[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    operations[0] = sc.nextInt();
    operations[1] = sc.nextInt();
    operations[2] = sc.nextInt();
    operations[3] = sc.nextInt();

    result = nums[0];
    dfs(1);
    System.out.println((int) max);
    System.out.println((int) min);
  }


}