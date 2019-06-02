package june1st;

import java.util.List;
import java.util.ArrayList;


public class Permute {
  public List<List<Integer>> permute(int[] nums) {
    List<Integer> numsList = new ArrayList<>();
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


    for (Integer i : nums) {
      List<Integer> newNums = new ArrayList<>();
      newNums.addAll(nums);
      newNums.remove(i);
      List<List<Integer>> temp = permute(newNums);

      for (List<Integer> l : temp) {
        l.add(i);
      }

      result.addAll(temp);
    }
    return result;
  }


}
