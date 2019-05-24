package may23rd;

public class IsMatch {
  public static void main(String[] args) {
    System.out.println(new IsMatch().isMatch(
        "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
        "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
  }

  public boolean isMatch(String s, String p) {
    return isMatch(s, opt(p), 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
  }

  public String opt(String s) {
    boolean flag = false;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '*') {
        flag = false;
        result.append(s.charAt(i));
      } else if (!flag) {
        result.append(s.charAt(i));
        flag = true;
      }
    }
    return result.toString();
  }

  public boolean isMatch(String s, String p, int n, int m, Boolean[][] h) {

    if (h[n][m] != null) {
      return h[n][m];
    } else if (n == s.length() && (m == p.length() || p.substring(m).equals("*"))) {
      h[n][m] = true;
    } else if ((n == s.length() && m != p.length()) || (n != s.length() && m == p.length())) {
      h[n][m] = false;
    } else if (p.charAt(m) == '?') {
      h[n][m] = isMatch(s, p, n + 1, m + 1, h);
    } else if (p.charAt(m) == '*') {
      h[n][m] = isMatch(s, p, n, m + 1, h) || isMatch(s, p, n + 1, m, h);
    } else {
      if (s.charAt(n) != p.charAt(m)) {
        h[n][m] = false;
      } else {
        h[n][m] = isMatch(s, p, n + 1, m + 1, h);
      }
    }

    return h[n][m];
  }
}
