package Version1;

import java.io.Serializable;
import java.util.ArrayList;

public class BookReader extends Human implements Serializable {
    private ArrayList<Book> bookList;
    private int numOfReg;
    public BookReader(String name, String surname, int numOfReg, ArrayList<Book> bookList) {
        super(name, surname);
        this.numOfReg=numOfReg;
        this.bookList=bookList;
    }
    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void setNumOfReg(int numOfReg) {
        this.numOfReg = numOfReg;
    }

    public int getNumOfReg() {
        return numOfReg;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    @Override
    public void displayInfo() {
        System.out.println(name + " : " + surname + " : " + bookList);
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
