import java.util.Scanner;

public class ProScore {
    public static String readInSequence(Scanner sc) {
        System.out.println("Enter a sequence");
        String input;
        while (true) {
            input = sc.nextLine();
            if (isValidSequence(input)) {
                break;
            }
            System.out.println("Invalid sequence, Try Again");
        }
        return input;
    }

    public static boolean isValidSequence(String seq) {
        String pSequence = "ARNDCQEGHILKMFPSTWYVBZX*";
        seq = seq.toUpperCase();
        for (int i = 0; i < seq.length(); i++) {
            if (pSequence.indexOf(seq.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    public static String makeEqualLength(String seq, int toAdd) {
        for (int i = 0; i < toAdd; i++) {
            seq += "*";
        }
        return seq;
    }

    public static int scoreNucleotides(String seq1, String seq2, int[][] blosum62) {
        System.out.println("Comparing sequences:");
        System.out.println(seq1);
        System.out.println(seq2);
        seq1 = seq1.toUpperCase();
        seq2 = seq2.toUpperCase();
        int sum = 0;
        for (int i = 0; i < seq1.length(); i++) {
            sum = sum + blosum62[proToIndex(seq1.charAt(i))][proToIndex(seq2.charAt(i))];
        }
        return sum;
    }

    public static int proToIndex(char protein) {
        String pSequence = "ARNDCQEGHILKMFPSTWYVBZX*";
        return pSequence.indexOf(protein);
    }

    public static void main(String[] args) {
        int[][] blosum62 = {
                { 4, -1, -2, -2, 0, -1, -1, 0, -2, -1, -1, -1, -1, -2, -1, 1, 0, -3, -2, 0, -2, -1, 0, -4 },
                { -1, 5, 0, -2, -3, 1, 0, -2, 0, -3, -2, 2, -1, -3, -2, -1, -1, -3, -2, -3, -1, 0, -1, -4 },
                { -2, 0, 6, 1, -3, 0, 0, 0, 1, -3, -3, 0, -2, -3, -2, 1, 0, -4, -2, -3, 3, 0, -1, -4 },
                { -2, -2, 1, 6, -3, 0, 2, -1, -1, -3, -4, -1, -3, -3, -1, 0, -1, -4, -3, -3, 4, 1, -1, -4 },
                { 0, -3, -3, -3, 9, -3, -4, -3, -3, -1, -1, -3, -1, -2, -3, -1, -1, -2, -2, -1, -3, -3, -2, -4 },
                { -1, 1, 0, 0, -3, 5, 2, -2, 0, -3, -2, 1, 0, -3, -1, 0, -1, -2, -1, -2, 0, 3, -1, -4 },
                { -1, 0, 0, 2, -4, 2, 5, -2, 0, -3, -3, 1, -2, -3, -1, 0, -1, -3, -2, -2, 1, 4, -1, -4 },
                { 0, -2, 0, -1, -3, -2, -2, 6, -2, -4, -4, -2, -3, -3, -2, 0, -2, -2, -3, -3, -1, -2, -1, -4 },
                { -2, 0, 1, -1, -3, 0, 0, -2, 8, -3, -3, -1, -2, -1, -2, -1, -2, -2, 2, -3, 0, 0, -1, -4 },
                { -1, -3, -3, -3, -1, -3, -3, -4, -3, 4, 2, -3, 1, 0, -3, -2, -1, -3, -1, 3, -3, -3, -1, -4 },
                { -1, -2, -3, -4, -1, -2, -3, -4, -3, 2, 4, -2, 2, 0, -3, -2, -1, -2, -1, 1, -4, -3, -1, -4 },
                { -1, 2, 0, -1, -3, 1, 1, -2, -1, -3, -2, 5, -1, -3, -1, 0, -1, -3, -2, -2, 0, 1, -1, -4 },
                { -1, -1, -2, -3, -1, 0, -2, -3, -2, 1, 2, -1, 5, 0, -2, -1, -1, -1, -1, 1, -3, -1, -1, -4 },
                { -2, -3, -3, -3, -2, -3, -3, -3, -1, 0, 0, -3, 0, 6, -4, -2, -2, 1, 3, -1, -3, -3, -1, -4 },
                { -1, -2, -2, -1, -3, -1, -1, -2, -2, -3, -3, -1, -2, -4, 7, -1, -1, -4, -3, -2, -2, -1, -2, -4 },
                { 1, -1, 1, 0, -1, 0, 0, 0, -1, -2, -2, 0, -1, -2, -1, 4, 1, -3, -2, -2, 0, 0, 0, -4 },
                { 0, -1, 0, -1, -1, -1, -1, -2, -2, -1, -1, -1, -1, -2, -1, 1, 5, -2, -2, 0, -1, -1, 0, -4 },
                { -3, -3, -4, -4, -2, -2, -3, -2, -2, -3, -2, -3, -1, 1, -4, -3, -2, 11, 2, -3, -4, -3, -2, -4 },
                { -2, -2, -2, -3, -2, -1, -2, -3, 2, -1, -1, -2, -1, 3, -3, -2, -2, 2, 7, -1, -3, -2, -1, -4 },
                { 0, -3, -3, -3, -1, -2, -2, -3, -3, 3, 1, -2, 1, -1, -2, -2, 0, -3, -1, 4, -3, -2, -1, -4 },
                { -2, -1, 3, 4, -3, 0, 1, -1, 0, -3, -4, 0, -3, -3, -2, 0, -1, -4, -3, -3, 4, 1, -1, -4 },
                { -1, 0, 0, 1, -3, 3, 4, -2, 0, -3, -3, 1, -1, -3, -1, 0, -1, -3, -2, -2, 1, 4, -1, -4 },
                { 0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, 0, 0, -2, -1, -1, -1, -1, -1, -4 },
                { -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, -4, 1 } };
        Scanner sc = new Scanner(System.in);
        String sequenceOne = readInSequence(sc);
        String sequenceTwo = readInSequence(sc);
        if (sequenceOne.length() > sequenceTwo.length()) {
            sequenceTwo = makeEqualLength(sequenceTwo, sequenceOne.length() - sequenceTwo.length());
        } else if (sequenceOne.length() < sequenceTwo.length()) {
            sequenceOne = makeEqualLength(sequenceOne, sequenceTwo.length() - sequenceOne.length());
        }
        System.out.println("Score is: " + scoreNucleotides(sequenceOne, sequenceTwo, blosum62));
    }

}