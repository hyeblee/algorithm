import java.util.*;

public class Main {

  // 한 번호가 다른 번호의 접두어인 경우가 없어야한다.
  // t 입력
  // n 입력
  // n개 번호
  // t번 반복
  public static int t;
  public static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      n = sc.nextInt();
      List<String> strs = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        String str = sc.next();
        strs.add(str);
      }

      Collections.sort(strs); // 정렬하면 긴 친구가 뒤로 감

      boolean found = false;
      // 제일 비슷한 애들끼리(접두어로 갖는...?) 붙어있으니까 인접만 비교
      for (int j = 0; j < strs.size() - 1; j++) {
        String str1 = strs.get(j);
        String str2 = strs.get(j + 1);
        if (str2.startsWith(str1)) {
          found = true;
          break;
        }
      }

      if (found) {
        System.out.println("NO");
      } else {
        System.out.println("YES");
      }
    }
  }
}
