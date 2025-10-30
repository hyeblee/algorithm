import java.io.*;
import java.util.*;

public class Main {

    // n개의 집에서 c개 선택, 선택된 집들 중 가장 인접한 거리 최대화하기
    // 거리를 1부터 늘려가면서, c개 선택 가능한지/아닌지 판단한다.
    // 첫번째 집은 무조건 설치한다. 1->2->3 이거나 1->3 이기 때문. (2->3이면 1->3이랑 똑같음)

    static int n, c;

    static int[] house;
    static int max = 0;

    // 만족시키는 값 중 제일 큰 값 -> lowerBound
    static void getDistance(int l, int r) {

        while(l < r) {
            int mid = (l + r) / 2;
            
            if (canInstall(mid)) { // 현재 거리 가능하면 늘려바
                max = Math.max(mid, max);
                l = mid + 1;
            } else {
                r = mid;
            }
        }

    }

    
    static boolean canInstall(int d) {

        int cnt = 1;
        int cur = 0;
        int next = 1;

        while (cur < n && next < n) {
            if (cnt >= c) {
                return true;
            }
            int diff = house[next] - house[cur];
            // System.out.println(cur + " " + next + " " + cnt + " " + diff);
            if (diff < d) { // 만약 d안되면 다음 집과의 거리계산으로 넘김
                next++;
                continue;
            }
            
            // d되면 갯수 세고 cur 넘기기
            cnt++;
            cur = next;
            next = next + 1;
        }

        if (cnt >= c) {
            return true;
        }
        
        return false;
    }


    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        house = new int[n];
        
        c = Integer.parseInt(st.nextToken());
        
        for(int i=0;i<n;i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int maxDiff = house[n-1] - house[0];
        // System.out.println(canInstall(4));
        // 반닫힌 구간이므로, 오른쪽 경계는 maxDiff + 1
        getDistance(0, maxDiff + 1);
        System.out.println(max);

    }
}
