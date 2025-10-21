import java.util.*;
import java.io.*;

public class Main {

  // 이진 검색 트리를 후위 순회한 결과를 출력하여라
  public static class Node {

    int n;
    Node l;
    Node r;

    public Node(int n, Node l, Node r) {
      this.n = n;
      this.l = l;
      this.r = r;
    }
  }

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data, null, null);
    }
    if (root.n > data) {
      root.l = insert(root.l, data);
    } else {
      root.r = insert(root.r, data);
    }

    return root;
  }

  // 후위순위는 왼오부 (자식 방문하고 부모 마지막)
  public static void postorder(Node root) {
    // 자식 없으면 출력하고 종료
    if (root.l == null && root.r == null) {
      System.out.println(root.n);
      return;
    }
    if (root.l != null) {
      postorder(root.l);
    }
    if (root.r != null) {
      postorder(root.r);
    }
    System.out.println(root.n);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Node root = null;

    String line = br.readLine();

    while (line != null && !line.isEmpty()) {
      int n = Integer.parseInt(line);
      root = insert(root, n);
      line = br.readLine();
    }

    postorder(root);
  }

}
