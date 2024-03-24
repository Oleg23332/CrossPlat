package Version2;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient ArrayList<Author> authors;
    private int yearEdition;
    private int numEdition;

    public Book(String name, int yearEdition, int numEdition, ArrayList<Author> authors) {
        this.name = name;
        this.yearEdition = yearEdition;
        this.numEdition = numEdition;
        this.authors = authors;
    }
    public String getName() {
        return name;
    }

    public int getNumEdition() {
        return numEdition;
    }

    public int getYearEdition() {
        return yearEdition;
    }
    public ArrayList<Author> getAuthors() {
        return authors;
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // все, що можна зберігаємо за замовчуванням
        out.writeInt(authors.size()); // ручне зберігання розміру списку авторів
        for (Author author : authors) { // ручне зберігання кожного автора
            out.writeObject(author);
        }
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // все, що можна зчитуємо за замовчуванням
        authors = new ArrayList<>(); // створюємо новий ArrayList для списку авторів
        int size = in.readInt(); // зчитуємо розмір списку авторів
        for (int i = 0; i < size; i++) { // відновлюємо список авторів
            Author author = (Author) in.readObject();
            authors.add(author);
        }
    }
}
