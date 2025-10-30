import java.io.*;
import java.util.*;

public class Main {

    // 마을은 트리로 연결되어 있다.
    // 우수 마을의 주민 수는 최대로 해야한다. 
    // => 자연스럽게 일반->일반 ->우수 방지 (우수->일반->우수 가 더 최대일거니까)
    // 우수마을끼리는 서로 인접해 있을 수 없다.
    // 우수 마을이 아닌 마을은, 무조건 우수마을과 인접해있어야한다.
    // dfs로 탐색, 부모노드가 우수마을이면, 자식은 아님. 
    // 사이클이 없는 트리이므로, 부모는 아무거나 잡아도 됨

    // 1. 간선정보 저장하기 
    // 2. 1번 노드를 root로 탐색하기
    // 3. memo, best에 기록하기
    // root면 둘 다 호출하기
    // 그 외
    // 부모(n) 일반이면 나는 우수, 일반 가능 memo[n][0] = Math.max(memo[next][0], memo[next][1]);
    // 부모 우수면, 나는 무조건 일반 memo[n][1] = town[n] + memo[next][0]
    
    static int n; 
    static int[][] memo; // memo[n][1]: n번째 노드가 우수마을일 때의 주민 합 최댓값
    static List<Integer>[] adj;
    static int[] town; 

    
    // static 
    // static 
    // static 
    // static 
    // static 
    
    static void traversal(int cur, int parent) {
        
        memo[cur][0] = 0;
        memo[cur][1] = town[cur];

        // 마지막 노드라면, 재귀 종료하고 이전 호출로 돌아간다.
        for(int next: adj[cur]) {
            if (next == parent) {
                continue;
            }

            traversal(next, cur); // 자식을 탐색하여 하위의 모든 memo를 완성한다.

            memo[cur][0] += Math.max(memo[next][0], memo[next][1]);
            memo[cur][1] += memo[next][0];

        }

        
    }


	public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        memo = new int[n+1][2];
        adj = new ArrayList[n+1];
        for(int i=0;i<n+1;i++) {
            adj[i] = new ArrayList<>();
        }
        town = new int[n+1]; 

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=1;i<=n;i++) {
            town[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        traversal(1, 0);

        System.out.println(Math.max(memo[1][0], memo[1][1]));

	}
	

}
