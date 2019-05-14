package may12th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args) {
    int[] nums = {0, 0, 0, 0};
    List<List<Integer>> result = new ThreeSum().threeSum(nums);

    for (List<Integer> l : result) {
      for (Integer i : l) {
        System.out.print(i + "    ");
      }
      System.out.println("");
    }
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> num = new ArrayList<>();
    for (int i : nums) {
      num.add(i);
    }
    for (int i = 0; i < num.size(); i++) {

      for (int n = i + 1; n < num.size(); n++) {

        for (int j = n + 1; j < num.size(); j++) {

          if (num.get(i) + num.get(j) + num.get(n) == 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(num.get(i));
            temp.add(num.get(j));
            temp.add(num.get(n));
            Collections.sort(temp);
            if (!result.contains(temp)) {
              result.add(temp);
            }
          }

        }

      }
    }
    return result;

  }
}
