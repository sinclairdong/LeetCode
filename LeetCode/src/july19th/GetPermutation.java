package july19th;

import java.util.LinkedList;

public class GetPermutation {
  public String getPermutation(int n, int k) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    int s = 1;
    int[] muls = new int[n - 1];
    StringBuilder result = new StringBuilder();
    k--;
    for (int i = 1; i < n; i++) {
      s *= i;
      muls[i - 1] = s;
    }
    for (int i = n; i > 0; i--)
      list.addFirst(i);
    for (int i = n - 2; i > -1; i--) {
      result.append((char) (list.remove(k / muls[i]) + '0'));
      k %= muls[i];
    }
    result.append((char) (list.remove() + '0'));
    return result.toString();
  }
}
