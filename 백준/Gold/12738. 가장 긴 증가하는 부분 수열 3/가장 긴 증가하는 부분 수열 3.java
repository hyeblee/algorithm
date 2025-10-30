import java.io.*;
import java.util.*;

public class Main {
    // LIS(Longest Increasing Subsequence)
    // 시작과 끝을 늘려가며 탐색한다.
    // 마지막보다 큰 값이 나오면 마지막을 갱신한다.
    // 마지막보다 작은 값이 나오면 자리 찾아서 넣어주고 마지막을 갱신한다. (첫번째가 될수도)

    static int n; 
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    // 중간에 끼워넣는 함수. target보다 작으면서 젤 큰 값을 찾아줌
    // UpperBound
    static int getPos(int target) {
        int l = 0;
        int r = list.size();

        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) == target) {
                return mid;
            }
            if (list.get(mid) > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }


        return l;
    }
    
    
    

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        list.add(arr[0]);
        int max = 1;
        for(int i=1;i<n;i++) {
            int v = arr[i];

            int last = list.get(list.size() - 1);

            if (v > last) { // 끝에 추가하기
                list.add(v);
            } else { // 바꿔치기 하기
                // v보다 큰 애들 중에 제일 작은 위치를 반환해줌
                int pos = getPos(v);
                // 바꿔치기해서 끼워넣기 하면 됨. 같으면 추가 안함
                list.set(pos, v);
            }
            max = Math.max(list.size(), max);
            // System.out.println(max);
            // System.out.println(String.valueOf(list));
        }

        System.out.println(max);
    
    }
}
