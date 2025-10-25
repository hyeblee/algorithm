import java.util.*;
import java.io.*;

public class Main {

  // 시작 -> 끝
  public static class Node implements Comparable<Node> {

    String cur;
    List<Node> children = new ArrayList<>();

    public Node(String cur) {
      this.cur = cur;
    }

    @Override
    public int compareTo(Node o) {
      return this.cur.compareTo(o.cur);
    }

  }


  public static StringBuilder sb = new StringBuilder("");
  public static List<Node> craves = new ArrayList<>();

  public static void dfs(Node root, int depth) {
    sb.append("--".repeat(depth));
    sb.append(root.cur + "\n");

    // 자식 정렬
    Collections.sort(root.children);
    for (Node child : root.children) {
      dfs(child, depth + 1);
    }
  }

//  public static
//  public static
//  public static
//  public static

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    int maxDepth = 0;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int depth = Integer.parseInt(st.nextToken());
      maxDepth = Math.max(maxDepth, depth);

      // 시작 노드 넣기 (depth = 0)
      String str = st.nextToken();
      Node cur = null;
      for (Node n : craves) {
        if (n.cur.equals(str)) {
          cur = n;
          break;
        }
      }
      if (cur == null) {
        cur = new Node(str);
        craves.add(cur);
      }

      for (int d = 1; d < depth; d++) {
        str = st.nextToken();
        Node next = new Node(str);
        // 부모에 연결해주기
        boolean has = false;
        for (Node child : cur.children) {
          if (child.cur.equals(str)) {
            has = true;
            next = child;
            break;
          }
        }
        if (!has) {
          cur.children.add(next);
        }
        // 부모 갱신하기
        cur = next;
      }
    }

    Collections.sort(craves);
    // root부터 탐색
    for (Node root : craves) {
      dfs(root, 0);
    }
    System.out.println(sb.toString());
  }
}
