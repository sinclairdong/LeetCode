package may12th;

public class Roman_to_Int {
  public static void main(String[] args) {
    Roman_to_Int doo = new Roman_to_Int();
    System.out.println(doo.romanToInt("MCMXCIV"));
  }

  public int romanToInt(String s) {

    int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] r = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    return romanToInt_helper(s, n, r, n.length);
  }


  public int romanToInt_helper(String s, int[] n, String[] r, int bond) {
    // base case
    if (s.length() == 0) {
      return 0;
    }

    // find the largest maller number
    int i = 0;
    while (s.indexOf(r[i]) != 0 && i < bond) {
      i++;
    }

    return n[i] + romanToInt_helper(s.substring(r[i].length()), n, r, bond);
  }
}
