package may23rd;

import java.util.Arrays;

public class Jump {
  public static void main(String[] args) {
    int[] a = {7, 6, 5, 4, 3, 2, 1};
    int[] b = {1, 1, 1, 1, 1, 1, 1};
    System.out.println(new Jump().jump(a));
  }

  public int jump(int[] nums) {
    if (nums.length == 0 || nums.length == 1) {
      return 0;
    }
    Integer[] h = new Integer[nums.length];
    int result = jump(nums, 0, h);
    System.out.println(Arrays.asList(h));
    return result;
  }

  public int jump(int[] nums, int c, Integer[] h) {
    if (nums[c] >= nums.length - c - 1) {
      h[c] = 1;
    } else if (c >= nums.length - 1) {
      return 0;
    } else if (h[c] == null) {
      int min = nums.length;
      for (int i = nums[c]; i > 0; i--) {
        int temp = jump(nums, c + i, h);
        if (min > temp) {
          min = temp;
        }
      }
      h[c] = min + 1;
    }
    return (h[c]);
  }
}
