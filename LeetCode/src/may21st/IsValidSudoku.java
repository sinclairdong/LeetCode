package may21st;

public class IsValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    int[][] col = new int[board.length][board[0].length];
    int[][] sub = new int[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      int[] row = new int[9];
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != '.') {
          int val = (int) board[i][j] - (int) '0';
          int subRowNum = i / 3 * 3 + j / 3;
          if (row[val - 1] > 0)
            return false;
          else
            row[val - 1] = val;

          if (col[j][val - 1] > 0)
            return false;
          else
            col[j][val - 1] = val;

          if (sub[subRowNum][val - 1] > 0)
            return false;
          else
            sub[subRowNum][val - 1] = val;
        }

      }
    }
    return true;
  }
}
