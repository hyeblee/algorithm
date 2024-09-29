
public class Solution {
	public int gcd(int a, int b) {
		if(a%b == 0)
			return b;
		else 
			return gcd(b, a%b);
	}
	
	public int lcm(int a, int b) {
		return a*b / gcd(a, b);
	}
	
    public int solution(int n) {
    	int lcm = 6*n/gcd(n, 6);
        int answer = lcm/6;
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution mySolution = new Solution();
		System.out.println(mySolution.solution(10));
	}

}
