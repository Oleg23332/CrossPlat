package Version2;

import java.io.Serializable;


public class Library implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String listref[];
    private String h;

    public void setName(String name) {
        this.name = name;
    }

    public void setH(String h) {
        this.h = h;
    }

    public void setListref(String[] listref) {
        this.listref = listref;
    }

    public String getName() {
        return name;
    }

    public String getH() {
        return h;
    }

    public String[] getListref() {
        return listref;
    }
}
