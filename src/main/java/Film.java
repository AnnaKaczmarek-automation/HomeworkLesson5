import java.util.ArrayList;

public class Film {
    private String title;
    private int yearOfProduction;
    private Director director;
    private String genre;
    private ArrayList<Actor> actors;

    public Film() {
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getTitle() {
        return title;
    }

    public Director getDirector() {
        return director;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public String getGenre() {
        return genre;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}