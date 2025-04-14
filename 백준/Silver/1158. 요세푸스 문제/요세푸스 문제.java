import java.io.*;
import java.util.*;


public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      queue.offer(i);
    }
    List<Integer> list = new ArrayList<>();
    while (!queue.isEmpty()) {
      for (int i = 0; i < K - 1; i++) {
        queue.offerLast(queue.pollFirst());
      }
      list.add(queue.pollFirst());
    }
    String result = list.toString().replace("[", "<").replace("]", ">");
    System.out.println(result);
  }
}