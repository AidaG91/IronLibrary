package IronLibrary.utils;

import IronLibrary.model.Author;
import IronLibrary.model.Book;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

import static IronLibrary.menu.LibraryMenu.*;
import static IronLibrary.assets.Emojis.*;
import static IronLibrary.utils.Prints.*;
import static IronLibrary.assets.Colors.*;

public class Utils {
    // Utils
    // General method for search by type
    public static void searchBooks(String filePath, String searchStr, String searchType) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean found = false; // To continue after one match
            reader.readLine(); // First line (Header) omitted
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    String isbn = data[0];
                    String title = data[1];
                    String category = data[2];
                    String quantity = data[3];
                    String authorName = data[4];
                    String authorMail = data[5];

                    // Instances for each line
                    Book book = new Book(isbn, title, category, Integer.parseInt(quantity));
                    Author author = new Author(authorName, authorMail, book);

                    // Search by type
                    switch (searchType.toLowerCase()) {
                        case "title":
                            if (title.toLowerCase().contains(searchStr.toLowerCase())) {
                                printBook(book);
                                found = true;
                            }
                            break;
                        case "category":
                            if (category.toLowerCase().contains(searchStr.toLowerCase())) {
                                printBook(book);
                                found = true;
                            }
                            break;
                        case "author":
                            if (authorName.toLowerCase().contains(searchStr.toLowerCase()) ||
                                    authorMail.toLowerCase().contains(searchStr.toLowerCase())) {
                                System.out.println(BLUE_BRIGHT + "Author: " + authorName + RESET);
                                printBook(book);
                                found = true;
                            }
                            break;
                        case "all":
                            printBookAndAuthor(book, author);
                            found = true;
                            break;
                        default:
                            break;
                    }
                }
            }
            if (!found) {
                System.out.println(WARNING + YELLOW_BRIGHT + " No results found." + RESET);
            }
        }
    }

    // Method to update the quantity of a book in books.csv
    public static void updateBookQuantity(String isbn, int newQuantity){
        File orig = new File(BOOKS_FILE);
        File temp = new File(TEMP_FILE);
        try (
                BufferedReader reader = new BufferedReader(new FileReader(orig));
                FileWriter writer = new FileWriter(temp)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6 && data[0].trim().equals(isbn.trim())) {
                    data[3] = String.valueOf(newQuantity);
                    line = String.join(",", data);
                }
                writer.write(line + "\n");
            }
        } catch (Exception e) {
            System.out.println(RED_BRIGHT + "Error updating books.csv: " + RESET + e.getMessage());
            return;
        }

        // Replace the original file with the updated temp file
        if (orig.delete()) {
            temp.renameTo(orig);
            System.out.println(GREEN_BRIGHT + "Updated successfully: books.csv" + RESET);
        } else {
            System.out.println(RED_BRIGHT + "Could not replace books.csv." + RESET);
        }
    }

    // Method to remove an issue from issues.csv when a book is returned
    public static void removeIssue(String usn, String isbn) {
        File orig = new File(ISSUES_FILE);
        File temp = new File(TEMP_FILE);
        try (
                BufferedReader reader = new BufferedReader(new FileReader(orig));
                FileWriter writer = new FileWriter(temp)
        ) {
            String line;
            boolean header = true;
            while ((line = reader.readLine()) != null) {
                if (header) {
                    writer.write(line + "\n"); // Write the header line
                    header = false;
                    continue;
                }
                String[] data = line.split(",");
                // If it's not the issue to remove, keep the line
                if (data.length >= 3 &&
                        !(data[0].trim().equals(usn.trim()) && data[2].trim().equals(isbn.trim()))) {
                    writer.write(line + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println(RED_BRIGHT + "Error updating issues.csv: " + RESET + e.getMessage());
            return;
        }
        if (orig.delete()) {
            temp.renameTo(orig);
            System.out.println(GREEN_BRIGHT + "Updated successfully: issues.csv" + RESET);
        } else {
            System.out.println(RED_BRIGHT + "Could not replace issues.csv." + RESET);
        }
    }

    // Method to check if a student exists in students.csv based on USN
    public static boolean doesStudentExist(String usn) {
        if (usn == null || usn.trim().isEmpty()) {
            System.out.println(RED_BRIGHT + "USN cannot be null or empty." + RESET);
            return false;
        }
        File file = new File(STUDENTS_FILE);
        if (!file.exists()) return false;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 1 && data[0].trim().equals(usn.trim())) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(RED_BRIGHT + "Error reading students file: " + RESET + e.getMessage());
        }
        return false;
    }

    // Return number of days left from NOW to returnDate (can be negative if returnDate is past already)
    public static void daysUntilDue(String returnDate) {
        LocalDate now = LocalDate.now();
        LocalDate ret = LocalDate.parse(returnDate);
        int daysLeft = now.until(ret).getDays();
        System.out.println("Return Date: " + returnDate + " | Today: " + now);
        if (daysLeft < 0) // If negative, overdue. Just a warning
            System.out.println(WARNING + " The book is overdue by: " + RED_BRIGHT + Math.abs(daysLeft) + " day(s)." + RESET);
        else
            System.out.println("Days left to return the book: " + GREEN_BRIGHT + daysLeft + " day(s)." + RESET);
    }

    // Pause method to wait for user input
    public static void pause(Scanner scanner) {
        System.out.print(WHITE + "Press Enter to continue..." + RESET);
        scanner.nextLine();
    }

    public static boolean issueExists(String usn, String isbn) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ISSUES_FILE))) {
            String line;
            reader.readLine(); // First line (Header) omitted
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6 && data[0].trim().equals(usn.trim())) {
                    if (data[2].equals(isbn.trim())) {
                        // If the student already has an issue, print a warning
                        System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
                        System.out.println(WARNING + YELLOW_BRIGHT + " This book has already been issued to student with USN " + usn + RESET);
                        System.out.println(GREEN_BRIGHT + "----------------------------------------------" + RESET);
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(RED_BRIGHT + "Error checking existing issues: " + RESET + e.getMessage());
        }
        return false; // If no issues found, return false
    }

    // Method to check if a book already exists in books.csv based on ISBN
    public static boolean bookExists(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println(RED_BRIGHT + "ISBN cannot be null or empty." + RESET);
            return true;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            reader.readLine(); // First line (Header) omitted
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6 && data[0].trim().equals(isbn.trim())) {
                    System.out.println(WARNING + YELLOW_BRIGHT + " Book with ISBN " + isbn + " already exists." + RESET);
                    return true; // Book already exists
                }
            }
        } catch (IOException e) {
            System.out.println(RED_BRIGHT + "Error checking existing books: " + RESET + e.getMessage());
        }
        return false; // If no book found, return false
    }
}
