import java.util.*;
import java.io.*;

public class Main {
    static int[] inorder, postorder;
    static int[] indexMap; // inorder에서 값 → 인덱스 매핑
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        indexMap = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        // inorder에서 값 -> 인덱스 매핑
        for (int i = 0; i < n; i++) {
            indexMap[inorder[i]] = i;
        }

        preorder(0, n - 1, 0, n - 1);

        System.out.println(sb);
    }

    static void preorder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postorder[postEnd];
        sb.append(root).append(" ");

        int rootIndex = indexMap[root];
        int leftSize = rootIndex - inStart;

        // 왼쪽 서브트리
        preorder(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);

        // 오른쪽 서브트리
        preorder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}
