
package june23;

import java.util.ArrayList;
import java.util.List;

public class NQueen2 {

  public int totalNQueens(int n) {
    return helper(new Board(n), n, 0);
  }


  public int helper(Board b, int n, int k) {
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (b.cells[k][i].constrain == 0) {

        b.updateAdd(k, i);
        if (k >= n - 1) {
          result++;
        } else {
          result += helper(b, n, k + 1);
        }
        b.updateRemove(k, i);
      }
    }
    return result;
  }

  private class Board {
    public Cell[][] cells;
    public int n;

    public Board(int n) {
      cells = new Cell[n][n];
      this.n = n;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          cells[i][j] = new Cell();
        }
      }
    }

    public void updateAdd(int i, int j) {
      cells[i][j].hasQueen = true;
      // update horizontal and vertical
      for (int k = 0; k < n; k++) {
        cells[k][j].constrain++;
        cells[i][k].constrain++;
      }

      // check for diagonal
      int new_i = i;
      int new_j = j;
      while (new_i >= 0 && new_j >= 0 && new_i < n && new_j < n) {
        cells[new_i][new_j].constrain++;
        new_i++;
        new_j++;
      }
      new_i = i;
      new_j = j;
      while (new_i >= 0 && new_j >= 0 && new_i < n && new_j < n) {
        cells[new_i][new_j].constrain++;
        new_i++;
        new_j--;
      }
      new_i = i;
      new_j = j;
      while (new_i >= 0 && new_j >= 0 && new_i < n && new_j < n) {
        cells[new_i][new_j].constrain++;
        new_i--;
        new_j++;
      }
      new_i = i;
      new_j = j;
      while (new_i >= 0 && new_j >= 0 && new_i < n && new_j < n) {
        cells[new_i][new_j].constrain++;
        new_i--;
        new_j--;
      }
      cells[i][j].constrain -= 5;
    }

    public void updateRemove(int i, int j) {
      cells[i][j].hasQueen = false;
      // update horizontal and vertical
      for (int k = 0; k < n; k++) {
        cells[k][j].constrain--;
        cells[i][k].constrain--;
      }

      // check for diagonal
      int new_i = i;
      int new_j = j;
      while (new_i >= 0 && new_j >= 0 && new_i < n && new_j < n) {
        cells[new_i][new_j].constrain--;
        new_i++;
        new_j++;
      }
      new_i = i;
      new_j = j;
      while (new_i >= 0 && new_j >= 0 && new_i < n && new_j < n) {
        cells[new_i][new_j].constrain--;
        new_i++;
        new_j--;
      }
      new_i = i;
      new_j = j;
      while (new_i >= 0 && new_j >= 0 && new_i < n && new_j < n) {
        cells[new_i][new_j].constrain--;
        new_i--;
        new_j++;
      }
      new_i = i;
      new_j = j;
      while (new_i >= 0 && new_j >= 0 && new_i < n && new_j < n) {
        cells[new_i][new_j].constrain--;
        new_i--;
        new_j--;
      }
      cells[i][j].constrain += 5;
    }


    public List<String> toList() {
      List<String> result = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        StringBuilder temp = new StringBuilder();
        for (int j = 0; j < n; j++) {
          temp.append(cells[i][j].hasQueen ? "Q" : ".");
        }

        result.add(temp.toString());
      }
      return result;



    }

    @Override
    public String toString() {
      StringBuilder result = new StringBuilder();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          result.append(cells[i][j].toString());
          result.append(' ');
        }

        result.append('\n');
      }
      return result.toString();

    }


  }

  private class Cell {
    public boolean hasQueen;
    public int constrain;

    public Cell() {
      this.hasQueen = false;
      this.constrain = 0;
    }

    @Override
    public String toString() {
      return (hasQueen ? "Q" : ".") + constrain;
    }


  }
}
