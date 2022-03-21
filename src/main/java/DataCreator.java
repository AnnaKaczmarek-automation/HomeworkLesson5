import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DataCreator {

    UserInputStorage userInputStorage = new UserInputStorage();

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Select films by filtering them by date");
        System.out.println("2. View informations about random film from database");
        System.out.println("3. Select films by filtering them by actors data");
        System.out.println("4. Close the menu");
    }

    public ArrayList<Film> filterFilmsDependingOnDate(Library filmsList) throws IOException {
        int date1 = userInputStorage.chooseFirstDate();
        int date2 = userInputStorage.chooseSecondDate();
        ArrayList<Film> filteredFilmsList = new ArrayList<>();
        for (Film film : filmsList.getFilms()) {
            if (film.getYearOfProduction() >= date1 && film.getYearOfProduction() <= date2) {
                filteredFilmsList.add(film);
            }
        }
        return filteredFilmsList;
    }

    public void displayTitle(ArrayList<Film> filteredData) {

        if (filteredData.size() != 0) {
            System.out.println("Films produced in given date range are: ");
            System.out.println();
            for (Film film : filteredData) {
                System.out.println("-" + film.getTitle());
                System.out.println();
            }
        } else {
            System.out.println("Sorry, we don't have in Our database film produced in given date range");
        }
    }

    public void displayFilmInformations(Library filmList) {
        System.out.println("Here You have a portion of informations about one of the films from Our database that We recommend");
        Random random = new Random();
        int randomIndex = random.nextInt(filmList.getFilms().size() - 1);
        String title = filmList.getFilms().get(randomIndex).getTitle();
        System.out.println("title: " + title);
        int yearOfProduction = filmList.getFilms().get(randomIndex).getYearOfProduction();
        System.out.println("date: " + yearOfProduction);
        String directorName = filmList.getFilms().get(randomIndex).getDirector().getName();
        String directorSecondName = filmList.getFilms().get(randomIndex).getDirector().getSecondName();
        System.out.println("director: " + directorName + " " + directorSecondName);
        String genre = filmList.getFilms().get(randomIndex).getGenre();
        System.out.println("genre: " + genre);
        ArrayList<Actor> actors = filmList.getFilms().get(randomIndex).getActors();
        System.out.print("Starring actors: ");
        for (Actor actor : actors) {
            System.out.print(actor.getName() + "" + actor.getSecondName() + ",");
        }
        System.out.println();
    }

    public ArrayList<Film> filterFilmsDependingOnActor(Library filmsList) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give actors name");
        String name = scanner.nextLine();
        System.out.println("Give actors second name");
        String secondName = scanner.nextLine();
        ArrayList<Film> filteredFilmsList = new ArrayList<>();

        for (Film film : filmsList.getFilms()) {
            film.getActors();
            for (Actor actor : film.getActors()) {
                if (actor.getName().equals(name)) {
                    if (actor.getSecondName().equals(secondName)) {
                        filteredFilmsList.add(film);
                    }
                }
            }
        }
        return filteredFilmsList;
    }

    public void displayFilmsDependingOnActor(ArrayList<Film> filteredList) {
        if (filteredList.size() > 0) {
            System.out.println("Results matching the given criteria are listed below");
            for (Film film : filteredList) {
                System.out.println("*" + film.getTitle());
                System.out.println();
            }
        } else {
            System.out.println("Oooops! Something went wrong. Try to type values again or We just simply don't have that data in Our database");
        }
    }

    public void generateOutput() throws IOException, URISyntaxException {
        String option = userInputStorage.chooseMenuOption();
        if (StringUtils.isNumeric(option)) {
            switch (option) {
                case "1":
                    displayTitle(filterFilmsDependingOnDate(deserialize()));
                    break;

                case "2":
                    displayFilmInformations(deserialize());
                    break;

                case "3":
                    displayFilmsDependingOnActor(filterFilmsDependingOnActor(deserialize()));
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

    public Library deserialize() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        Library library = objectMapper.readValue(new File("src/main/java/film.json"), Library.class);
        return library;
    }
}



