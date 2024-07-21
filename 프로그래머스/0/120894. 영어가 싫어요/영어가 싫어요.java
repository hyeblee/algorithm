class Solution {
    public long solution(String numbers) {
        long answer = 0;

        for(int i = 0; i< numbers.length();){
            answer *= 10;
            if(numbers.substring(i).startsWith("one")){
                i+=3;
                answer += 1;
            }
            else if(numbers.substring(i).startsWith("two")){
                i+=3;
                answer += 2;
            }
              else if(numbers.substring(i).startsWith("three")){
                i+=5;
                answer += 3;
            }
              else if(numbers.substring(i).startsWith("four")){
                i+=4;
                answer += 4;
            }
              else if(numbers.substring(i).startsWith("five")){
                i+=4;
                answer += 5;
            }
              else if(numbers.substring(i).startsWith("six")){
                i+=3;
                answer += 6;
            }
              else if(numbers.substring(i).startsWith("seven")){
                i+=5;
                answer += 7;
            }
              else if(numbers.substring(i).startsWith("eight")){
                i+=5;
                answer += 8;
            }
              else if(numbers.substring(i).startsWith("nine")){
                i+=4;
                answer += 9;
            }
            else
                i+=4;

        }

        return answer;
    }
}
