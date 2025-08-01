package IronLibrary.menu;

import java.util.Scanner;

import static IronLibrary.utils.Choices.*;
import static java.lang.System.exit;

public class LibraryMenu {
    public static final String BOOKS_FILE = "src/main/java/IronLibrary/csv/books.csv";
    public static final String ISSUES_FILE = "src/main/java/IronLibrary/csv/issues.csv";
    public static final String STUDENTS_FILE = "src/main/java/IronLibrary/csv/students.csv";
    public static final String TEMP_FILE = "src/main/java/IronLibrary/csv/books_temp.csv";

    public static void mainMenuInput(Scanner scanner) {
        System.out.println("\n[WELCOME TO IRONLIBRARY]");
        String option;

        System.out.println("1 - Add a Book\n" +
                "2 - Search book by Title\n" +
                "3 - Search book by Category\n" +
                "4 - Search book by Author\n" +
                "5 - List All Books along with Author\n" +
                "6 - Issue Book to Student\n" +
                "7 - List Books by usn\n" +
                "8 - Add a Student\n" +
                "9 - Exit\n");
        System.out.print("Choose an option: ");

        option = scanner.nextLine();
        switch (option) {
            case "1":
                addABook(scanner);
                break;
            case "2":
                searchBookByTitle(scanner);
                break;
            case "3":
                searchBookByCategory(scanner);
                break;
            case "4":
                searchBookByAuthor(scanner);
                break;
            case "5":
                listAllBooksWithAuthor(scanner);
                break;
            case "6":
                issueBookToStudent(scanner);
                break;
            case "7":
                listBooksByUsn(scanner);
                break;
            case "8":
                addAStudent(scanner);
                break;
            case "9":
                System.out.println("[Closing IronLibrary...]");
                scanner.close();
                exit(0);
            default:
                System.out.println("[Choose a valid option]");
        }
    }
}
