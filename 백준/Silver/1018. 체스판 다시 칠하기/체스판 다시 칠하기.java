import java.util.*;


public class Main {
	
	
	// 8x8 보드를 새로 칠하는 제일 작은 횟수 반환하는 함수
	// 메서드는 항상 클래스 안에 위치해야한다.
	static int paint(char[][] board, int xStart, int yStart) { 
		int startBlack = 0; //검은색으로 시작하는 보드로 만들기 위해 칠해야하는 갯수
		int startWhite = 0; //흰색으로 시작하는 보드로 만들기 위해 칠해야하는 갯수
		
		for(int i=xStart;i<xStart+8;i++) {
			for(int j=yStart;j<yStart+8;j++) {
				if((i+j)%2==0) {//처음 시작과 같은색 타일이어야함.
					if(board[i][j]=='B')
						startWhite++;
					else
						startBlack++;
				}
				else {//두번째타일과 같은색이어야함.
					if(board[i][j]=='W')
						startWhite++;
					else
						startBlack++;
				}
			}
		}
		return Math.min(startWhite, startBlack);
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		
		
		int min = N*M;
		char[][] input = new char[N][M];
		for(int i=0;i<N;i++) {
			String str = sc.next();
			input[i] = str.toCharArray();
		}
		
		
		
		for(int i=0;i<=N-8;i++) {
			for(int j=0;j<=M-8;j++) {
				int result = paint(input,i,j);
				if(result<min)
					min=result;
			}
		
			if(min==0)
				break;
		}
		System.out.println(min);
	}
}