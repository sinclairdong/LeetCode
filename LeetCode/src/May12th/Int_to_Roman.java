package May12th;



public class Int_to_Roman {
  public static void main(String[] args) {
    Int_to_Roman doo = new Int_to_Roman();
    System.out.println(doo.intToRoman(1994));
  }

  public String intToRoman(int num) {

    int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] r = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    return intToRoman_helper(num, n, r, n.length);
  }


  public String intToRoman_helper(int num, int[] n, String[] r, int bond) {
    // base case
    if (num == 0) {
      return "";
    }

    // find the largest smaller number
    int i = 0;
    while (num < n[i] && i < bond) {
      i++;
    }

    return r[i] + intToRoman_helper(num - n[i], n, r, bond);
  }
}
