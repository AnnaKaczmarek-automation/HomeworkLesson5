import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class DataCreator {

    UserInputStorage userInputStorage = new UserInputStorage();
    MovieLibrary movieLibrary = new MovieLibrary();
    public void displayMenu() {
        System.out.println("1. Select films by filtering them by date");
        System.out.println("2. View informations about random film from database");
        System.out.println("3. Select films by filtering them by actors data");
        System.out.println("4. Close the menu");
    }

    public ArrayList<Film> filterFilmsDependingOnDate(List<Film> filmsList) throws IOException {
        int date1 = userInputStorage.chooseFirstDate();
        int date2 = userInputStorage.chooseSecondDate();
        ArrayList<Film> filteredFilmsList = new ArrayList<>();
        for (Film film : filmsList)
            if (film.getYearOfProduction() >= date1|| film.getYearOfProduction() <= date2) {
                filteredFilmsList.add(film);
            }
        return filteredFilmsList;
    }

    public void displayTitle(ArrayList<Film> filteredData) {
        System.out.println("Films produced in given date range are: ");
        for (Film film : filteredData) {
            System.out.println("-" + film.getTitle());
        }
    }

    public void displayFilmInformations(List<Film> filmList) {
        Random random = new Random();
        int randomIndex = random.nextInt(filmList.size() - 1);
        String title = filmList.get(randomIndex).getTitle();
        System.out.println("title: " + title);
        int yearOfProduction = filmList.get(randomIndex).getYearOfProduction();
        System.out.println("date: " + yearOfProduction);
        String director = filmList.get(randomIndex).getDirector();
        System.out.println("director: " + director);
        String genre = filmList.get(randomIndex).getGenre();
        System.out.println("genre: " + genre);
        ArrayList<Actors> actors = filmList.get(randomIndex).getActors();
        for (Actors actor : actors) {
            System.out.println(filmList.get(randomIndex).getActors().get(0).getName() + " " + filmList.get(randomIndex).getActors().get(0).getSecondName());
        }
    }

    public ArrayList<Film> filterFilmsDependingOnActor(List<Film> filmsList) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give actors name");
        String name = scanner.nextLine();
        System.out.println("Give actors second name");
        String secondName = scanner.nextLine();
        ArrayList<Film> filteredFilmsList = new ArrayList<>();
        for (Film film : filmsList)
            if (film.getActors().get(0).getName() == name) {
                if (film.getActors().get(0).getSecondName() == secondName) {

                    filteredFilmsList.add(film);
                } else {
                    System.out.println("We do not have a film(s) with given actor in out database");
                }
            }
        return filteredFilmsList;
    }

    public void displayFilmsDependingOnActor(ArrayList<Film> filteredList) {
        System.out.println("Results matching the given criteria are listed below");

        for (Film film : filteredList) {
            System.out.println("*" + film.getTitle());
        }
    }

    public void generateOutput() throws IOException, URISyntaxException {
        int option = userInputStorage.chooseMenuOption();
        switch (option) {
            case 1:
                displayTitle(filterFilmsDependingOnDate(deserialize()));
                break;

            case 2:
                displayFilmInformations(deserialize());
                break;

            case 3:
                displayFilmsDependingOnActor(filterFilmsDependingOnActor(deserialize()));
                break;
            case 4:
                System.exit(0);

            default:
                System.out.println("Incorrect value");
        }
    }
    public List<Film> deserialize() throws JsonParseException, JsonMappingException, IOException, URISyntaxException {

//        ObjectMapper objectMapper = new ObjectMapper();
//
//        URL resource = DataCreator.class.getClassLoader().getResource("film.json");
//        assert resource != null;
//        byte[] bytes = Files.readAllBytes(Path.of("C:/Selenium_Java_course/HomeworkLesson5/src/main/java/film.json"));
//        String json = new String(bytes);
//
//        JsonNode node = objectMapper.readTree(json);
//        ArrayList<Films> parsedFilmList = new ArrayList<>();
//        if (node.isArray()) {
//            for (JsonNode jsonNode : node) {
//                Films film = objectMapper.treeToValue(jsonNode, Films.class);
//                parsedFilmList.add(film);
//            }
//        }
//           return parsedFilmList;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//        Films films = objectMapper.readValue(new File("src/main/java/film.json"), Films.class);
        Library library = objectMapper.readValue(new File("src/main/java/film.json"), Library.class);
        System.out.println(library);
        List<Film> filmsList = objectMapper.readValue(new File("src/main/java/film.json"), new TypeReference<List<Film>>() {});
        return filmsList;
    }

}



