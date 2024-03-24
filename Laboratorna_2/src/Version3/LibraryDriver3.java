package Version3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

abstract public class LibraryDriver3 {
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
        Author3 author = new Author3("Oleg", "Olegov", "dfgdfg");
        ArrayList<Author3> bookAuthors = new ArrayList<>();
        bookAuthors.add(author);
        Book3 book = new Book3("Book3",1920,2, bookAuthors);

        BookReader3 bookReader = new BookReader3("Eugen", "Eugenov", 45, new ArrayList<>(Arrays.asList(book)));

        BookStore3 bookStore = new BookStore3("ATHORS", new String[]{"DDFSD","LLSOO"});

        Library3 library = new Library3();
        library.setName("Library");
        library.setH("Location");
        library.setListref(new String[]{"Ref1", "Ref2", "Ref3"});

        // Серіалізація об'єктів
        serializeObject("author3.bin", author);
        serializeObject("book3.bin", book);
        serializeObject("bookReader3.bin", bookReader);
        serializeObject("bookStore3.bin", bookStore);
        serializeObject("library3.bin", library);

        // Десеріалізація об'єктів
        Author3 deserializedAuthor = (Author3) deSerializeObject("author3.bin");
        Book3 deserializedBook = (Book3) deSerializeObject("book3.bin");
        BookReader3 deserializedBookReader = (BookReader3) deSerializeObject("bookReader3.bin");
        BookStore3 deserializedBookStore = (BookStore3) deSerializeObject("bookStore3.bin");
        Library3 deserializedLibrary = (Library3) deSerializeObject("library3.bin");

        // Перевірка результатів
        System.out.println("Deserialized Author: " + deserializedAuthor.getName() + " " + deserializedAuthor.getSurname());
        System.out.println("Deserialized Book: " + deserializedBook.getName());
        System.out.println("Deserialized BookReader: " + deserializedBookReader.getName() + " " + deserializedBookReader.getSurname());
        System.out.println("Deserialized BookStore: " + deserializedBookStore.getName());
        System.out.println("Deserialized Library: " + deserializedLibrary.getName());

    }
}