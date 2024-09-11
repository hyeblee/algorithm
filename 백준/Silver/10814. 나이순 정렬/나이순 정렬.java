import java.util.*;

class Member implements Comparator<Member>{
	int age;
	String name;

	public int compare(Member o1, Member o2) {
		return Integer.compare(o1.age,o2.age);
		
	}
	
	
	
}


public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Member[] members = new Member[N];
		
		for(int i=0;i<N;i++) {
			members[i] = new Member();
			members[i].age = sc.nextInt();
			members[i].name = sc.next();
		}
		
		
		Arrays.sort(members, new Member());
		
		for(Member member : members) {
			System.out.println(member.age + " " + member.name);
		}
		
	}
}