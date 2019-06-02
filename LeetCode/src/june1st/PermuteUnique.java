package june1st;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<Integer> numsList = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      numsList.add(nums[i]);
    }

    return permute(numsList);
  }

  public List<List<Integer>> permute(List<Integer> nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.size() == 1) {

      result.add(nums);
      return result;
    }

    for (int i = 0; i < nums.size(); i++) {
      Integer n = nums.get(i);
      List<Integer> newNums = new ArrayList<>();
      newNums.addAll(nums);
      newNums.remove(n);
      List<List<Integer>> temp = permute(newNums);

      for (List<Integer> l : temp) {
        l.add(n);
      }

      result.addAll(temp);
      while (i + 1 < nums.size() && nums.get(i) == nums.get(i + 1)) {
        i++;
      }
    }
    return result;
  }

}
