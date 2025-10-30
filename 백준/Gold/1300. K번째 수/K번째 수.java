import java.io.*;
import java.util.*;

public class Main {

    
    

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // mid보다 작거나 같은 수가 k개 존재면 됨
        
        int l = 1;
        int r = k;

        while (l < r) {
            int mid = (l+r)/2;
            int count = 0;
            for(int i=1;i<=n;i++) {
                count += Math.min(n, mid/i);
            }
            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l);

    }
}
