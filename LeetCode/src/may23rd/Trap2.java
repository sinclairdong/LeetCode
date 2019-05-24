package may23rd;


public class Trap2 {

  public static void main(String[] args) {
    int[] a = {5, 5, 1, 7, 1, 1, 5, 2, 7, 6};
    System.out.println(new Trap2().trap(a));
  }

  public int trap(int[] height) {
    // find left most;
    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];

    leftMax[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }
    rightMax[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      rightMax[i] = Math.max(leftMax[i + 1], height[i]);
    }
    int ans = 0;
    for (int i = 1; i < height.length - 1; i++) {
      ans += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return ans;
  }
}
