package Version3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Author3 extends Human3 implements Externalizable {
    private static final long serialVersionUID = 1L;
    private String author;

    public Author3() {}

    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }

    public Author3(String name, String surname, String author) {
        super(name, surname);
        this.author=author;
    }
    public String getSurname() {
        return surname;
    }

    @Override
    public void displayInfo() {
        System.out.println(surname+ "\n" + name+ "\n" + author);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(author);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        author = in.readUTF();
    }
}
