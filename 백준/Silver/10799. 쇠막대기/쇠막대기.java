import java.io.*;
import java.util.*;


public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    ArrayDeque<Character> stack = new ArrayDeque<Character>();
    int result = 0;
    char[] chars = input.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if(chars[i] == '('&&chars[i+1] == ')') { // 레이저인경우
        result += stack.size();
        i++;
        continue;
      }
      if(chars[i] == '(')
        stack.push(chars[i]);
      if(chars[i] == ')'&&!stack.isEmpty()&& stack.peekLast()=='('){
        stack.pop();
        result+=1;
      }
    }

    System.out.println(result);
  }
}