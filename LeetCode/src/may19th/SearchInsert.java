package may19th;

public class SearchInsert {
  public int searchInsert(int[] nums, int target) {
    return binarySearch(nums, target, 0, nums.length - 1);
  }

  public int binarySearch(int[] nums, int target, int start, int end) {


    if (start >= end && nums[start] != target) {
      return target > nums[start] ? start + 1 : start;
    }
    int mid = (start + end) / 2;
    if (nums[mid] == target) {
      return mid;
    } else if (target < nums[mid]) {
      return binarySearch(nums, target, start, mid - 1);
    } else {
      return binarySearch(nums, target, mid + 1, end);
    }
  }

}
