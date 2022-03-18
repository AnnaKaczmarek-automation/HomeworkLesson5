import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieLibrary {
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
