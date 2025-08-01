package IronLibrary.utils;

import IronLibrary.model.Author;
import IronLibrary.model.Book;

import java.io.*;

import static IronLibrary.menu.LibraryMenu.*;
import static IronLibrary.utils.Prints.printBook;
import static IronLibrary.utils.Prints.printBookAndAuthor;

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

                    // search by type
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
                System.out.println("No results found.");
            }
        }
    }

    public static void updateCsv(String isbn, int newQuantity){
        try (
                BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE));
                FileWriter writer = new FileWriter(TEMP_FILE)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6 && data[0].trim().equals(isbn)) {
                    data[3] = String.valueOf(newQuantity);
                    line = String.join(",", data);
                }
                writer.write(line + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error updating books.csv: " + e.getMessage());
            return;
        }

        File orig = new File(BOOKS_FILE);
        File temp = new File(TEMP_FILE);
        if (orig.delete()) {
            temp.renameTo(orig);
            System.out.println("Updated successfully: books.csv");
        } else {
            System.out.println("Could not replace books.csv.");
        }
    }

    // Check if Student by USN already exist (students.csv)
    public static boolean doesStudentExist(String usn) {
        final String STUDENTS_FILE = "src/main/java/IronLibrary/students.csv";
        File file = new File(STUDENTS_FILE);
        if (!file.exists()) {
            return false;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(STUDENTS_FILE))) {
            String line;
            reader.readLine(); // First line (Header) omitted
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 1 && data[0].trim().equals(usn.trim())) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading students file: " + e.getMessage());
        }
        return false;
    }
}
