package may18th;

public class Divide {
  public int divide(int dividend, int divisor) {
    boolean sign_a = divisor < 0;
    boolean sign_b = dividend < 0;
    divisor = Math.abs(divisor);
    dividend = Math.abs(dividend);
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
