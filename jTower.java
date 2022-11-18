public class jTower {
  public static void main(String[] args) {

    int num = 5;
    for (int i = 0; i < num; i++) {
      String line = "";
      for (int j = 0; j < (2 * num - 1); j++) {
        if (j < (((2 * num - 1) - 2 * (i) - 1)) / 2) {
          line = line + " ";
        } else if (j >= 2 * num - 1 - (((2 * num - 1) - 2 * (i) - 1)) / 2) {
          line = line + " ";
        } else {
          line = line + "j";
        }
      }

      System.out.println(line);
    }
  }
}