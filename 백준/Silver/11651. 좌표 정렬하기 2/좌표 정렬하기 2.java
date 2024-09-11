import java.util.*;

class Dot{
	int x;
	int y;
}

class myComparator implements Comparator<Dot>{
	public int compare(Dot d1, Dot d2) {
		if(d1.y==d2.y)
			return Integer.compare(d1.x, d2.x);
		return Integer.compare(d1.y, d2.y);
	}
}



public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Dot[] dots = new Dot[n];
		for(int i=0;i<n;i++) {
			dots[i] = new Dot();
			dots[i].x = sc.nextInt();
			dots[i].y = sc.nextInt();
		}
		
		Arrays.sort(dots, new myComparator());
		for(Dot dot : dots) {
			System.out.println(dot.x + " " + dot.y);
		}
		
	}
}