public class Directors {


    String name;
    String secondName;

    public Directors(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }
}
/*






Tutaj zostawiam link do tego jak użyć tej biblioteki w celu deserializacji https://www.baeldung.com/jackson-deserialization

Stwórz menu w programie, które będzie wyświetlane użytkownikowi w konsoli, wraz z obsługą wybranych przez niego opcji:

               1. Podaj dwie daty aby wyświetlić nazwy filmów wydanych pomiędzy tymi datami

               2. Wyświetl wszystkie informacje o losowym filmie

               3. Podaj imię i nazwisko aktora aby wyświetlić nazwy filmów w jakich zagrał

P.S. tym razem nie baw się już w żadną obsługę wyjątków (typu InputMismatchException) przy wybieraniu menu. Zakładamy, że użytkownik podaje dane nie popełniając błędów.



Komentarz do opcji 2: Wyświetlenie wszystkich informacji o filmie rozumiem jako wypisanie ich np. w takim formacie:

title: The Shawshank Redemption

director: Frank Darabont

genre: drama

date: 1994

actors: Tim Robbins, Morgan Freeman, Bob Gunton



Powyższy efekt powinien być uzyskany poprzez nadpisania metody toString() w klasach typu Movie, Actor itd.. *///