package model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database instance;
    private List<Book> books;
    private List<Borrowing> borrowings;
    private List<User> users;

    private Database() {
        books = new ArrayList<>();
        borrowings = new ArrayList<>();
        users = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int bookId) {
        books.removeIf(book -> book.getId() == bookId);
    }

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void addBorrowing(Borrowing borrowing) {
        borrowings.add(borrowing);
    }

    public void removeBorrowing(int borrowingId) {
        borrowings.removeIf(borrowing -> borrowing.getId() == borrowingId);
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(int userId) {
        users.removeIf(user -> user.getId() == userId);
    }
}
