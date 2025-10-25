import java.util.*;
import java.io.*;

public class Main {

    // 1. 이진트리에서 같은 level이면 같은 y축에 위치한다.
    // 2. 같은 x를 갖지 않는다.
    // 3. 왼쪽트리는 x가 루트보다 작다. 오른쪽 트리는 x가 루트보다 크다.
    // 4. x의 시작점과 끝 점은 전부 노드로 채워져있다.
    // 너비는 x끝 - x시작 + 1
    // 가장 너비가 넓은 level과 그 넓이 구하기. (같으면 번호 작은 순)
    // 중위순위: 왼쪽 -> 부모 -> 오른쪽
    // depth 기록 필요해.
    
    public static class Node {
        int n;
        Node left;
        Node right;
        
        public Node(int n) {
            this.n = n;
        }
    }

    public static int N; 
    public static List<Node> tree = new ArrayList<>();
    public static int[] col;
    public static int[] depth, minX, maxX;
    public static boolean[] visited; 
    public static int maxLevel, maxWidth, maxDepth;
    public static int idx = 1;

    public static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        col[node.n] = idx++;
        inorder(node.right);
    }

    public static void writeDepth(Node node, int d) {
        if (node == null) {
            return;
        }
        maxDepth = Math.max(maxDepth, d);
        int x = col[node.n];

        minX[d] = Math.min(minX[d], x);
        maxX[d] = Math.max(maxX[d], x);
        
        writeDepth(node.left, d+1);
        writeDepth(node.right, d+1);
    }

    public static int getRoot() {
        Set<Integer> nodes = new HashSet<>();
        for(int i=1;i<=N;i++) {
            nodes.add(i);
        }

        for(Node node: tree) {
            if (node.left != null)
                nodes.remove(node.left.n);
            if (node.right != null)
                nodes.remove(node.right.n);
        }

        int root = 1;
        for(int n: nodes) {
            root = n;
        }
        return root;
    } 
    
    public static void getMaxWith() {
        for(int i=0;i<=maxDepth;i++) {
            int width = maxX[i] - minX[i] + 1;
            if (width > maxWidth) {
                maxWidth = width;
                maxLevel = i + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        col = new int[N+1];
        depth = new int[N+1];
        visited = new boolean[N+1];
        minX = new int[N+1];
        maxX = new int[N+1];
        
        for(int i=0;i<=N;i++) {
            tree.add(new Node(i));
            minX[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l != -1)
                tree.get(n).left = tree.get(l);
                
            if (r != -1)
                tree.get(n).right = tree.get(r);
        }

        int root = getRoot();
        // System.out.println(root);
        // 1. inorder로 col배열에 기록하기
        inorder(tree.get(root));
        
        // 2. depth 기록하며 minX, maxX 찾기
        writeDepth(tree.get(root), 0);
        // for(int i=1;i<=N;i++) {
        //     System.out.println(i+": "+depth[i]);
        // }


        // // 3. 최대 사이즈 구하기
        getMaxWith();

        System.out.println(maxLevel + " " + maxWidth);


        
    }
    
    
}
