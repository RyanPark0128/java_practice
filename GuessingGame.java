import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
  public static int getNumber(int i, int j) {
    Random random = new Random();
    return random.nextInt(i, j);
  }

  public static int getGuess(Scanner sc) {
    System.out.println("What is your guess");
    return Integer.parseInt(sc.nextLine());
  }

  public static int increaseCount(int count) {
    return count += 1;
  }

  public static boolean isRight(int guess, int number) {
    if (guess > number) {
      System.out.println("Guess is too high");
    } else if (guess < number) {
      System.out.println("Guess is too low");
    }
    return guess == number;
  }

  public static String winMsg(int count) {
    if (count == 1) {
      return "It took you " + count + " guess to guess the number ";
    }
    return "It took you " + count + " guesses to guess the number ";
  }

  public static boolean playAgain(Scanner sc) {
    while (true) {
      System.out.println("Would you like to play again (Y/N)");
      String answer = sc.nextLine();
      if (answer.compareTo("Y") == 0) {
        return true;
      } else if (answer.compareTo("N") == 0) {
        return false;
      } else {
        System.out.println("INVALID INPUT");
      }
    }
  }

  public static int resetCount() {
    return 0;
  }

  public static void main(String[] args) {
    int number = getNumber(1, 10);
    Scanner sc = new Scanner(System.in);
    int guess;
    boolean play = true;
    int count = 0;
    while (play) {
      do {
        guess = getGuess(sc);
        count = increaseCount(count);
      } while (!isRight(guess, number));
      System.out.println(winMsg(count) + number);
      play = playAgain(sc);
      if (play) {
        number = getNumber(1, 10);
        count = resetCount();
      }
    }

    sc.close();
  }
}
