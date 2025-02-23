import java.util.*;


public class Main {

	static int N,r,c,cnt=0;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		find(r,c,(int)Math.pow(2, N));
		System.out.println(cnt);
		
	
	}
	
	static void find(int x,int y, int size) {
		if(size==1)
			return;
		
		if(x<size/2&&y<size/2) {	//왼쪽 위
			find(x,y,size/2);
		}else if(x<size/2&&size/2<=y) {	//오른쪽 위
			cnt+=(size*size/4);
			find(x,y-size/2,size/2);
		}else if(x>=size/2&&size/2>y) { //왼쪽 아래
			cnt+=(size*size/4)*2;
			find(x-size/2,y,size/2);
		}else {						//오른쪽 아래
			cnt+=(size*size/4)*3;
			find(x-size/2,y-size/2,size/2);
			
		}
			
	}
	
}
