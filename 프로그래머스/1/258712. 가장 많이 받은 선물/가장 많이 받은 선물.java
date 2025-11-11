import java.util.*;
import java.io.*;

class Solution {
    // 주고받았다면, 더 많이 준 사람이 다음달에 선물 1개 받음
    // 없거나 같다면, 이번 달 선물지수가 큰 사람이 선물 1개 받음
    // 선물지수까지 크다면 선물 안받음
    // 다음달 최다 선물 받을 개수
    
    // 1. 선물 지수를 기록한다. (받은 수 - 준 수)
    // 2. 모든 사람 조합으로 누가 줄 지 결정한다.
    
    static int n;
    static int[][] history; // 주고받은 선물 기록 history[0][1] 0이 1에게 준 갯수
    static int[] giftScore; // giftScore[0] -> 0번 사람의 선물지수
    static int[] nextMonth; // 다음달 받을 갯수
    
    static void printArr(int[][] arr) {
        for(int i=0;i<n;i++) {
            printAr(arr[i]);
        }
        System.out.println();
    }
    
    static void printAr(int[] arr) {
        for(int i=0;i<n;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        n = friends.length;
        
        history = new int[n][n];
        giftScore = new int[n];
        nextMonth = new int[n];
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(friends[i], i);
        }
        
        // history 계산하기
        for(String str: gifts) {
            String[] arr = str.split(" ");
            int giver = map.get(arr[0]);
            int receiver = map.get(arr[1]);
            
            history[giver][receiver]++;
            // 선물 지수 계산하기
            giftScore[giver]++;
            giftScore[receiver]--;
        }
        
        // 다음 달 계산하기
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                // i와 j의 기록 분석 후 둘 중 누가 받을지 결정
                // 1. 둘이 주고받은 기록이 있다.
                // printAr(nextMonth);
                // System.out.println(i + ", " + j);
                if (history[i][j]!=0 || history[j][i] != 0) {
                    if (history[i][j] > history[j][i]) {
                        nextMonth[i]++;
                        continue;
                    } else if (history[i][j] < history[j][i]) {
                        nextMonth[j]++;
                        continue;
                    }
                }
                // 2. 둘이 주고받은 기록 없거나, 똑같이 주고받아서 선물 지수로 비교
                if (giftScore[i] > giftScore[j]) {
                    nextMonth[i]++;
                } else if (giftScore[j] > giftScore[i]) {
                    nextMonth[j]++;
                }
            }
        }
        
        // printArr(history);
        // printAr(giftScore);
        // printAr(nextMonth);
        
        Arrays.sort(nextMonth);
        
        
        
        
        
        
        return nextMonth[n-1];
    }
}