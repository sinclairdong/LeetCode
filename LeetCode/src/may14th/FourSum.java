package may14th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  public static void main(String[] args) {
    int[] a = {1, 0, -1, 0, -2, 2};
    System.out.println(new FourSum().fourSum(a, 0));
    // System.out.println(new FourSum().binarySearch(a, -1, 0, a.length - 1));
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return nSum(4, 0, nums, target);
  }


  public List<List<Integer>> nSum(int n, int start, int[] nums, int target) {
    /*
     * for (int i = 0; i < nums.length; i++) { System.out.print(nums[i] + " "); }
     * System.out.println("   " + n + "   " + start);
     */
    List<List<Integer>> result = new ArrayList<>();
    if (n == 1) {
      if (binarySearch(nums, target, start, nums.length - 1)) {
        List<Integer> list = new ArrayList<>();
        list.add(target);
        result.add(list);
      }
      return result;
    }


    result = new ArrayList<>();
    int upper = nums.length - n;
    for (int i = start; i <= upper; i++) {
      List<List<Integer>> nextLevel = nSum(n - 1, i + 1, nums, target - nums[i]);
      if (!nextLevel.isEmpty()) {
        for (List<Integer> l : nextLevel) {
          l.add(nums[i]);
          result.add(l);
        }
      }
      while (nums[i] == nums[i + 1] && i + 2 < nums.length) {
        i++;
      }
    }

    return result;

  }


  public boolean binarySearch(int[] nums, int target, int start, int end) {
    if (start > end) {
      return false;
    }

    // find mid
    int mid = (end - start) / 2 + start;
    if (nums[mid] == target) {
      return true;
    } else if (target < nums[mid]) {
      return binarySearch(nums, target, start, mid - 1);
    } else {
      return binarySearch(nums, target, mid + 1, end);
    }
  }


}
