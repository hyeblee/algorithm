import java.util.*;

public class Main{
	public static String assignRoom(int H, int W, int N) {
		int cnt = 0;
		for(int w=1;w<=W;w++) {
			for(int h=1;h<=H;h++) {
				cnt++;
				if(cnt == N) {
					if(w>=10)
						return (String.valueOf(h) + String.valueOf(w));
					else
						return (String.valueOf(h) + "0" + String.valueOf(w));
				}
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			System.out.println(assignRoom(H,W,N));
		}

	}
}