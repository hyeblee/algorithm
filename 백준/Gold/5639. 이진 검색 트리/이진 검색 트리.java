import java.util.*;
import java.io.*;

public class Main {

  public static class Node {
    int n;
    Node l;
    Node r;

    public Node(int n) {
      this.n = n;
    }
  }

  // BST 삽입
  public static Node insert(Node root, int val) {
    if (root == null) return new Node(val);

    if (root.n < val) root.r =  insert(root.r, val);
    else root.l = insert(root.l, val);
    return root;
  }

  // 후위순회
  public static void postOrder(Node root) {
    if (root == null) return;

     postOrder(root.l);
     postOrder(root.r);
     System.out.println(root.n);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    Node root = null;

    while ((line = br.readLine()) != null && !line.isEmpty()) {
      int val = Integer.parseInt(line);
      root = insert(root, val);
    }

    postOrder(root);
  }
}
