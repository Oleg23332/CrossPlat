package Version2;

import java.io.*;

public class BookStore implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String list[];

    public String getName() {
        return name;
    }

    public String[] getList() {
        return list;
    }

    public void setList(String[] list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }
}
