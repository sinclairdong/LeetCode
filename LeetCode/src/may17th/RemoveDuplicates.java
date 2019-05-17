package may17th;

public class RemoveDuplicates {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int index = 0;
    int current = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != current) {
        index++;
        nums[index] = nums[i];
        current = nums[i];
      }
    }
    return index + 1;
  }
}
