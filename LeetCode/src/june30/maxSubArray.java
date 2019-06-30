package june30;

public class maxSubArray {
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int acuq = 0;
    for (int i : nums) {
      acuq += i;
      if (acuq > max) {
        max = acuq;
      }

      if (acuq <= 0) {
        acuq = 0;
      }
    }

    return max;
  }
}
