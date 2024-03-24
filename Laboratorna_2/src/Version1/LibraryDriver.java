package Version1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
        Author author = new Author("Ivan", "Ivanov", "dfgdfg");
        Book book = new Book();
        book.setName("Book");
        book.setYearEdition(2022);
        book.setNumEdition(1);
        ArrayList<Author> bookAuthors = new ArrayList<>();
        bookAuthors.add(author);
        book.setList(bookAuthors);

        BookReader bookReader = new BookReader("Eugen", "Eugenov", 45, new ArrayList<>(Arrays.asList(book)));

        BookStore bookStore = new BookStore();
        bookStore.setName("Bookstore");
        bookStore.setList(new String[]{"Book1", "Book2", "Book3"});

        Library library = new Library();
        library.setName("Library");
        library.setH("Location");
        library.setListref(new String[]{"Ref1", "Ref2", "Ref3"});

        // Серіалізація об'єктів
        serializeObject("author1.bin", author);
        serializeObject("book1.bin", book);
        serializeObject("bookReader1.bin", bookReader);
        serializeObject("bookStore1.bin", bookStore);
        serializeObject("library1.bin", library);

        // Десеріалізація об'єктів
        Author deserializedAuthor = (Author) deSerializeObject("author1.bin");
        Book deserializedBook = (Book) deSerializeObject("book1.bin");
        BookReader deserializedBookReader = (BookReader) deSerializeObject("bookReader1.bin");
        BookStore deserializedBookStore = (BookStore) deSerializeObject("bookStore1.bin");
        Library deserializedLibrary = (Library) deSerializeObject("library1.bin");

        // Перевірка результатів
        System.out.println("Deserialized Author: " + deserializedAuthor.getName() + " " + deserializedAuthor.getSurname());
        System.out.println("Deserialized Book: " + deserializedBook.getName());
        System.out.println("Deserialized BookReader: " + deserializedBookReader.getName() + " " + deserializedBookReader.getSurname());
        System.out.println("Deserialized BookStore: " + deserializedBookStore.getName());
        System.out.println("Deserialized Library: " + deserializedLibrary.getName());

    }
}