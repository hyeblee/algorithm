import java.util.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] position = {0, 0};
        
        for (String input : keyinput) {
            switch (input) {
                case "up":
                    position[1]++;
                    break;
                case "down":
                    position[1]--;
                    break;
                case "left":
                    position[0]--;
                    break;
                case "right":
                    position[0]++;
                    break;
            }
            
            // Adjust X position within board limits
            position[0] = Math.max(-board[0] / 2, Math.min(board[0] / 2, position[0]));
            
            // Adjust Y position within board limits
            position[1] = Math.max(-board[1] / 2, Math.min(board[1] / 2, position[1]));
        }
        
        return position;
    }
}
