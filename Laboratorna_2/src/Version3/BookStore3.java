package Version3;

import java.io.*;

public class BookStore3 implements Externalizable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String list[];
    public BookStore3(){}
    public BookStore3(String name, String[] list){
        this.list=list;
        this.name=name;
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        list = (String[]) in.readObject();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeObject(list);
    }
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
