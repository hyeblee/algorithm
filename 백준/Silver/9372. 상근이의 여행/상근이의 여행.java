import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 수

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt(); // 국가 수
            int m = sc.nextInt(); // 비행기 종류
            for (int i = 0; i < m; i++) {
                sc.nextInt(); // a
                sc.nextInt(); // b
            }
            System.out.println(n - 1); // 최소 비행 횟수 = 국가 수 - 1
        }
    }
}
