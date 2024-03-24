package Version2;

public class Author extends Human  {
    private String author;
    public Author(String name, String surname, String author) {
        super(name, surname);
        this.author=author;
    }

    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public void displayInfo() {
        System.out.println(surname+ "\n" + name+ "\n" + author);
    }

}
