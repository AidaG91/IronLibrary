package IronLibrary.menu;

import java.util.Scanner;

import static java.lang.System.exit;

public class LibraryMenu {

    Scanner scanner = new Scanner(System.in);


    public static void mainMenuInput(Scanner scanner) {
        System.out.println("Welcome to IronLibrary");
        int option;

        System.out.println("1 - Add a book\n" +
                "2 - Search book by title\n" +
                "3 - Search book by category\n" +
                "4 - Search book by Author\n" +
                "5 - List all books along with author\n" +
                "6 - Issue book to student\n" +
                "7 - List books by usn\n" +
                "8 - Exit\n");
        System.out.println("Choose an option:");

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
                System.out.println("Closing IronLibrary...");
                scanner.close();
                exit(0);
            default:
                System.out.println("Choose a valid option.");
        }
    }

    public static void addABook(Scanner scanner) {
        System.out.println("Add a Book:");
        String isbn;
        String title;
        String category;
        String author;
        String mail;
        int numBooks;

        System.out.println("Enter isbn:");

        System.out.println("Enter title:");

        System.out.println("Enter category:");

        System.out.println("Enter :");

        System.out.println("Enter title:");

       // input = scanner.nextInt();

    }

    private static void searchBookByTitle(Scanner scanner) {
    }

    private static void searchBookByCategory(Scanner scanner) {
    }

    private static void searchBookByAuthor(Scanner scanner) {
    }

    private static void listAllBooksWithAuthor(Scanner scanner) {
    }

    private static void issueBookToStudent(Scanner scanner) {
    }

    private static void listBooksByUsn(Scanner scanner) {
    }









    //scanner.close();


}
