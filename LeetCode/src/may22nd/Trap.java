package may22nd;

public class Trap {

  public static void main(String[] args) {
    int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(new Trap().trap(a));
  }

  public int trap(int[] height) {
    // tomorrow improve performance
    // find local minimum and local maximum
    // use maps;
    int counter = 0;
    boolean flagFinish = true;
    boolean flagEdge = false;
    int result = 0;
    int temp = 0;

    while (flagFinish) {
      flagFinish = false;
      flagEdge = false;
      temp = 0;
      for (int i = 0; i < height.length; i++) {
        if (height[i] > counter) {
          flagFinish = true;
          if (flagEdge) {
            result += temp;
            temp = 0;
          } else {
            flagEdge = true;
          }
        } else {
          if (flagEdge) {
            temp++;
          }
        }

      }
      counter++;
    }

    return result;
  }
}
