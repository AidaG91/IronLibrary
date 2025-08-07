package IronLibrary.utils;

import IronLibrary.model.Author;
import IronLibrary.model.Book;
import IronLibrary.model.Issue;
import IronLibrary.model.Student;

import java.util.Scanner;

import static IronLibrary.utils.Colors.*;
import static IronLibrary.utils.Utils.pause;

public class Prints {
    // Prints output
    // Print Book and Author (Option - 5)
    public static void printBookAndAuthor(Book book, Author author) {
        System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
        System.out.println(WHITE_BRIGHT + "Book ISBN: " + book.getIsbn()
                + "\nBook Title: " + book.getTitle()
                + "\nCategory: " + book.getCategory()
                + "\nNo of Books: " + book.getQuantity()
                + "\nAuthor: " + author.getName()
                + "\nEmail: " + author.getEmail() + RESET);
        System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
    }

    // Print Book (Option - 2, 3, 4)
    public static void printBook(Book book) {
        System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
        System.out.println(WHITE_BRIGHT + "Book ISBN: " + book.getIsbn()
                + "\nBook Title: " + book.getTitle()
                + "\nCategory: " + book.getCategory()
                + "\nNo of Books: " + book.getQuantity() + RESET);
        System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
    }

    // Print Issue (Option 6) - details of a single Issue (Book issued to a Student)
    public static void printIssue(Issue issue, Book book, Student student) {
        // Print confirmation of new Issue created
        System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
        System.out.println(WHITE_BRIGHT + "Book Title: " + book.getTitle());
        System.out.println("Student Name: " + student.getName());
        System.out.println("USN: " + student.getUsn());
        System.out.println("Issue Date: " + issue.getIssueDate());
        System.out.println("Return Date: " + issue.getReturnDate() + RESET);
        System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
    }

    // Print ASCII Title
    public static void printTitle(Scanner scanner) {
        System.out.println(BROWN_BRIGHT + "\n ▄█     ▄████████  ▄██████▄  ███▄▄▄▄    ▄█        ▄█  ▀█████████▄     ▄████████    ▄████████    ▄████████ ▄██   ▄   ");
        System.out.println("███    ███    ███ ███    ███ ███▀▀▀██▄ ███       ███    ███    ███   ███    ███   ███    ███   ███    ███ ███   ██▄ ");
        System.out.println("███▌   ███    ███ ███    ███ ███   ███ ███       ███▌   ███    ███   ███    ███   ███    ███   ███    ███ ███▄▄▄███ ");
        System.out.println("███▌  ▄███▄▄▄▄██▀ ███    ███ ███   ███ ███       ███▌  ▄███▄▄▄██▀   ▄███▄▄▄▄██▀   ███    ███  ▄███▄▄▄▄██▀ ▀▀▀▀▀▀███ ");
        System.out.println("███▌ ▀▀███▀▀▀▀▀   ███    ███ ███   ███ ███       ███▌ ▀▀███▀▀▀██▄  ▀▀███▀▀▀▀▀   ▀███████████ ▀▀███▀▀▀▀▀   ▄██   ███ ");
        System.out.println("███  ▀███████████ ███    ███ ███   ███ ███       ███    ███    ██▄ ▀███████████   ███    ███ ▀███████████ ███   ███ ");
        System.out.println("███    ███    ███ ███    ███ ███   ███ ███▌    ▄ ███    ███    ███   ███    ███   ███    ███   ███    ███ ███   ███ ");
        System.out.println("█▀     ███    ███  ▀██████▀   ▀█   █▀  █████▄▄██ █▀   ▄█████████▀    ███    ███   ███    █▀    ███    ███  ▀█████▀  ");
        System.out.println("       ███    ███                      ▀                             ███    ███                ███    ███           \n" + RESET);
        pause(scanner);
    }
}
