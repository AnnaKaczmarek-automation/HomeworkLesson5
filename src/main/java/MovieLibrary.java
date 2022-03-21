
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
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
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//
//        Library library = objectMapper.readValue(new File("src/main/java/film.json"), Library.class);
//        System.out.println(library);
//        List<Film> filmsList = objectMapper.readValue(new File("src/main/java/film.json"), new TypeReference<List<Film>>() {});

        DataCreator dataCreator = new DataCreator();
        UserInputStorage userInputStorage = new UserInputStorage();

        while (true) {
            dataCreator.displayMenu();
            dataCreator.generateOutput();
        }

//        System.out.println(library.getFilms().get(0).getActors().get(0).getName());
    }

}


