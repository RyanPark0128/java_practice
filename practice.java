public class Practice {
  public static void main(String[] args) {
    int n = 5;
    for (int i = 0; i <= n; i++) {
      int m = n;
      while (m >= 0) {
        if (m == i || m + i == n) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
        m--;
      }
      System.out.println("r");

    }
  }
}
