package Version1;

import java.io.Serializable;

public class BookStore implements Serializable {
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
