import java.util.*;

public class practiceFinal {
  public static void main(String[] args) {
    // System.out.println(Math.floor(3.4));
    // Random generate = new Random();
    // System.out.println(generate.nextFloat(100));
    // System.out.println(Math.random());
    boolean[] arr = new boolean[10];
    // System.out.println(arr[9]);
    int[] grades = { 90, 99, 55, 23, 32 };
    // System.out.println(Arrays.toString(grades));
    multipleList("zxcxz", "asd", "asdsd", "sadsadxzczxc", "qwasd");

  }

  public static void multipleList(String... nameList) {
    System.out.println(Arrays.toString(nameList));
  }
}