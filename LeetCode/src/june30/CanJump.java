package june30;

import java.util.Arrays;

public class CanJump {
  public static void main(String[] args) {
    int[] a = {2, 3, 1, 1, 4};
    System.out.println(new CanJump().canJump2(a));
  }

  public boolean canJump(int[] nums) {
    if (nums.length == 0) {
      return true;
    }
    boolean[] rechable = new boolean[nums.length];

    rechable[0] = true;

    for (int i = 0; i < nums.length; i++) {
      System.out.println(Arrays.toString(rechable));
      if (rechable[i]) {
        for (int n = 0; n <= nums[i]; n++) {
          if (n + i >= rechable.length) {
            break;
          }

          rechable[n + i] = true;
        }
      } else {
        return false;
      }
    }

    return true;
  }

  public boolean canJump2(int[] nums) {
    int furthest = 0;

    for (int i = 0; i < nums.length; i++) {
      if (i > furthest) {
        return false;
      } else {
        furthest = Math.max(furthest, i + nums[i]);
      }
    }

    return true;
  }
}
