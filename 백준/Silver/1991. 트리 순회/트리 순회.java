import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

  public static int n;
  public static Node[] tree;
  public static StringBuilder sb = new StringBuilder("");

  public static class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }
  }


  public static void preorderTraversal(Node node) { // 전위 순회 - 부모, 왼쫀, 오른쪽
    sb.append((char) ('A' + node.data)); // 부모출력하고(현재)

    if (node.left != null) { // 왼쪽 자식으로
      preorderTraversal(node.left);
    }
    if (node.right != null) { // 으론쪽 자식으로
      preorderTraversal(node.right);
    }
  }

  public static void inorderTraversal(Node node) { // 중의 순회 - 왼쪽 부모 오른쪽
    // 왼쪽
    if (node.left != null) {
      inorderTraversal(node.left);
    }
    // 부모(현재)
    sb.append((char) ('A' + node.data));
    // 오른쪽
    if (node.right != null) {
      inorderTraversal(node.right);
    }
  }

  public static void postodrderTraversal(Node node) { // 후위 순회 - 왼쪽 오른쪽 부모
    // 왼쪽
    if (node.left != null) {
      postodrderTraversal(node.left);
    }
    // 오른쪽
    if (node.right != null) {
      postodrderTraversal(node.right);
    }
    // 부모(현재)
    sb.append((char) ('A' + node.data));
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    tree = new Node[n];

    for (int i = 0; i < n; i++) {
      // 현재, 왼쪽 자식, 오른쪽 자식
      StringTokenizer st = new StringTokenizer(br.readLine());
      int cur = st.nextToken().charAt(0) - 'A';
      int left = st.nextToken().charAt(0) - 'A';
      int right = st.nextToken().charAt(0) - 'A';

      if (tree[cur] == null) { // 부모 아직 생성 전이면 생성
        tree[cur] = new Node(cur); // 부모 생성
      }

      if (left >= 0) { // 왼쪽 자식 연결
        if (tree[left] == null) {
          tree[left] = new Node(left); // 왼쪽 자식 생성
        }
        tree[cur].left = tree[left];
      }

      if (right >= 0) { // 오른쪽 자식 연결
        if (tree[right] == null) {
          tree[right] = new Node(right); // 오른쪽 자식 생성
        }
        tree[cur].right = tree[right];
      }
    }

    preorderTraversal(tree[0]); // 전위순회
    sb.append("\n");
    inorderTraversal(tree[0]); // 중위순회
    sb.append("\n");
    postodrderTraversal(tree[0]); // 후위순회

    System.out.println(sb);
  }


}