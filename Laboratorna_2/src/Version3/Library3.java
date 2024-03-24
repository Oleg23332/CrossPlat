package Version3;

import java.io.*;

public class Library3 implements Externalizable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String listref[];
    private String h;
    public Library3(){}
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

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        listref = (String[]) in.readObject();
        h = in.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeObject(listref);
        out.writeUTF(h);
    }
}
