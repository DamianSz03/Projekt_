package model;

public class Member extends User {
    public Member(String name) {
        super(name);
    }

    public void borrowBook() {
        System.out.println(getName() + " wypożycza książkę.");
    }
}
