package may12th;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {

    if (strs.length == 0) {
      return "";
    }
    String result = strs[0];

    for (String s : strs) {

      String temp = "";
      for (int i = 0; i < Math.min(result.length(), s.length()); i++) {
        if (s.charAt(i) == result.charAt(i)) {
          temp += s.charAt(i);
        }
      }

      result = temp;
    }
    return result;
  }
}
