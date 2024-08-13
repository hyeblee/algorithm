import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int p,q,r;
        
        
        if(a==b&&b==c&&c==d) //네 숫자 모두 같은 경우
            return(a*1111);
        else if(a==b&&b==c||b==c&&c==d||c==d&&d==a||d==a&&a==b){//3개만 같은 경우 - 4가지임,,
            p = Math.max(Math.max(a,b),Math.max(c,d));
            q = Math.min(Math.min(a,b),Math.min(c,d));
            if(3*p+q != a+b+c+d){ //p가 같은 3개가 아니면
                int tmp = p;
                p = q;
                q = tmp;
            }
            return ((10*p+q)*(10*p+q));
         
        }
        else if(a==b&&c==d||a==c&&b==d||a==d&&b==c){//2개, 2개 같은 경우
            p = Math.max(Math.max(a,b),Math.max(c,d));
            q = Math.min(Math.min(a,b),Math.min(c,d));
            return (p*p-q*q);
        }
        else if(a==b||a==c||a==d||b==c||b==d||c==d){//2개만 같은 경우
            if(a == b)
                answer = c*d;
            else if(a == c)
                answer = b*d;
            else if(a == d)
                answer = b*c;
            else if(b == c)
                answer = a*d;
            else if(b == d)
                answer = a*c;
            else
                answer = a*b;
            return answer;
        }
        else //같은 게 하나도 없는 경우
            return Math.min(Math.min(a,b),Math.min(c,d));
       
    }
}