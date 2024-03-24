package Version2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



abstract public class LibraryDriver {
    private static final long serialVersionUID = 1L;
    public static void serializeObject(String fileName, Object obj){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(obj);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deSerializeObject(String fileName){
        Object obj = null;
        try {
            ObjectInputStream is = new ObjectInputStream(new
                    FileInputStream(fileName));
            obj = is.readObject();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {

        // Створення об'єктів
        Author author = new Author("Oleg", "Olegov", "dfgdfg");
        ArrayList<Author> bookAuthors = new ArrayList<>();
        bookAuthors.add(author);
        Book book = new Book("Book2",1920,2, bookAuthors);

        BookReader bookReader = new BookReader("Eugen", "Eugenov", 45, new ArrayList<>(Arrays.asList(book)));

        BookStore bookStore = new BookStore();

        Library library = new Library();
        library.setName("Library");
        library.setH("Location");
        library.setListref(new String[]{"Ref1", "Ref2", "Ref3"});

        // Серіалізація об'єктів
        serializeObject("author2.bin", author);
        serializeObject("book2.bin", book);
        serializeObject("bookReader2.bin", bookReader);
        serializeObject("bookStore2.bin", bookStore);
        serializeObject("library2.bin", library);

        // Десеріалізація об'єктів
        Author deserializedAuthor = (Author) deSerializeObject("author2.bin");
        Book deserializedBook = (Book) deSerializeObject("book2.bin");
        BookReader deserializedBookReader = (BookReader) deSerializeObject("bookReader2.bin");
        BookStore deserializedBookStore = (BookStore) deSerializeObject("bookStore2.bin");
        Library deserializedLibrary = (Library) deSerializeObject("library2.bin");

        // Перевірка результатів
        System.out.println("Deserialized Author: " + deserializedAuthor.getName() + " " + deserializedAuthor.getSurname());
        System.out.println("Deserialized Book: " + deserializedBook.getName());
        System.out.println("Deserialized BookReader: " + deserializedBookReader.getName() + " " + deserializedBookReader.getSurname());
        System.out.println("Deserialized BookStore: " + deserializedBookStore.getName());
        System.out.println("Deserialized Library: " + deserializedLibrary.getName());

    }
}