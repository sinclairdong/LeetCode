package may19th;

public class Search {
  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }
    int offset = findStart(nums, 0, nums.length - 1);
    return binarySearch(nums, target, offset, 0, nums.length - 1);
  }

  public int binarySearch(int[] nums, int target, int offset, int start, int end) {


    if (start >= end && nums[map(start, offset, nums.length)] != target) {
      return -1;
    }
    int mid = (start + end) / 2;
    if (nums[map(mid, offset, nums.length)] == target) {
      return map(mid, offset, nums.length);
    } else if (target < nums[map(mid, offset, nums.length)]) {
      return binarySearch(nums, target, offset, start, mid - 1);
    } else {
      return binarySearch(nums, target, offset, mid + 1, end);
    }
  }

  public int map(int a, int offset, int length) {
    return (a + offset) % length;
  }


  public int findStart(int[] nums, int start, int end) {
    if (nums.length == 1 || nums[start] < nums[end]) {
      return 0;
    }
    if (start + 1 == end) {
      return nums[end] > nums[start] ? start : end;
    }

    int mid = (start + end) / 2;
    if (nums[start] > nums[mid]) {
      return findStart(nums, start, mid);
    } else {
      return findStart(nums, mid, end);
    }

  }

  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(new Search().search(nums, 6));
  }

}
