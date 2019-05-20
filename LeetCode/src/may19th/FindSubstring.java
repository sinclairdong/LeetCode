package may19th;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FindSubstring {
  public static void main(String[] args) {
    String[] words = {"fooo", "barr", "wing", "ding", "wing"};
    System.out.println(new FindSubstring()
        .findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", words));
  }


  public List<Integer> findSubstring(String s, String[] words) {

    Arrays.sort(words);
    String[] temp = new String[words.length];
    List<Integer> result = new ArrayList<>();

    if (s == "" || s == null || words.length == 0 || words == null) {
      return result;
    }
    int length = words[0].length();
    int upperBond = s.length() - words.length * length;

    for (int i = 0; i <= upperBond; i++) {
      for (int j = 0; j < words.length; j++) {
        temp[j] = s.substring(i + j * length, i + (j + 1) * length);
      }

      Arrays.sort(temp);
      if (checkArray(temp, words)) {
        result.add(i);
      }
    }

    return result;

  }

  private boolean checkArray(String[] a, String[] b) {
    for (int i = 0; i < a.length; i++) {
      if (!a[i].equals(b[i])) {
        return false;
      }
    }

    return true;
  }
  // public boolean isMatch(String[] s, String[] words) {
  // Arrays.sort(s);
  // return
  //
  // }
}
