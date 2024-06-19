package view;

import controller.LibraryController;
import model.Book;
import model.Borrowing;
import model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LibraryView {
    private LibraryController controller;
    private Scanner scanner;

    public LibraryView() {
        controller = new LibraryController();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Menu Biblioteki:");
            System.out.println("1. Dodaj Książkę");
            System.out.println("2. Wypożycz Książkę");
            System.out.println("3. Dodaj Użytkownika");
            System.out.println("4. Usuń Książkę");
            System.out.println("5. Zwróć Książkę");
            System.out.println("6. Usuń Użytkownika");
            System.out.println("7. Lista Wszystkich Książek");
            System.out.println("8. Lista Wszystkich Wypożyczeń");
            System.out.println("9. Lista Wszystkich Użytkowników");
            System.out.println("10. Wyjdź");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    addUser();
                    break;
                case 4:
                    removeBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    removeUser();
                    break;
                case 7:
                    listAllBooks();
                    break;
                case 8:
                    listAllBorrowings();
                    break;
                case 9:
                    listAllUsers();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private void addBook() {
        System.out.println("Podaj tytuł książki:");
        String title = scanner.nextLine();
        System.out.println("Podaj autora książki:");
        String author = scanner.nextLine();
        controller.addBook(title, author);
    }

    private void borrowBook() {
        System.out.println("Podaj ID książki:");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.println("Podaj ID użytkownika:");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.println("Podaj datę wypożyczenia (YYYY-MM-DD):");
        LocalDate borrowDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Podaj datę zwrotu (YYYY-MM-DD):");
        LocalDate returnDate = LocalDate.parse(scanner.nextLine());
        controller.borrowBook(bookId, userId, borrowDate, returnDate);
    }

    private void addUser() {
        System.out.println("Podaj imię użytkownika:");
        String name = scanner.nextLine();
        System.out.println("Podaj typ użytkownika (librarian/member):");
        String type = scanner.nextLine();
        controller.addUser(name, type);
    }

    private void removeBook() {
        System.out.println("Podaj ID książki:");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        controller.removeBook(bookId);
    }

    private void returnBook() {
        System.out.println("Podaj ID wypożyczenia:");
        int borrowingId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        controller.returnBook(borrowingId);
    }

    private void removeUser() {
        System.out.println("Podaj ID użytkownika:");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        controller.removeUser(userId);
    }

    private void listAllBooks() {
        List<Book> books = controller.getAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void listAllBorrowings() {
        List<Borrowing> borrowings = controller.getAllBorrowings();
        for (Borrowing borrowing : borrowings) {
            System.out.println(borrowing);
        }
    }

    private void listAllUsers() {
        List<User> users = controller.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
