import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class practiceFinal {
  public static void main(String[] args) throws IOException, FileNotFoundException, NumberFormatException {
    Scanner scan = new Scanner(System.in);
    System.out.println("enter decade");
    int decade = Integer.parseInt(scan.nextLine());
    System.out.println("enter file name");
    String fileName = scan.nextLine();
    scan.close();

    searchFile(decade, fileName);
  }

  public static void searchFile(int decade, String fileName)
      throws IOException, FileNotFoundException, NumberFormatException {

    System.out.println("Year Discovery");
    System.out.println("----------------------");
    for (int i = 0; i < 10; i++) {
      int count = 0;
      int year = decade + i;
      Scanner data = new Scanner(new File(fileName));
      data.useDelimiter("\n");
      while (data.hasNext()) {
        try {
          if (Integer.parseInt(data.next().substring(0, 3)) == year) {
            count++;
          }
        } catch (NumberFormatException e) {

        }
      }
      System.out.println(year + " " + count);
    }
  }

  // DAMMIT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

}
