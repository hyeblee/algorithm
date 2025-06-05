import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

  public static int a,b;
  public static boolean isSame = false;
  public static int result = 0;

  public static void deleteOne(int num, int cnt) {
    num /= 10;
    if (num < a)
      return;
    if (num==a){
      result = cnt;
      isSame = true;
      return;
    }
    if (num % 10 == 1 && !isSame)
      deleteOne(num, cnt + 1);
    if (num % 2 == 0 && !isSame)
      divideTwo(num, cnt + 1);
  }

  public static void divideTwo(int num, int cnt) {
    num /= 2;
    if (num < a)
      return;
    if (num==a){
      result = cnt;
      isSame = true;
      return;
    }
    if (num % 10 == 1 && !isSame)
      deleteOne(num, cnt + 1);
    if (num % 2 == 0 && !isSame)
      divideTwo(num, cnt + 1);
  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    a = sc.nextInt();
    b = sc.nextInt();

    // a->b: 1. *2, 2. 오른쪽에 1붙이기
    // b-> a 바꾸기 1.오른쪽에 붙은 1 떼기 2. /2하기
    if (b % 10 == 1) {
      deleteOne(b, 1);
    }
    if (b % 2 == 0) {
      divideTwo(b, 1);
    }
    if (isSame) {
    System.out.println(result+1);
    }
    else {
      System.out.println("-1");
    }
  }

}