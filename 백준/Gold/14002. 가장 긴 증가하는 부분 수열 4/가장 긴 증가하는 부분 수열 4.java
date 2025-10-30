import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
        
        int[] parent = new int[n];    // 이전 원소 index
        Arrays.fill(parent, -1);
        List<Integer> list = new ArrayList<>();        // LIS 값 저장
        List<Integer> indexList = new ArrayList<>();   // 각 pos에서 마지막 arr index

        for(int i=0;i<n;i++){
            int val = arr[i];
            int pos = lowerBound(list, val);
            
            if(pos < list.size()) list.set(pos, val);
            else list.add(val);
            
            if(pos > 0) parent[i] = indexList.get(pos-1); // 이전 원소 연결
            
            if(pos < indexList.size()) indexList.set(pos, i);
            else indexList.add(i);
        }

        int len = list.size();
        System.out.println(len);

        // LIS 수열 복원
        int[] result = new int[len];
        int idx = indexList.get(len-1);
        for(int i=len-1;i>=0;i--){
            result[i] = arr[idx];
            idx = parent[idx];
        }

        for(int v: result) System.out.print(v + " ");
    }

    static int lowerBound(List<Integer> list, int target){
        int l = 0, r = list.size();
        while(l < r){
            int mid = (l+r)/2;
            if(list.get(mid) >= target) r = mid;
            else l = mid+1;
        }
        return l;
    }
}
