
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean issued;

    // Constructor
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        issued = true;
    }

    public void returnBook() {
        issued = false;
    }

    // Display book details
    public void display() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (issued ? "Issued" : "Available"));
        System.out.println("--------------------------");
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addBook();
                        break;

                    case 2:
                        viewBooks();
                        break;

                    case 3:
                        searchBook();
                        break;

                    case 4:
                        issueBook();
                        break;

                    case 5:
                        returnBook();
                        break;

                    case 6:
                        System.out.println("Thank you for using the library system!");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            }

        } while (choice != 6);

        sc.close();
    }

    // Add Book
    static void addBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (id <= 0 || findBook(id) != null) {
                System.out.println("Invalid or duplicate Book ID!");
                return;
            }

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author Name: ");
            String author = sc.nextLine();

            if (title.trim().isEmpty() || author.trim().isEmpty()) {
                System.out.println("Title and author cannot be empty!");
                return;
            }

            books.add(new Book(id, title, author));
            System.out.println("Book added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    // View All Books
    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        for (Book book : books) {
            book.display();
        }
    }

    // Search Book
    static void searchBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            Book book = findBook(id);

            if (book != null) {
                book.display();
            } else {
                System.out.println("Book not found!");
            }

        } catch (Exception e) {
            System.out.println("Invalid Book ID!");
            sc.nextLine();
        }
    }

    // Issue Book
    static void issueBook() {
        try {
            System.out.print("Enter Book ID to issue: ");
            int id = sc.nextInt();
            sc.nextLine();

            Book book = findBook(id);

            if (book == null) {
                System.out.println("Book not found!");
            } else if (book.isIssued()) {
                System.out.println("Book is already issued!");
            } else {
                book.issueBook();
                System.out.println("Book issued successfully!");
            }

        } catch (Exception e) {
            System.out.println("Invalid Book ID!");
            sc.nextLine();
        }
    }

    // Return Book
    static void returnBook() {
        try {
            System.out.print("Enter Book ID to return: ");
            int id = sc.nextInt();
            sc.nextLine();

            Book book = findBook(id);

            if (book == null) {
                System.out.println("Book not found!");
            } else if (!book.isIssued()) {
                System.out.println("This book has not been issued!");
            } else {
                book.returnBook();
                System.out.println("Book returned successfully!");
            }

        } catch (Exception e) {
            System.out.println("Invalid Book ID!");
            sc.nextLine();
        }
    }

    // Find Book by ID
    static Book findBook(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }
}

