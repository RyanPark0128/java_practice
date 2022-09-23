import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class UserNameGen {
  public static void main(String[] args) {
    // Create Scanner
    Scanner scan = new Scanner(System.in);

    // Receive input value
    System.out.println("Hello what is your name (last,first) ?");
    String name = scan.nextLine();
    System.out.println("What is your birthday (YYYY/MM)?");
    String birthday = scan.nextLine();

    // Process the input data of name
    String username = name.split(",")[1].charAt(0) + name.split(",")[0];

    // Process the input data of birthday
    LocalDate age = LocalDate.of(Integer.parseInt(birthday.split("/")[0]), Integer.parseInt(birthday.split("/")[1]), 1);
    LocalDate currentDate = LocalDate.now();

    // Create range of characters for random data
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Create random string consists of 1uppercase, 1lowercase, and 2digits
    Random random = new Random();
    String randomName = String.valueOf(characters.charAt(random.nextInt(characters.length())))
        + String.valueOf(characters.toLowerCase().charAt(random.nextInt(characters.length())))
        + String.valueOf(random.nextInt(10)) + String.valueOf(random.nextInt(10));

    // Combine all the variable together
    System.out.println("Your username is " + username + Period.between(age, currentDate).getYears() + randomName);

    // Close the scanner
    scan.close();
  }
}