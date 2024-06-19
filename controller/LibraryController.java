package controller;

import model.*;

import java.time.LocalDate;
import java.util.List;

public class LibraryController {
    private Database database;

    public LibraryController() {
        database = Database.getInstance();
    }

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        database.addBook(book);
    }

    public void removeBook(int bookId) {
        database.removeBook(bookId);
    }

    public void borrowBook(int bookId, int userId, LocalDate borrowDate, LocalDate returnDate) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);
        if (book != null && user != null) {
            Borrowing borrowing = new Borrowing(book, user, borrowDate, returnDate);
            database.addBorrowing(borrowing);
        }
    }

    public void returnBook(int borrowingId) {
        database.removeBorrowing(borrowingId);
    }

    public void addUser(String name, String type) {
        User user;
        if (type.equalsIgnoreCase("librarian")) {
            user = new Librarian(name);
        } else {
            user = new Member(name);
        }
        database.addUser(user);
    }

    public void removeUser(int userId) {
        database.removeUser(userId);
    }

    public Book findBookById(int id) {
        for (Book book : database.getBooks()) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public User findUserById(int id) {
        for (User user : database.getUsers()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return database.getBooks();
    }

    public List<Borrowing> getAllBorrowings() {
        return database.getBorrowings();
    }

    public List<User> getAllUsers() {
        return database.getUsers();
    }
}
