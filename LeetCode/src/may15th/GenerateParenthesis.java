package may15th;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GenerateParenthesis {
  public static void main(String[] args) {
    List<String> a = new GenerateParenthesis().generateParenthesis(3);
    System.out.println(a);
  }

  public List<String> generateParenthesis(int n) {
    Map<Integer, List<String>> h = new HashMap<>();
    List<String> result = generateParenthesishelper(n, h);
    while (result.remove(""));
    return result;
  }

  public List<String> generateParenthesishelper(int n, Map<Integer, List<String>> h) {
    List<String> result = new ArrayList<>();
    if (n == 0) {
      result.add("");
      return result;
    }
    for (int i = 1; i < n; i++) {
      if (!h.containsKey(i)) {
        h.put(i, generateParenthesishelper(i, h));
      }
      if (!h.containsKey(n - i)) {
        h.put(n - i, generateParenthesishelper(n - i, h));
      }
      result.addAll(merge(h.get(i), h.get(n - 1)));
    }

    return result;
  }

  public List<String> merge(List<String> a, List<String> b) {
    List<String> result = new ArrayList<>();
    for (String sa : a) {
      for (String sb : b) {
        result.add("(" + sa + ")" + sb);
      }
    }

    return result;
  }
}
