import java.util.Scanner;

public class Iopractice {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int x = scan.nextInt();
    int y = scan.nextInt();
    try {
      x = x / y;
      System.out.println("trying");
    } catch (ArithmeticException e) {
      y = 3;
      x = x / y;
      System.out.println("error");
    } finally {
      System.out.println("Dividing gives:" + x);
    }
  }
}