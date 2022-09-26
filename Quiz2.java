import java.util.Scanner;

public class Quiz2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first date (dd:mm:yyyy)");
        String firstDate = sc.nextLine();
        System.out.println("Enter the second date (dd:mm:yyyy)");
        String secondDate = sc.nextLine();

        int firstYear = Integer.parseInt(firstDate.split(":")[2]);
        int firstMonth = Integer.parseInt(firstDate.split(":")[1]);
        int firstDay = Integer.parseInt(firstDate.split(":")[0]);
        int secondYear = Integer.parseInt(secondDate.split(":")[2]);
        int secondMonth = Integer.parseInt(secondDate.split(":")[1]);
        int secondDay = Integer.parseInt(secondDate.split(":")[0]);

        System.out.println(firstYear > secondYear || firstYear == secondYear && firstMonth > secondMonth
                || firstYear == secondYear && firstMonth == secondMonth && firstDay > secondDay);
        sc.close();
    }
}
