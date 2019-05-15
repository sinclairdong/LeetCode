package may14th;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class NumToLetterCom {
  public static void main(String[] args) {
    System.out.println(new NumToLetterCom().letterCombinations("7"));
  }

  public List<String> letterCombinations(String digits) {
    Map<Character, List<String>> map = new HashMap<>();
    map.put('2', Arrays.asList("a", "b", "c"));
    map.put('3', Arrays.asList("d", "e", "f"));
    map.put('4', Arrays.asList("g", "h", "i"));
    map.put('5', Arrays.asList("j", "k", "l"));
    map.put('6', Arrays.asList("m", "n", "o"));
    map.put('7', Arrays.asList("p", "q", "r", "s"));
    map.put('8', Arrays.asList("t", "u", "v"));
    map.put('9', Arrays.asList("w", "x", "y", "z"));

    List<String> result = new ArrayList<>();

    result.add("");
    char[] digitsChar = digits.toCharArray();
    for (int i = 0; i < digitsChar.length; i++) {
      if (map.containsKey(digitsChar[i])) {
        List<String> temp = new ArrayList<>();
        List<String> letter = map.get(digitsChar[i]);
        for (String r : result) {
          for (String l : letter) {
            temp.add(r + l);
          }
        }
        result = temp;
      }
    }
    result.remove("");
    return result;
  }
}
