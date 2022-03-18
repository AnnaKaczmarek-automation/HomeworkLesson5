import java.util.ArrayList;

public class Film {

    //Każdy film powinien mieć: nazwę, tytuł, rok wydania, reżysera, gatunek oraz listę aktorów
    String title;
    int yearOfProduction;
    String director;
    String genre;
    ArrayList<Actors> actors;

    //    public Films(String title, int yearOfProduction, String director, String genre, ArrayList<Actors> actors) {
//        this.title = title;
//        this.yearOfProduction = yearOfProduction;
//        this.director = director;
//        this.genre = genre;
//        this.actors = actors;
//    }
    public Film() {

    }

    public ArrayList<Actors> getActors() {
        return actors;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getTitle() {
        return title;
    }
}