import java.util.*;

// Comparator인터페이스 직접 구현
class MyComparator implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		if(s1.length()==s2.length()) //같은 길이면 알파벳순
			return s1.compareTo(s2);
		return Integer.compare(s1.length(),s2.length());
	}
};

public class Main{
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		//정의한 MyComparator set에게 전달
		Set<String> set = new TreeSet<>(new MyComparator());
		int N = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			String str = sc.next();
			set.add(str);
		}
		for(String element : set)
			System.out.println(element);

		sc.close();
		
		
	}
}