import java.io.IOException;
import java.net.URISyntaxException;

public class Run {
    public static void main(String[] args) throws IOException, URISyntaxException {

        DataCreator dataCreator = new DataCreator();
        UserInputStorage userInputStorage = new UserInputStorage();



        while (true) {
            dataCreator.displayMenu();
            userInputStorage.chooseMenuOption();
            dataCreator.generateOutput();
//    dataCreator.displayTitle(dataCreator.filterFilmsDependingOnDate(dataCreator.deserialize()));

        }
    }
}
