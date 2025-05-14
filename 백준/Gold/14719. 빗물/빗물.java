import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static int H, W;
  public static int[][] grid; // 빈칸0, 벽1, 물2

  // 왼쪽 전진 시 벽 있ㅇ는지 반환
   public static boolean goLeft(int x, int y) {
     for(int i=x;i>=0;i--){
       if(grid[y][i]==1)
         return true;
     }
     return false;
   }
  // 오른쪽 전진 시 벽 있는지 반환
  public static boolean goRight(int x, int y) {
    for(int i=x;i<W;i++){
      if(grid[y][i]==1)
        return true;
    }
    return false;
  }
  // 왼쪽, 오른쪽 둘 다 있음 rain
  public static boolean isRain(int x, int y){
     return(goLeft(x,y)&&goRight(x,y));
  }



  public static class Node {

    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void paintWall(int col, int n) {
    for (int i = H - 1; i >= H - n; i--) {
      grid[i][col] = 1;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());

    grid = new int[H][W];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < W; i++) {
      int n = Integer.parseInt(st.nextToken());
      paintWall(i, n);
    }

    int result = 0;
//System.out.println(goLeft(0,0));
    for(int i = 0;i<H;i++){
      for(int j = 0;j<W;j++){
        if(grid[i][j]==0 && isRain(j,i)){
          result++;
//          System.out.println(j+" "+i);
        }
      }
    }



    System.out.println(result);
  }
}