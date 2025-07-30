package IronLibrary.menu;

import IronLibrary.model.Book;
import IronLibrary.model.Author;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import static java.lang.System.exit;

public class LibraryMenu {

    private static final String BOOKS_FILE = "src/main/java/IronLibrary/books.csv";

    public static void mainMenuInput(Scanner scanner) {
        System.out.println("[WELCOME TO IRONLIBRARY]");
        int option;

        System.out.println("1 - Add a Book\n" +
                "2 - Search book by Title\n" +
                "3 - Search book by Category\n" +
                "4 - Search book by Author\n" +
                "5 - List ALL Books along with Author\n" +
                "6 - Issue Book to Student\n" +
                "7 - List Books by usn\n" +
                "8 - Exit\n");
        System.out.print("Choose an option: ");

        option = scanner.nextInt();
        switch (option) {
            case 1:
                addABook(scanner);
                break;
            case 2:
                searchBookByTitle(scanner);
                break;
            case 3:
                searchBookByCategory(scanner);
                break;
            case 4:
                searchBookByAuthor(scanner);
                break;
            case 5:
                listAllBooksWithAuthor(scanner);
                break;
            case 6:
                issueBookToStudent(scanner);
                break;
            case 7:
                listBooksByUsn(scanner);
                break;
            case 8:
                System.out.println("[Closing IronLibrary...]");
                scanner.close();
                exit(0);
            default:
                System.out.println("[Choose a valid option]");
        }
    }

    public static void addABook(Scanner scanner) {
        scanner.nextLine(); // Clean input buffer
        System.out.println("[Add a Book]");

        try {
            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter category: ");
            String category = scanner.nextLine();
            System.out.print("Enter Author name: ");
            String authorName = scanner.nextLine();
            System.out.print("Enter Author mail: ");
            String authorMail = scanner.nextLine();
            System.out.print("Enter number of Copies: ");
            int numBooks = scanner.nextInt();

            if (numBooks < 0) {
                System.out.println("The number of copies cannot be negative.");
                return;
            }

            // Create the Book object (without Author reference)
            Book book = new Book(isbn, title, category, numBooks);

            // Create the Author object referencing the Book
            Author author = new Author(authorName, authorMail, book);

            // Save the book data in the CSV file (one line per book)
            FileWriter csv = new FileWriter(BOOKS_FILE, true);

            // If the CSV file is empty, write the header
            File file = new File(BOOKS_FILE);
            if (file.length() == 0 || !file.exists()) {
                csv.write("isbn,title,category,quantity,author,email\n"); // Header CSV
            }
            csv.write(book.getIsbn() + "," +
                    book.getTitle() + "," +
                    book.getCategory() + "," +
                    book.getQuantity() + "," +
                    author.getName() + "," +
                    author.getEmail() + "\n");
            csv.close(); // Close File

            // Print confirmation of the added book and author details
            System.out.println("\n[Book successfully created]\n"
                    + "ISBN: " + book.getIsbn() + "\n"
                    + "Title: " + book.getTitle() + "\n"
                    + "Category: " + book.getCategory() + "\n"
                    + "Author Name: " + author.getName() + "\n"
                    + "Author Mail: " + author.getEmail() + "\n"
                    + "Copies: " + book.getQuantity() + "\n");
        } catch (Exception e) {
            System.out.println("Error saving the book: " + e.getMessage());
        }
    }

    private static void searchBookByTitle(Scanner scanner) {
        String titleSearch;

    }

    private static void searchBookByCategory(Scanner scanner) {
        String categorySearch;
    }

    private static void searchBookByAuthor(Scanner scanner) {
        String authorSearch;
    }

    private static void listAllBooksWithAuthor(Scanner scanner) {
        String authorSearchAll;
    }

    private static void issueBookToStudent(Scanner scanner) {
        int issueStudentSearch;
    }

    private static void listBooksByUsn(Scanner scanner) {
        long usnSearch;
    }
}
