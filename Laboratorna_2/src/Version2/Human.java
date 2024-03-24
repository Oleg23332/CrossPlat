package Version2;

import java.io.Serializable;

abstract public class Human implements Serializable {
    protected String name;
    protected String surname;
    public Human(String name, String surname) {
        this.name=name;
        this.surname=surname;
    }

    public abstract void displayInfo();
}
