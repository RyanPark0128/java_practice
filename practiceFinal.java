import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class practiceFinal {
  public static void main(String[] args) throws IOException, FileNotFoundException, NumberFormatException {
    // System.out.println(Math.floor(3.4));
    // Random generate = new Random();
    // System.out.println(generate.nextFloat(100));
    // System.out.println(Math.random());
    // boolean[] arr = new boolean[10];
    // System.out.println(arr[9]);
    // int[] grades = { 90, 99, 55, 23, 32 };
    // System.out.println(Arrays.toString(grades));
    // multipleList("zxcxz", "asd", "asdsd", "sadsadxzczxc", "qwasd");
    // String s = "Hello World";
    // String[] result = s.split("");
    // int[] sum = { 1, 2, 3 };
    // int[] copied = Arrays.copyOf(sum, sum.length);
    // System.out.println(Arrays.toString(sum));
    // System.out.println(Arrays.toString(copied));

    // Scanner scan = new Scanner(new File("output.txt"));
    // PrintWriter fout = new PrintWriter(new File("example.txt"));

    // while (scan.hasNext()) {
    // fout.println(scan.next());
    // }

    // scan.close();
    // fout.close();

    // System.out
    // .println("backspace \b tab \t newline \n carraige return \r double quote \"
    // single quote \' backslash \\ ");
    // Scanner input = new Scanner(System.in);

    // while (input.hasNext()) {
    // System.out.println(input.next());
    // }

    // input.close();

    // String test = "aaAAbBbB";

    // System.out.println(test.charAt(test.length() - 3) ==
    // test.charAt(test.length() - 1));

    // int[] sorting = { 5, 23, 213, 3, 46, 4, 78, 9, 20, 23, 55, 68, 98, 28, 11, 59
    // };

    // Selection Sort

    // for (int i = 0; i < sorting.length; i++) {
    // int min = sorting[i];
    // int index = i;
    // int temp;
    // for (int j = i + 1; j < sorting.length; j++) {
    // if (min > sorting[j]) {
    // min = sorting[j];
    // index = j;
    // }
    // }
    // temp = sorting[i];
    // sorting[i] = sorting[index];
    // sorting[index] = temp;

    // }

    // Insertion Sort

    // int n = sorting.length;
    // for (int j = 1; j < n; j++) {
    // int key = sorting[j];
    // int i = j - 1;
    // while ((i > -1) && (sorting[i] > key)) {
    // sorting[i + 1] = sorting[i];
    // i--;
    // }
    // sorting[i + 1] = key;
    // }
    // Arrays.sort(sorting);
    // System.out.println(search(sorting, 68));
    // System.out.println(Arrays.toString(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));

    // Scanner scan = new Scanner(new File("example.txt"));
    // scan.useDelimiter("");

    // while (scan.hasNext()) {
    // System.out.println(scan.next());
    // }
    // scan.close();

    // int[] arr = { 3, 5, 1, 2, 7, 8, 9 };
    // int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9 };
    int[] arr = { 10, 10, 9, 8, 6, 5, 3, 2 };

    int count = 0;

    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] <= arr[i + 1]) {
        count++;
      }
    }

    if (count == arr.length - 1) {
      System.out.println(1);
    }
    count = 0;

    for (int j = 0; j < arr.length - 1; j++) {
      if (arr[j] >= arr[j + 1]) {
        count++;
      }
    }
    if (count == arr.length - 1) {
      System.out.println(-1);
    } else {
      System.out.println(0);
    }
  }

  public static boolean search(int a, int b) {
    if (a == b)
      return true;
    else
      return false;
  }

  public static void multipleList(String... nameList) {
    System.out.println(Arrays.toString(nameList));
  }
}