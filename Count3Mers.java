import java.io.*;
import java.util.Scanner;

public class Count3Mers {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner fin = new Scanner(new File("Fasta.fa"));
    PrintWriter fout = new PrintWriter("output.txt");
    fin.useDelimiter("\n");
    String sequence = "";
    int[] arr = new int[256];
    int num = 'T';
    System.out.println(num);

    while (fin.hasNext()) {
      String token = fin.next();
      if (token.charAt(0) == '>') {
        // System.out.println("Processing " + token.substring(1, token.length() - 1));
      } else {
        sequence += token;
      }
      // for (int i = 0; i < token.length(); i++) {
      // // if it is not vowel, add it to modified variable
      // if (vowels.indexOf(token.charAt(i)) == -1) {
      // modified = modified + token.charAt(i);
      // }
      // }
      // write the modified variable to new file
      // fout.print(modified);
      // System.out.println(sequence);
    }

    // for (int i = 0; i < sequence.length(); i++) {

    // }
    // int[] arr = new int[Infinity];
    // System.out.println(sequence);
    // close scanner and PrintWriter
    fout.close();
    fin.close();
  }
}
