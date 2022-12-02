import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class practiceFinal {
  public static void main(String[] args) throws IOException, FileNotFoundException {
    // System.out.println(Math.floor(3.4));
    // Random generate = new Random();
    // System.out.println(generate.nextFloat(100));
    // System.out.println(Math.random());
    boolean[] arr = new boolean[10];
    // System.out.println(arr[9]);
    int[] grades = { 90, 99, 55, 23, 32 };
    // System.out.println(Arrays.toString(grades));
    // multipleList("zxcxz", "asd", "asdsd", "sadsadxzczxc", "qwasd");
    String s = "Hello World";
    String[] result = s.split("");
    int[] sum = { 1, 2, 3 };
    int[] copied = Arrays.copyOf(sum, sum.length);
    // System.out.println(Arrays.toString(sum));
    // System.out.println(Arrays.toString(copied));

    // Scanner scan = new Scanner(new File("output.txt"));
    // PrintWriter fout = new PrintWriter(new File("example.txt"));

    // while (scan.hasNext()) {
    // fout.println(scan.next());
    // }

    // scan.close();
    // fout.close();

    System.out
        .println("backspace \b tab \t newline \n carraige return \r double quote \" single quote \' backslash \\   ");
    Scanner input = new Scanner(System.in);

    while (input.hasNext()) {
      System.out.println(input.next());
    }

    input.close();
  }

  public static void multipleList(String... nameList) {
    System.out.println(Arrays.toString(nameList));
  }
}