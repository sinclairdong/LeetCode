package june22nd;

public class MyPow {
  double fastExpo(double n, int p) {
    if (p == 0)
      return 1;
    if (p == 1)
      return n;
    double R = fastExpo(n, p / 2);
    if (p % 2 == 0)
      return R * R;
    else
      return R * R * n;
  }

  public double myPow(double x, int n) {
    double p = 1;
    double val = 0;
    if (n > 0)
      val = x;
    else if (n < 0)
      val = 1 / x;
    else
      return 1;
    double ans = fastExpo(val, Math.abs(n));
    return ans;
  }
}
