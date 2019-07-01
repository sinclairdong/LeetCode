package june30;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Merge {
  public int[][] merge(int[][] intervals) {
    List<int[]> result = new ArrayList<>();
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    if (intervals.length > 1) {
      
    }
    return (int[][]) result.toArray();
  }
}
