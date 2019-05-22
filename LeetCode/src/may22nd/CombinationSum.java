package may22nd;

import java.util.List;
import java.util.ArrayList;


public class CombinationSum {
  // pending performance improvement
  public static void main(String[] args) {
    int[] a = {2, 3, 6, 7};
    CombinationSum cs = new CombinationSum();
    System.out.println(cs.combinationSum(a, 7));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    return combinationSum(0, candidates, target);
  }

  public List<List<Integer>> combinationSum(int pointer, int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();

    if (target == 0) {
      result.add(new ArrayList<Integer>());
      return result;
    }

    if (target <= 0 || pointer == candidates.length) {
      return result;
    }

    List<List<Integer>> useFirst =
        combinationSum(pointer, candidates, target - candidates[pointer]);

    for (List<Integer> l : useFirst) {
      l.add(candidates[pointer]);
    }

    result.addAll(useFirst);
    result.addAll(combinationSum(pointer + 1, candidates, target));
    return result;
  }



}
