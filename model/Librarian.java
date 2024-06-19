package model;

public class Librarian extends User {
    public Librarian(String name) {
        super(name);
    }

    public void manageBooks() {
        System.out.println(getName() + " zarządza książkami.");
    }
}
