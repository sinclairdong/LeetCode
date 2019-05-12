package May12th;

import java.util.Arrays;

public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    int min = Integer.MAX_VALUE;
    int min_value = target;
    for (int i = 0; i < nums.length - 2; i++) {
      int value = nums[i] + twoSumClosest(nums, target - nums[i], i + 1);
      int temp = Math.abs(target - value);
      if (min > temp) {
        min = temp;
        min_value = value;
      }

      while (nums[i] == nums[i + 1] && i + 2 < nums.length) {
        i++;
      }
    }
    return min_value;
  }

  public int twoSumClosest(int[] nums, int target, int start) {
    int min = Integer.MAX_VALUE;
    int min_value = target;
    for (int i = start; i < nums.length - 1; i++) {
      int value = nums[i] + binary_search(nums, target - nums[i], i + 1, nums.length - 1);
      int temp = Math.abs(target - value);

      if (min > temp) {
        min = temp;
        min_value = value;
      }

      while (nums[i] == nums[i + 1] && i + 2 < nums.length) {
        i++;
      }
    }
    return min_value;
  }

  public int binary_search(int[] nums, int target, int start, int end) {
    if (start >= end) {
      return nums[start];
    }

    // find mid
    int mid = (end - start) / 2 + start;
    if (nums[mid] == target) {
      return target;
    } else if (target < nums[mid]) {
      if (Math.abs(target - nums[mid]) < Math.abs(target - nums[mid - 1])) {
        return nums[mid];
      }
      return binary_search(nums, target, start, mid - 1);
    } else {
      if (Math.abs(target - nums[mid]) < Math.abs(target - nums[mid + 1])) {
        return nums[mid];
      }
      return binary_search(nums, target, mid + 1, end);
    }


  }

  public static void main(String[] args) {
    int[] a = {0, 0, 0};
    ThreeSumClosest tsc = new ThreeSumClosest();
    Arrays.sort(a);
    System.out.println(tsc.threeSumClosest(a, 1));
  }
}
