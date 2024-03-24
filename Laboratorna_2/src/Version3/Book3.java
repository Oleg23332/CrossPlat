package Version3;

import java.io.*;
import java.util.ArrayList;

public class Book3 implements Externalizable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient ArrayList<Author3> authors;
    private int yearEdition;
    private int numEdition;
    public Book3(){}
    public Book3(String name, int yearEdition, int numEdition, ArrayList<Author3> authors) {
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
    public ArrayList<Author3> getAuthors() {
        return authors;
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        authors = (ArrayList<Author3>) in.readObject();
        yearEdition = in.readInt();
        numEdition = in.readInt();
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeObject(authors);
        out.writeInt(yearEdition);
        out.writeInt(numEdition);
    }
}
