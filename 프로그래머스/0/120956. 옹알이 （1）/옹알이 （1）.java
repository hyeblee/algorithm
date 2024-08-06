class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        System.out.println(
        Integer.toString(-1));
        for(String bab : babbling){
            bab = bab.replace("aya","1");
            bab = bab.replace("ye","2");
            bab = bab.replace("woo","3");
            bab = bab.replace("ma","4");
            System.out.println(bab);
            int i;
            for(i = 0; i < bab.length(); i++){
                System.out.printf("%c\n",bab.charAt(i));
                if(bab.charAt(i)< '1' || bab.charAt(i) > '4')
                    break;
            }
            System.out.printf("i = %d\n",i);
            if(i==bab.length())
                answer++;
        }

        return answer;
        
    }
}