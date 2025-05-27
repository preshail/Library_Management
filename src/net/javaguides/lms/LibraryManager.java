package net.javaguides.lms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibraryManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void updateBook(int id, String title, String author) {
        books.stream()
             .filter(book -> book.getId() == id)
             .findFirst()
             .ifPresent(book -> {
                 book.setTitle(title);
                 book.setAuthor(author);
                 System.out.println("Book updated successfully!");
             });
    }

    public void deleteBook(int id) {
        if (books.removeIf(book -> book.getId() == id)) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void listBooks() {
        books.forEach(System.out::println);
    }

    public void searchBooks(String query) {
        List<Book> foundBooks = books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                                book.getAuthor().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());

        if (foundBooks.isEmpty()) {
            System.out.println("No books found matching the query.");
        } else {
            foundBooks.forEach(System.out::println);
        }
    }

    public void checkOutBook(int id) {
        books.stream()
             .filter(book -> book.getId() == id && !book.isBorrowed())
             .findFirst()
             .ifPresentOrElse(book -> {
                 book.setBorrowed(true);
                 System.out.println("Book checked out successfully!");
             }, () -> System.out.println("Book is not available."));
    }

    public void checkInBook(int id) {
        books.stream()
             .filter(book -> book.getId() == id && book.isBorrowed())
             .findFirst()
             .ifPresentOrElse(book -> {
                 book.setBorrowed(false);
                 System.out.println("Book checked in successfully!");
             }, () -> System.out.println("Book was not checked out."));
    }

    private Book inputBookDetails(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();
        return new Book(id, title, author);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. List All Books");
            System.out.println("5. Search Books");
            System.out.println("6. Check Out Book");
            System.out.println("7. Check In Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addBook(inputBookDetails(scanner));
                    break;
                case 2:
                    System.out.print("Enter Book ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Book book = inputBookDetails(scanner);
                    updateBook(id, book.getTitle(), book.getAuthor());
                    break;
                case 3:
                    System.out.print("Enter Book ID to delete: ");
                    id = scanner.nextInt();
                    deleteBook(id);
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    System.out.print("Enter search query (title or author): ");
                    String query = scanner.nextLine();
                    searchBooks(query);
                    break;
                case 6:
                    System.out.print("Enter Book ID to check out: ");
                    id = scanner.nextInt();
                    checkOutBook(id);
                    break;
                case 7:
                    System.out.print("Enter Book ID to check in: ");
                    id = scanner.nextInt();
                    checkInBook(id);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please enter a number between 1 and 8.");
            }
        }
    }
}
