package may18th;

public class Divide {

  public static void main(String[] args) {
    System.out.println(new Divide().divide(6, 3));
  }

  public int divide(int dividend, int divisor) {
    boolean sign_a = divisor < 0;
    boolean sign_b = dividend < 0;
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);

    int result = 0;
    while (dividend >= divisor) {
      result++;
      dividend -= divisor;
    }

    if (sign_a != sign_b) {
      result = 0 - result;
    }
    return result;
  }
}
