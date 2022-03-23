import java.util.ArrayList;

public class Library {
    private ArrayList<Film> films;

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public void displayFilmInformation(int randomIndex, Library filmList) {

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
}
