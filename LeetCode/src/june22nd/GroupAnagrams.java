package june22nd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> hm = new HashMap<>();

    for (String s : strs) {
      char[] temp = s.toCharArray();
      Arrays.sort(temp);
      String key = new String(temp);
      if (hm.containsKey(key)) {
        hm.get(key).add(s);
      } else {
        List<String> templ = new ArrayList<>();
        templ.add(s);
        hm.put(key, templ);
      }
    }


    return new ArrayList<List<String>>(hm.values());
  }
}
