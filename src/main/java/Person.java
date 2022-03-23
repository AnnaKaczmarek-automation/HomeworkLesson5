public abstract class  Person {
    private String name;
    private String secondName;
    public Person() {
    }

    public String getSecondName() {
        return secondName;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name+" "+secondName;
    }
}
