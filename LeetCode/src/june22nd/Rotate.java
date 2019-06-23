package june22nd;

public class Rotate {
  public void rotate(int[][] matrix) {
    int len = matrix.length - 1;
    for (int i = 0; i <= len / 2; i++) {
      for (int j = i; j < matrix.length - 1 - i; j++) {
        int temp = matrix[j][len - i];
        matrix[j][len - i] = matrix[i][j];
        int temp1 = matrix[len - i][len - j];
        matrix[len - i][len - j] = temp;
        temp = matrix[len - j][i];
        matrix[len - j][i] = temp1;
        matrix[i][j] = temp;
      }
    }
  }
}
