import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.net.URISyntaxException;

public class DataCreator {

    UserInputStorage userInputStorage = new UserInputStorage();
    LibraryControler libraryControler = new LibraryControler();
    Library library = new Library();

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Select films by filtering them by date");
        System.out.println("2. View informations about random film from database");
        System.out.println("3. Select films by filtering them by actors data");
        System.out.println("4. Close the menu");
    }

    public void generateOutput(Library library) throws IOException, URISyntaxException {
        String option = userInputStorage.chooseMenuOption();
        if (StringUtils.isNumeric(option)) {
            switch (option) {
                case "1":
                    libraryControler.displayTitle(libraryControler.filterFilmsDependingOnDate(library));
                    break;


                case "2":
                    library.displayFilmInformation(libraryControler.getRandomIndex(library), library);
                    break;

                case "3":
                    libraryControler.displayFilmsDependingOnActor(libraryControler.filterFilmsDependingOnActor(library));
                    break;
                case "4":
                    System.exit(0);

                default:
                    System.out.println("Incorrect value");
            }
        } else {
            System.out.println("Incorrect value. Given value is not a number");
        }
    }
}


