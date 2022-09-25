import java.util.Scanner;

public class ChangeMaker {
  public static void main(String[] args) {

    // initialize the scanner
    Scanner sc = new Scanner(System.in);

    // receive input from the user
    System.out.println("Enter a monetary value ($00.00)");
    String money = sc.nextLine();

    // process the input received by dividing it into dollars and cents
    int cents = Integer.parseInt(money.substring(money.length() - 2, money.length()));
    int dollars = Integer.parseInt(money.substring(0, money.length() - 3));

    // calculate the result by dividing integers step by step and updating the value
    // after with remainders
    System.out.println("Number of 100s are " + dollars / 100);
    dollars = dollars % 100;
    System.out.println("Number of 20s are " + dollars / 20);
    dollars = dollars % 20;
    System.out.println("Number of 10s are " + dollars / 10);
    dollars = dollars % 10;
    System.out.println("Number of 5s are " + dollars / 5);
    dollars = dollars % 5;
    System.out.println("Number of Toonies are " + dollars / 2);
    dollars = dollars % 2;
    System.out.println("Number of Loonies are " + dollars / 1);
    dollars = dollars % 1;
    System.out.println("Number of Quarters are " + cents / 25);
    cents = cents % 25;
    System.out.println("Number of Dimes are " + cents / 10);
    cents = cents % 10;
    System.out.println("Number of Nickles are " + cents / 5);
    System.out.println("Sorry no pennies in Canada");

    // close the scanner
    sc.close();
  }
}