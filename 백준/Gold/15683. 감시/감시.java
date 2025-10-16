import java.util.*;
import java.io.*;


public class Main {
    // 세로 n, 가로 m
    // n x m 정보
    // 0 빈칸, 6 벽, 1~5 cctv
    
    public static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    // 상(0) 우(1) 하(2) 좌(3) 방향 정보
    public static final Node[] direct 
    = {new Node(-1,0), new Node(0, 1), new Node(1,0), new Node(0, -1)};
    
    // cctv 별로 가능한 방향 조합, 0000(상우하좌)
    public static final String[][] cctvComb = {
        {"0001", "0010", "0100", "1000"}, // 1번 cctv
        {"0101", "1010"},
        {"0011", "0110", "1001", "1100"},
        {"0111", "1011", "1101", "1110"},
        {"1111"}
    };

    public static int n, m;
    public static List<Node> cctvs = new ArrayList<>();
    public static int[][] grid;
    public static int min = Integer.MAX_VALUE;

    public static boolean inRange(int y, int x) {
        return 0<=y && y<n && 0<=x && x<m;
    }

    // cctv 목록에서 종류 확인하고 모든 case 탐색돌리기
    public static void searchAll(int depth, boolean[][] visited) {
        if (depth == cctvs.size()) {
            // 사각지대 세기
            int result = getCnt(visited);
            min = Math.min(result, min);
            return;
        }

        
        Node pos = cctvs.get(depth);
        int y = pos.y;
        int x = pos.x;

        // System.out.println(y + ", "+x+": "+depth + "- kind "+ grid[y][x]);

        int kind = grid[y][x] - 1;
        for(String comb: cctvComb[kind]) {
            // 0001 처리?
            // 상우하좌
            // System.out.println(comb);
            boolean[][] tmp = new boolean[n][m];
            for(int j = 0;j<n;j++) {
                tmp[j] = Arrays.copyOf(visited[j], m);
            }
            for(int i=0;i<4;i++) {
                if (comb.charAt(i)=='1') {
                    go(direct[i], pos, tmp);
                }
                // print(tmp);
            }
            searchAll(depth+1, tmp);
        }
    }

    public static int getCnt(boolean[][] tmp) {
        int result = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (!tmp[i][j] && grid[i][j] == 0)
                    result++;;
            }
        }

        return result;
    }

    // public static void print(boolean[][] tmp) {
    //          for(int i=0;i<n;i++) {
    //             for(int j=0;j<m;j++) {
    //                 System.out.print(tmp[i][j]? "1 ": "0 ");
    //             }
    //             System.out.println("");
    //         }
    //         System.out.println("===============");
    // }

    // start에서 시작하여 상하좌우 중 한 방향으로 계속 탐색해서 visited에 기록
    public static void go(Node direction, Node start, boolean[][] visited) {
        // System.out.printf("dirY: %d, dirX: %d\n", direction.y, direction.x);
        Node cur = new Node(start.y, start.x);

        while (true) {
            // 범위 벗어나거나 벽 만나면 break
            if (!inRange(cur.y, cur.x) || grid[cur.y][cur.x]==6) {
                break;
            }
            // 빈칸일때만 방문 기록 가능
            if (grid[cur.y][cur.x] == 0) {
                visited[cur.y][cur.x] = true;
            }
            // 전진
            cur.y += direction.y;
            cur.x += direction.x;
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new InputStreamReader(System.in));

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] != 0 && grid[i][j] != 6) { // 빈칸 아니거나 벽 아니면
                    cctvs.add(new Node(i,j));
                }
            }
        }

        searchAll(0, visited);
        System.out.println(min);
    }

}