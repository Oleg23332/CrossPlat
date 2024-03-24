package Version3;

import java.io.*;
import java.util.ArrayList;

public class BookReader3 extends Human3 implements Externalizable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Book3> bookList;
    private int numOfReg;
    public BookReader3(){}
    public BookReader3(String name, String surname, int numOfReg, ArrayList<Book3> bookList) {
        super(name, surname);
        this.numOfReg=numOfReg;
        this.bookList=bookList;
    }

    public void setBookList(ArrayList<Book3> bookList) {
        this.bookList = bookList;
    }

    public void setNumOfReg(int numOfReg) {
        this.numOfReg = numOfReg;
    }

    public int getNumOfReg() {
        return numOfReg;
    }

    public ArrayList<Book3> getBookList() {
        return bookList;
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name=in.readUTF();
        surname = in.readUTF();
        numOfReg = in.readInt();
        bookList = (ArrayList<Book3>) in.readObject();
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(surname);
        out.writeInt(numOfReg);
        out.writeObject(bookList);
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
