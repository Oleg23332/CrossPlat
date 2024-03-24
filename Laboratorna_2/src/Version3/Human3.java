package Version3;

import java.io.*;

abstract public class Human3 implements Externalizable {
    protected String name;
    protected String surname;
    public Human3(String name, String surname) {
        this.name=name;
        this.surname=surname;
    }
    public Human3(){}
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        surname = in.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(surname);
    }
    public abstract void displayInfo();
}
