package Day2;

public class day2_03 {
    public int gcd(int a, int b) {
        if(a%b == 0)
            return b;
        else{
                return gcd(b, a%b);
            }
    }
    

public int[] solution(int numer1, int denom1, int numer2, int denom2) {
    int numer = numer1*denom2 + numer2*denom1;
    int denom = denom1*denom2;
    int gcd = gcd(numer, denom);
    numer /= gcd;
    denom /= gcd;
    
    int[] answer = {numer, denom};
  
    
    return answer;
}
}