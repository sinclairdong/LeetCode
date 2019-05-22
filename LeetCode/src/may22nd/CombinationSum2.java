package may22nd;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
  // pending performance improvement
  public static void main(String[] args) {
    int[] a = {10, 1, 2, 7, 6, 1, 5};
    CombinationSum2 cs = new CombinationSum2();
    System.out.println(cs.combinationSum2(a, 8));
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    return combinationSum(0, candidates, target);
  }

  public List<List<Integer>> combinationSum(int pointer, int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();

    if (target == 0) {
      result.add(new ArrayList<Integer>());
      return result;
    }

    if (target <= 0 || pointer >= candidates.length) {
      return result;
    }

    List<List<Integer>> useFirst =
        combinationSum(pointer + 1, candidates, target - candidates[pointer]);

    for (List<Integer> l : useFirst) {
      l.add(candidates[pointer]);
    }

    int newPointer = pointer + 1;
    while (newPointer < candidates.length && candidates[newPointer] == candidates[newPointer - 1]) {
      newPointer++;
    }

    List<List<Integer>> notUseFirst = combinationSum(newPointer, candidates, target);
    result.addAll(useFirst);
    result.addAll(notUseFirst);
    return result;
  }



}
