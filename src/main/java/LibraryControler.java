import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LibraryControler {

    UserInputStorage userInputStorage = new UserInputStorage();

    public ArrayList<Film> filterFilmsDependingOnDate(Library filmsList) {
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

    public Integer getRandomIndex(Library filmList){
        System.out.println("Here You have a portion of informations about one of the films from Our database that We recommend");
        Random random = new Random();
        int randomIndex = random.nextInt(filmList.getFilms().size() - 1);

        return randomIndex;

    }

    public ArrayList<Film> filterFilmsDependingOnActor(Library filmsList) {

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
}
