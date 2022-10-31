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
        fin.useDelimiter("\n");

        while (fin.hasNext()) {
            String token = fin.next();
            String modified = "";
            for (int i = 0; i < token.length(); i++) {
                if (vowels.indexOf(token.charAt(i)) == -1) {
                    modified = modified + token.charAt(i);
                }
            }
            fout.print(modified);
        }
        fout.close();
        fin.close();
    }
}
