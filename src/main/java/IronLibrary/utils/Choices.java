package IronLibrary.utils;

import IronLibrary.model.Author;
import IronLibrary.model.Book;
import IronLibrary.model.Issue;
import IronLibrary.model.Student;

import java.io.*;
import java.util.Scanner;

import static IronLibrary.menu.LibraryMenu.STUDENTS_FILE;
import static IronLibrary.menu.LibraryMenu.BOOKS_FILE;
import static IronLibrary.menu.LibraryMenu.ISSUES_FILE;
import static IronLibrary.assets.Colors.*;
import static IronLibrary.assets.Emojis.*;
import static IronLibrary.utils.Prints.printIssue;
import static IronLibrary.utils.Utils.*;

public class Choices {
    // Options
    // Option 1: Add a Book to CSV (books.csv)
    public static void addABook(Scanner scanner) {
        System.out.println(WHITE_BRIGHT + "[Add a Book]" + RESET);

        try {
            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();
            // Check if the book already exists
            if(bookExists(isbn))
                return;
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
                System.out.println(WARNING + RED_BRIGHT + " The number of copies cannot be negative." + RESET);
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
            // Write data to CSV (books.csv)
            csv.write(book.getIsbn() + "," +
                    book.getTitle() + "," +
                    book.getCategory() + "," +
                    book.getQuantity() + "," +
                    author.getName() + "," +
                    author.getEmail() + "\n");
            csv.close(); // Close File

            // Print confirmation of the added book and author details
            System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
            System.out.println(GREEN_BRIGHT + "\n[Book successfully created]\n"
                    + "ISBN: " + book.getIsbn() + "\n"
                    + "Title: " + book.getTitle() + "\n"
                    + "Category: " + book.getCategory() + "\n"
                    + "Author Name: " + author.getName() + "\n"
                    + "Author Mail: " + author.getEmail() + "\n"
                    + "Copies: " + book.getQuantity() + "\n" + RESET);
            System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
        } catch (Exception e) {
            System.out.println(RED_BRIGHT + "Error saving the book: " + RESET + e.getMessage());
        }
    }

    // [EXTRA] Option 2 - Add a Student to a CSV (students.csv)
    public static void addAStudent(Scanner scanner) {
        System.out.println(WHITE_BRIGHT + "[Add a Student]" + RESET);

        try {
            System.out.print("Enter USN: ");
            String usn = scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            // Check if Student already exist
            if (doesStudentExist(usn)) {
                System.out.println(WARNING + YELLOW_BRIGHT + " Student with USN " + usn + " already exists." + RESET);
                return;
            }

            // Create the Student object
            Student student = new Student(usn, name);

            // Save the student data in the CSV file (one line per student)
            FileWriter csv = new FileWriter(STUDENTS_FILE, true);

            // If the CSV file is empty, write the header
            File file = new File(STUDENTS_FILE);
            if (file.length() == 0 || !file.exists()) {
                csv.write("usn,name\n"); // Header CSV
            }
            csv.write(student.getUsn() + "," +
                    student.getName() + "\n");
            csv.close(); // Close File

            // Print confirmation of the added student
            System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
            System.out.println(GREEN_BRIGHT + "[Student successfully created]\n"
                    + "USN: " + student.getUsn() + "\n"
                    + "Name: " + student.getName() + RESET);
            System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
        } catch (Exception e) {
            System.out.println(RED_BRIGHT + "Error saving the student: " + RESET + e.getMessage());
        }
    }

    // Search using searchBooks()
    // Option 3 - Search a Book by Title
    public static void searchBookByTitle(Scanner scanner) {
        System.out.println(WHITE_BRIGHT + "[Search by Title]" + RESET);
        System.out.print("Enter a title: ");
        String title = scanner.nextLine();
        try {
            searchBooks(BOOKS_FILE, title, "title");
        } catch (IOException e) {
            System.out.println(RED_BRIGHT + "Error: " + RESET + e.getMessage());
        }
    }

    // Option 4 - Search a Book by Category
    public static void searchBookByCategory(Scanner scanner) {
        System.out.println(WHITE_BRIGHT + "[Search by Category]" + RESET);
        System.out.print("Enter a category: ");
        String category = scanner.nextLine();
        try {
            searchBooks(BOOKS_FILE, category, "category");
        } catch (IOException e) {
            System.out.println(RED_BRIGHT + "Error: " + RESET + e.getMessage());
        }
    }

    // Option 5 - Search a Book by Author
    public static void searchBookByAuthor(Scanner scanner) {
        System.out.println(WHITE_BRIGHT + "[Search by Author]" + RESET);
        System.out.print("Enter author name or email: ");
        String author = scanner.nextLine();
        try {
            searchBooks(BOOKS_FILE, author, "author");
        } catch (IOException e) {
            System.out.println(RED_BRIGHT + "Error: " + RESET + e.getMessage());
        }
    }

    // Option 6 - List All Books with Author
    public static void listAllBooksWithAuthor(Scanner scanner) {
        try {
            searchBooks(BOOKS_FILE, "", "all");
        } catch (IOException e) {
            System.out.println(RED_BRIGHT + "Error: " + RESET + e.getMessage());
        }
    }

    // Option 7 - List ALL the Books rented by a Student (USN)
    public static void listBooksByUsn(Scanner scanner) {
        System.out.println(WHITE_BRIGHT + "[List Books by USN]" + RESET);
        System.out.print("Enter the student's USN: ");
        String usn = scanner.nextLine();

        // Read the issues CSV (issues.csv)
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(ISSUES_FILE))) {
            reader.readLine(); // First line (Header) omitted
            String line;
            System.out.println("\nBooks issued to USN: " + usn);

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6 && data[0].trim().equalsIgnoreCase(usn)) {
                    found = true;
                    String bookTitle = data[3];
                    String returnDate = data[5];

                    // Print the list of issued books (show title, returnDate, check days until due and if overdue)
                    System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
                    System.out.println(WHITE_BRIGHT + "Book Title: " + bookTitle);
                    daysUntilDue(returnDate);
                    System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
                }
            }
        } catch (IOException e) {
            System.out.println(RED_BRIGHT + "Error reading issued books: " + RESET + e.getMessage());
        }

        if (!found) {
            System.out.println(RED_BRIGHT + "No books found for this USN." + RESET);
        }
    }

    // Option 8 - Assign a Book to a Student (Issue)
    public static void issueBookToStudent(Scanner scanner) {
        System.out.println(WHITE_BRIGHT + "[Create Issue]" + RESET);

        System.out.print("Enter the student's USN: ");
        String usn = scanner.nextLine();
        System.out.print("Enter the ISBN of the book to issue: ");
        String isbn = scanner.nextLine();

        try {
            // Check if Student already exist
            if (!doesStudentExist(usn)) {
                System.out.println(WARNING + RED_BRIGHT + "Student with USN " + usn + " not found. Please add the student first." + RESET);
                return;
            }

            // Check if the issue already exists
            if (issueExists(usn, isbn))
                return;

            // Extract data from CSV (students.csv)
            Student student = null;
            try (BufferedReader reader = new BufferedReader(new FileReader(STUDENTS_FILE))) {
                reader.readLine(); // First line (Header) omitted
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length >= 2 && data[0].trim().equals(usn.trim())) {
                        student = new Student(data[0], data[1]);
                        break;
                    }
                }
            }

            // If student not found, print error message
            if (student == null) {
                System.out.println(RED_BRIGHT + "Error loading student data." + RESET);
                return;
            }

            // Extract data from CSV (books.csv)
            Book book = null;
            try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
                reader.readLine(); // First line (Header) omitted
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length >= 6 && data[0].trim().equals(isbn.trim())) {
                        book = new Book(data[0], data[1], data[2], Integer.parseInt(data[3]));
                        int quantity = Integer.parseInt(data[3]);
                        updateBookQuantity(isbn, (quantity - 1));
                        break;
                    }
                }
            }

            if (book == null) {
                System.out.println(WARNING + YELLOW_BRIGHT + " Book with ISBN " + isbn + " not found." + RESET);
                return;
            }

            // Create Issue (current date and return date +7 days)
            String issueDate = java.time.LocalDate.now().toString(); // "YYYY-MM-DD"
            Issue issue = new Issue(issueDate, student, book); // Using Issue's internal logic to calc returnDate

            if (issue.getIssueBook().getIsbn() == isbn && issue.getIssueBook().getQuantity() <= 0) {
                System.out.println(WARNING + YELLOW_BRIGHT + " No copies available for this book." + RESET);
                return;
            }

            // Write new issue data to CSV (issues.csv)
            File issuesFile = new File(ISSUES_FILE);
            try (FileWriter csv = new FileWriter(ISSUES_FILE, true)) {
                if (issuesFile.length() == 0 || !issuesFile.exists())
                    csv.write("usn,name,isbn,bookTitle,issueDate,returnDate\n");
                csv.write(student.getUsn() + "," +
                        student.getName() + "," +
                        book.getIsbn() + "," +
                        book.getTitle() + "," +
                        issue.getIssueDate() + "," +
                        issue.getReturnDate() + "\n");
            }
            // Print confirmation of new Issue created
            printIssue(issue, book, student);
        } catch (Exception e) {
            System.out.println(RED_BRIGHT + "Error creating new Issue: " + RESET + e.getMessage());
        }
    }

    // Option 9 - Method to update book quantity in books.csv and delete the issue from issues.csv
    public static void returnABook(Scanner scanner) {
        System.out.println(WHITE_BRIGHT + "[Return a Book]" + RESET);
        System.out.print("Enter the student's USN: ");
        String usn = scanner.nextLine();
        System.out.print("Enter the ISBN of the book to return: ");
        String isbn = scanner.nextLine();

        // Update book quantity in books.csv
        Book book = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6 && data[0].trim().equals(isbn.trim())) {
                    book = new Book(data[0], data[1], data[2], Integer.parseInt(data[3]));
                    int quantity = Integer.parseInt(data[3]);
                    updateBookQuantity(isbn, quantity + 1);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Remove the corresponding issue from issues.csv
        removeIssue(usn, isbn);
    }
}
