package may15th;

import java.util.Stack;

public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(new ValidParentheses().isValid("(]"));
  }

  public boolean isValid(String s) {

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (isLeft(c)) {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char last = stack.pop();
        if (Math.abs(last - c) > 5) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  public boolean isLeft(char c) {
    return c == '(' || c == '[' || c == '{';
  }
}
