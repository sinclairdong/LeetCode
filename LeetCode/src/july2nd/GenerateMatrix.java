package july2nd;

public class GenerateMatrix {
  public static void main(String[] args) {
    int[][] result = new GenerateMatrix().generateMatrix(6);
    for (int[] i : result) {
      for (int n : i) {
        System.out.print((n < 10 ? "0" : "") + n + "   ");
      }

      System.out.println("\n");
    }
  }

  public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    int lastindex = n - 1;
    int layers = (int) Math.ceil(n / 2);
    int counter = 1;
    for (int i = 0; i < layers; i++) {
      // top
      for (int j = i; j <= lastindex - i; j++) {
        result[i][j] = counter++;
      }
      // right
      for (int j = i + 1; j <= lastindex - i; j++) {
        result[j][lastindex - i] = counter++;
      }
      // bottom
      for (int j = lastindex - i - 1; j >= i; j--) {
        result[lastindex - i][j] = counter++;
      }

      // left
      for (int j = lastindex - i - 1; j >= i + 1; j--) {
        result[j][i] = counter++;
      }
    }
    if (n % 2 != 0) {
      result[n / 2][n / 2] = n * n;
    }
    return result;
  }
}
