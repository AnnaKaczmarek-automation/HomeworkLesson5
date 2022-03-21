import java.io.*;
import java.net.URISyntaxException;

public class MovieLibrary {
    public static void main(String[] args) throws IOException, URISyntaxException {
        DataCreator dataCreator = new DataCreator();
        UserInputStorage userInputStorage = new UserInputStorage();

        while (true) {
            dataCreator.displayMenu();
            dataCreator.generateOutput();
        }
    }

}


