import java.util.*;

public class Main {
    static List<int[]> flips = new ArrayList<>();  // 뒤집을 위치 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        // 뒤집기 연산 정의
        flips.add(new int[]{0, 1, 2});  // 행 1
        flips.add(new int[]{3, 4, 5});  // 행 2
        flips.add(new int[]{6, 7, 8});  // 행 3
        flips.add(new int[]{0, 3, 6});  // 열 1
        flips.add(new int[]{1, 4, 7});  // 열 2
        flips.add(new int[]{2, 5, 8});  // 열 3
        flips.add(new int[]{0, 4, 8});  // 대각선 1
        flips.add(new int[]{2, 4, 6});  // 대각선 2

        while (T-- > 0) {
            StringBuilder start = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                String[] row = sc.nextLine().split(" ");
                for (String s : row) {
                    start.append(s);
                }
            }

            System.out.println(bfs(start.toString()));  // 최소 횟수 출력
        }
    }

    static int bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();

        queue.add(start);
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int steps = visited.get(cur);

            // 만약 전부 H 또는 전부 T라면 종료
            if (cur.equals("HHHHHHHHH") || cur.equals("TTTTTTTTT")) return steps;

            for (int[] flip : flips) {
                String next = flipState(cur, flip);
                if (!visited.containsKey(next) || visited.get(next) > steps + 1) {
                    visited.put(next, steps + 1);
                    queue.add(next);
                }

            }
        }
        return -1;  // 불가능한 경우
    }

    static String flipState(String state, int[] indices) {
        char[] arr = state.toCharArray();
        for (int idx : indices) {
            arr[idx] = (arr[idx] == 'H') ? 'T' : 'H';  // H ↔ T 변환
        }
        return new String(arr);
    }
}
