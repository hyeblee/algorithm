class Solution {
    int answer = 0;
  
    public int solution(int chicken) {
        //처음 쿠폰은 주문한 치킨갯수만큼
        int coupon = chicken;
        
        while(coupon/10 != 0){
            //10장을 치킨으로 교환
            answer += coupon / 10;
            //쿠폰은 교환한 치킨수 + 교환하고 남은 쿠폰수
            coupon = coupon/10 + coupon % 10;
        }
        return answer;
    }
}