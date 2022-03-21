import java.util.Scanner;

public class UserInputStorage {

    public String chooseMenuOption() {
        System.out.println("Select one of given options");
        Scanner scanner = new Scanner(System.in);
        String usersChoice = scanner.nextLine();
        return usersChoice;
    }

    public Integer chooseFirstDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select first year in a year range");
        int firstYear = scanner.nextInt();
        return firstYear;
    }

    public Integer chooseSecondDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select second year in a year range");
        int secondYear = scanner.nextInt();
        return secondYear;
    }
}

