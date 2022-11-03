import java.io.*;
import java.util.Scanner;

public class Count3Mers {
  // method converts numbers to X(representing 10) and remainder
  public static String convertNumber(int num) {
    String converted = "";
    for (int i = 0; i < num / 10; i++) {
      converted += 'X';
    }
    return converted + '+' + String.valueOf(num % 10);
  }

  // Method converts 3-mers character to series of ASCII code then sums them
  // up as string and finally converting it back to integer.
  // For example, A is 65 in ASCII Code. Sequence of AAA in ASCII Code would be
  // 656565. In order to convert the number as intended, each item in the sequence
  // needs to be converted to its ASCII Code first(Integer). And then it needs to
  // be converted to String for the addition. Finally converting back to integer
  // to be used as index for array.
  public static int convertSequence(String sequence, int startingPoint) {
    return Integer.parseInt(
        String.valueOf((int) sequence.charAt(startingPoint)) + String.valueOf((int) sequence.charAt(startingPoint + 1))
            + String.valueOf((int) sequence.charAt(startingPoint + 2)));
  }

  public static void main(String[] args) throws FileNotFoundException {
    // Initialize the Scanner
    Scanner fin = new Scanner(new File("Fasta.fa"));
    // Initialize the PrintWriter
    PrintWriter fout = new PrintWriter("output.txt");
    // use delimiter to process data into a token.
    fin.useDelimiter("\n");
    String sequence = "";

    while (fin.hasNext()) {
      String token = fin.next();
      // if token's first character is >. It will print out message. Else, the token
      // is combined with previous tokens with a space to separate them.
      if (token.charAt(0) == '>') {
        System.out.println("Processing " + token.substring(1, token.length() - 1));
      } else {
        sequence += " " + token;
      }
    }

    // initializes array with 848485, because the maximum number of index it
    // requires would be TTT(848484)
    int[] arr = new int[848485];

    // Loops through the sequence and add 1 to corresponding index(ASCII Code)
    for (int i = 0; i < sequence.length() - 2; i++) {
      int num = convertSequence(sequence, i);
      arr[num] = arr[num] + 1;
    }

    // initializes the list for all the possible combinations for 3-mers
    String[] list = { "AAA", "CAA", "GAA", "TAA", "ACA", "CCA", "GCA", "TCA", "AGA", "CGA", "GGA", "TGA", "ATA", "CTA",
        "GTA", "TTA", "AAC", "CAC", "GAC", "TAC", "ACC", "CCC", "GCC", "TCC", "AGC", "CGC", "GGC", "TGC", "ATC", "CTC",
        "GTC", "TTC", "AAG", "CAG", "GAG", "TAG", "ACG", "CCG", "GCG", "TCG", "AGG", "CGG", "GGG", "TGG", "ATG", "CTG",
        "GTG", "TTG", "AAT", "CAT", "GAT", "TAT", "ACT", "CCT", "GCT", "TCT", "AGT", "CGT", "GGT", "TGT", "ATT", "CTT",
        "GTT", "TTT" };

    // loops through the list and convert each sequence into the corresponding ASCII
    // sequence and look them up in the array to retrieve the value.
    // Writes the value to output.txt in a correct format
    for (int i = 0; i < list.length; i++) {
      int num = convertSequence(list[i], 0);
      fout.println(list[i] + " : " + convertNumber(arr[num]));
    }

    // closes Scanner and PrintWriter.
    fout.close();
    fin.close();
  }
}
