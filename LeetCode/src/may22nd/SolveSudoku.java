package may22nd;

import java.util.Set;
import java.util.HashSet;


public class SolveSudoku {
  public static void main(String[] args) {
    char[][] a = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    char[][] b = {
        {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
        {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
        {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
        {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
        {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
        {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
        {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
        {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};

    SolveSudoku s = new SolveSudoku();

    s.solveSudoku(b);


    for (int i = 0; i < b.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        System.out.print(b[i][j] + " ");
      }
      System.out.println("");
    }
    System.out.println("");

    // System.out.println("# " + min.i + " " + min.j + " " + min.available + " " + space);
    // for (int i = 0; i < cells.length; i++) {
    // for (int j = 0; j < cells[0].length; j++) {
    // System.out.print(cells[i][j]);
    // }
    // System.out.println("");
    // }
    // System.out.println("");



  }

  public void solveSudoku(char[][] board) {
    // initialize objects
    Cell[][] cells = new Cell[board.length][board[0].length];
    // initialize board
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[0].length; j++) {
        cells[i][j] = new Cell(i, j);
      }
    }

    int space = 0;
    // assign value
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[0].length; j++) {
        cells[i][j].val = board[i][j];
        if (board[i][j] != '.') {
          updateRemove(cells, cells[i][j]);
        } else {
          space++;
        }
      }
    }

    System.out.println(solveSudokuHelper(board, cells, space));

  }

  public boolean solveSudokuHelper(char[][] board, Cell[][] cells, int space) {

    if (space == 0) {
      return true;
    }
    // find the object with least option
    Cell min = findMin(cells);

    Set<Character> ava = new HashSet<>();
    ava.addAll(min.available);
    for (char s : ava) {
      min.val = s;
      Set<Cell> removed = updateRemove(cells, min);
      if (solveSudokuHelper(board, cells, space - 1)) {
        board[min.i][min.j] = min.val;
        return true;
      }
      // if doesn't work then reset and choose another
      updateAdd(removed, min);
    }

    return false;
  }

  public Set<Cell> updateRemove(Cell[][] cells, Cell cell) {

    Set<Cell> result = new HashSet<>();
    for (int i = 0; i < cells.length; i++) {
      if (cells[i][cell.j].remove(cell.val)) {
        result.add(cells[i][cell.j]);
      }
      if (cells[cell.i][i].remove(cell.val)) {
        result.add(cells[cell.i][i]);
      }
    }
    int i_c = cell.i / 3;
    int j_c = cell.j / 3;
    // remove the val for the thing
    for (int i = 0; i < 3; i++) {

      for (int j = 0; j < 3; j++) {

        if (cells[i_c * 3 + i][j_c * 3 + j].remove(cell.val)) {
          result.add(cells[i_c * 3 + i][j_c * 3 + j]);
        }
      }
    }
    return result;

  }

  public void updateAdd(Set<Cell> cells, Cell cell) {
    for (Cell c : cells) {
      c.add(cell.val);
    }

    cell.val = '.';
  }


  public Cell findMin(Cell[][] cells) {
    Cell result = new Cell(-1, -1);
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[0].length; j++) {
        if (cells[i][j].isEmpty() && result.size() > cells[i][j].size()) {
          result = cells[i][j];
        }
      }
    }

    return result;
  }

  private class Cell {
    public Character val;
    public Set<Character> available;
    public int i;
    public int j;

    public Cell(int i, int j) {
      this.i = i;
      this.j = j;
      this.available = new HashSet<>();
      for (char n = '1'; n <= '9'; n++) {
        available.add(n);
      }
    }

    public int size() {
      return this.available.size();
    }

    public boolean remove(Character c) {
      return available.remove(c);
    }

    public boolean add(Character c) {
      return available.add(c);
    }

    @Override
    public String toString() {
      return val + " ";
    }

    public boolean isEmpty() {
      return val == '.';
    }
  }
}
