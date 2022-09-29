import java.util.Scanner;
import java.util.Random;

public class GenerateRandom {
  public static void main(String[] args) {
    String characters = "ACGT";
    String generated = "";
    Random random = new Random();
    generated += (characters.charAt(random.nextInt(characters.length())));
    generated += (characters.charAt(random.nextInt(characters.length())));
    generated += (characters.charAt(random.nextInt(characters.length())));
    generated += (characters.charAt(random.nextInt(characters.length())));
    generated += (characters.charAt(random.nextInt(characters.length())));
    generated += (characters.charAt(random.nextInt(characters.length())));
    generated += (characters.charAt(random.nextInt(characters.length())));
    generated += (characters.charAt(random.nextInt(characters.length())));

    Scanner sc = new Scanner(System.in);
    System.out.println("Pick a position to mutate");
    int position = sc.nextInt();

    System.out.println("The random sequence is " + generated);
    System.out.println("You entered position " + position);

    if (position > 7) {
      position = 7;
    }

    if (position < 0) {
      position = 0;
    }

    System.out.println("The mutating position is " + position);

    generated = generated.substring(0, position) + characters.charAt(random.nextInt(characters.length()))
        + generated.substring(position + 1);

    System.out.println("The new sequence is " + generated);
    sc.close();
  }
}
