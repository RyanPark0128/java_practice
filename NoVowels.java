import java.io.*;
import java.util.Scanner;

public class NoVowels {
    public static void main(String[] args) throws FileNotFoundException {
        // initialize file with scanner
        Scanner fin = new Scanner(new File("test.txt"));
        // initialize PrintWriter
        PrintWriter fout = new PrintWriter("output.txt");
        // define all vowels as variable
        String vowels = "aeiouAEIOU";
        // use delimiter to process data
        fin.useDelimiter("\n");
        // use while loop to go through all the tokens
        while (fin.hasNext()) {
            String token = fin.next();
            String modified = "";
            for (int i = 0; i < token.length(); i++) {
                // if it is not vowel, add it to modified variable
                if (vowels.indexOf(token.charAt(i)) == -1) {
                    modified = modified + token.charAt(i);
                }
            }
            // write the modified variable to new file
            fout.print(modified);
        }
        // close scanner and PrintWriter
        fout.close();
        fin.close();
    }
}
