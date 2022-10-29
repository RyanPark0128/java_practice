import java.util.Scanner;
import java.io.*;

public class Iopractice {
  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(new File("classlist.txt"));
    scan.useDelimiter("\n");
    while (scan.hasNext()) {
      System.out.println(scan.next());
    }
    scan.close();
  }

}