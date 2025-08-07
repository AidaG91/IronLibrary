package IronLibrary.menu;

import java.util.Scanner;

import static IronLibrary.utils.Choices.*;
import static IronLibrary.assets.Emojis.*;
import static IronLibrary.assets.Colors.*;
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
                        WHITE_BRIGHT + "01 - " + BOOK + GREEN_BRIGHT  + " Add a Book" + RESET + "\n" +
                        WHITE_BRIGHT + "02 - " + STUDENT + GREEN_BRIGHT  + " Add a Student" + RESET + "\n" +
                        WHITE_BRIGHT + "03 - " + TAG + BLUE_BRIGHT   + " Search book by Title" + RESET + "\n" +
                        WHITE_BRIGHT + "04 - " + CATEGORY + BLUE_BRIGHT   + " Search book by Category" + RESET + "\n" +
                        WHITE_BRIGHT + "05 - " + TEACHER + BLUE_BRIGHT   + " Search book by Author" + RESET + "\n" +
                        WHITE_BRIGHT + "06 - " + BOOKS + BLUE_BRIGHT   + " List All Books along with Author" + RESET + "\n" +
                        WHITE_BRIGHT + "07 - " + ID_CARD + BLUE_BRIGHT + " List Books by USN" + RESET + "\n" +
                        WHITE_BRIGHT + "08 - " + LINK + YELLOW_BRIGHT + " Check out Book" + RESET + "\n" +
                        WHITE_BRIGHT + "09 - " + RETURN + YELLOW_BRIGHT + " Return a Book" + RESET + "\n" +
                        WHITE_BRIGHT + "10 - " + RED_BRIGHT + EXIT + " Exit" + RESET + "\n"
        );

        System.out.print(YELLOW + SHUFFLE + " Choose an option: " + RESET);

        option = scanner.nextLine();
        System.out.println(GREEN_BRIGHT + "\n----------------------------------------------" + RESET);

        switch (option) {
            case "1", "01":
                addABook(scanner);
                pause(scanner);
                break;
            case "2", "02":
                addAStudent(scanner);
                pause(scanner);
                break;
            case "3", "03":
                searchBookByTitle(scanner);
                pause(scanner);
                break;
            case "4", "04":
                searchBookByCategory(scanner);
                pause(scanner);
                break;
            case "5", "05":
                searchBookByAuthor(scanner);
                pause(scanner);
                break;
            case "6", "06":
                listAllBooksWithAuthor(scanner);
                pause(scanner);
                break;
            case "7", "07":
                listBooksByUsn(scanner);
                pause(scanner);
                break;
            case "8", "08":
                issueBookToStudent(scanner);
                pause(scanner);
                break;
            case "9", "09":
                returnABook(scanner);
                pause(scanner);
                break;
            case "10", "exit", "Exit", "EXIT":
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