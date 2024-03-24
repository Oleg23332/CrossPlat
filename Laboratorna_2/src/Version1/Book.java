package Version1;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    private String name;
    ArrayList<Author> list = new ArrayList<>();
    private int yearEdition;
    private int numEdition;

    public String getName() {
        return name;
    }

    public int getNumEdition() {
        return numEdition;
    }

    public int getYearEdition() {
        return yearEdition;
    }

    public void setList(ArrayList<Author> list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumEdition(int numEdition) {
        this.numEdition = numEdition;
    }

    public void setYearEdition(int yearEdition) {
        this.yearEdition = yearEdition;
    }
}
