import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URISyntaxException;

public class MovieLibrary {
    public static void main(String[] args) throws IOException, URISyntaxException {
        DataCreator dataCreator = new DataCreator();

        while (true) {
            dataCreator.displayMenu();
            dataCreator.generateOutput(deserialize());
        }
    }


    public static Library deserialize() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        Library library = objectMapper.readValue(new File("src/main/java/film.json"), Library.class);
        return library;
    }
}



