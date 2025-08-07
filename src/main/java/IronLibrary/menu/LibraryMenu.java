package IronLibrary.menu;

import java.util.Scanner;

import static IronLibrary.utils.Choices.*;
import static IronLibrary.utils.Emojis.*;
import static IronLibrary.utils.Colors.*;
import static IronLibrary.utils.Utils.*;
import static java.lang.System.exit;

public class LibraryMenu {
    public static String BOOKS_FILE = "src/main/java/IronLibrary/csv/books.csv";
    public static String ISSUES_FILE = "src/main/java/IronLibrary/csv/issues.csv";
    public static String STUDENTS_FILE = "src/main/java/IronLibrary/csv/students.csv";
    public static final String TEMP_FILE = "src/main/java/IronLibrary/csv/books_temp.csv";

    public static void mainMenuInput(Scanner scanner) {
        System.out.println("\n" + BROWN_BRIGHT + LIBRARY + " [WELCOME TO IRONLIBRARY] " + LIBRARY + RESET);
        String option;

        System.out.println(
                WHITE_BRIGHT + "1 - " + BOOK + GREEN_BRIGHT  + " Add a Book" + RESET + "\n" +
                        WHITE_BRIGHT + "2 - " + TAG + BLUE_BRIGHT   + " Search book by Title" + RESET + "\n" +
                        WHITE_BRIGHT + "3 - " + CATEGORY + BLUE_BRIGHT   + " Search book by Category" + RESET + "\n" +
                        WHITE_BRIGHT + "4 - " + TEACHER + BLUE_BRIGHT   + " Search book by Author" + RESET + "\n" +
                        WHITE_BRIGHT + "5 - " + BOOKS + BLUE_BRIGHT   + " List All Books along with Author" + RESET + "\n" +
                        WHITE_BRIGHT + "6 - " + LINK + YELLOW_BRIGHT + " Issue Book to Student" + RESET + "\n" +
                        WHITE_BRIGHT + "7 - " + ID_CARD + YELLOW_BRIGHT + " List Books by USN" + RESET + "\n" +
                        WHITE_BRIGHT + "8 - " + STUDENT + GREEN_BRIGHT  + " Add a Student" + RESET + "\n" +
                        WHITE_BRIGHT + "9 - " + RED_BRIGHT + EXIT + " Exit" + RESET + "\n"
        );

        System.out.print(YELLOW + SHUFFLE + " Choose an option: " + RESET);

        option = scanner.nextLine();
        System.out.println(GREEN_BRIGHT + "\n----------------------------------------------" + RESET);

        switch (option) {
            case "1":
                addABook(scanner);
                pause(scanner);
                break;
            case "2":
                searchBookByTitle(scanner);
                pause(scanner);
                break;
            case "3":
                searchBookByCategory(scanner);
                pause(scanner);
                break;
            case "4":
                searchBookByAuthor(scanner);
                pause(scanner);
                break;
            case "5":
                listAllBooksWithAuthor(scanner);
                pause(scanner);
                break;
            case "6":
                issueBookToStudent(scanner);
                pause(scanner);
                break;
            case "7":
                listBooksByUsn(scanner);
                pause(scanner);
                break;
            case "8":
                addAStudent(scanner);
                pause(scanner);
                break;
            case "9", "exit", "Exit", "EXIT":
                System.out.println("\nDeveloped with " + HEART + " by: " + WHITE_BRIGHT + "\nAïda, Lucía, Kiko, Carolina" + RESET);
                System.out.println(GREEN_BRIGHT + "\n----------------------------------------------" + RESET);
                System.out.println(RED + "\n[Closing IronLibrary... " + WAVE + "]" + RESET);
                scanner.close();
                exit(0);
            default:
                System.out.println(WARNING + YELLOW_BRIGHT + " Choose a valid option." + RESET);
        }
    }
}