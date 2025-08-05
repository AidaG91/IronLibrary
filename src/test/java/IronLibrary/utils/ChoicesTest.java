package IronLibrary.utils;

import IronLibrary.menu.LibraryMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ChoicesTest {

    private static final String TEST_BOOKS_FILE = "test_books.csv";
    private static final Path TEST_FILE_PATH = Paths.get(TEST_BOOKS_FILE);

    private static final String TEST_STUDENTS_FILE = "test_students.csv";
    private static final Path TEST_SFILE_PATH = Paths.get(TEST_STUDENTS_FILE);

    String simulatedBook = String.join("\n",
            "1234567890", // ISBN
            "JUnit Testing Book", // Title
            "Programming", // Category
            "John Doe", // Author name
            "john@example.com", // Author email
            "5" // Quantity
    ) + "\n";

    String simulatedBookTwo = String.join("\n",
            "1234567899", // ISBN
            "We Hate Testing", // Title
            "Programming", // Category
            "Jane Doe", // Author name
            "jane@example.com", // Author email
            "2" // Quantity
    ) + "\n";

    Scanner scannerBook = new Scanner(new ByteArrayInputStream(simulatedBook.getBytes()));
    Scanner scannerBookTwo = new Scanner(new ByteArrayInputStream(simulatedBookTwo.getBytes()));

    String simulatedStudent = String.join("\n",
            "BCN2781", // USN
            "Paquita Salas" // Student name
    ) + "\n";

    Scanner scannerStudent = new Scanner(new ByteArrayInputStream(simulatedStudent.getBytes()));

    @BeforeEach
    void setUp() throws IOException {
        Files.deleteIfExists(TEST_FILE_PATH);
        Files.createFile(TEST_FILE_PATH);

        Files.deleteIfExists(TEST_SFILE_PATH);
        Files.createFile(TEST_SFILE_PATH);

        LibraryMenu.BOOKS_FILE = TEST_BOOKS_FILE;
        LibraryMenu.STUDENTS_FILE = TEST_STUDENTS_FILE;

        Choices.addABook(scannerBook);
        Choices.addABook(scannerBookTwo);
        Choices.addAStudent(scannerStudent);
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(TEST_FILE_PATH);
        Files.deleteIfExists(TEST_SFILE_PATH);
    }

    @Test
    void testAddABook() throws IOException {
        String content = Files.readString(TEST_FILE_PATH);
        assertTrue(content.contains("1234567890"));
        assertTrue(content.contains("JUnit Testing Book"));
        assertTrue(content.contains("Programming"));
        assertTrue(content.contains("John Doe"));
        assertTrue(content.contains("john@example.com"));
        assertTrue(content.contains("5"));
    }

    @Test
    void testSearchBookByTitle() throws IOException {
        String simulatedInput = "JUnit Testing Book";

        Scanner scannerTitle = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        Choices.searchBookByTitle(scannerTitle);

        String content = Files.readString(TEST_FILE_PATH);
        assertTrue(content.contains(simulatedInput));
    }

    @Test
    void testSearchBookByCategory() throws IOException {
        String simulatedInput = "Programming";

        Scanner scannerCategory = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        Choices.searchBookByCategory(scannerCategory);

        String content = Files.readString(TEST_FILE_PATH);
        assertTrue(content.contains(simulatedInput));
    }

    @Test
    void testSearchBookByAuthor() throws IOException {
        String simulatedInput = "Jane Doe";

        Scanner scannerAuthor = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        Choices.searchBookByAuthor(scannerAuthor);

        String content = Files.readString(TEST_FILE_PATH);
        assertTrue(content.contains(simulatedInput));
    }

    @Test
    void testListAllBooksWithAuthor() throws IOException {
        String simulatedInput = "";

        Scanner scannerBooksWithAuthor = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        Choices.listAllBooksWithAuthor(scannerBooksWithAuthor);

        String content = Files.readString(TEST_FILE_PATH);
       // assertTrue(content.contains(simulatedBook));
        assertTrue(content.contains("1234567890"));
        assertTrue(content.contains("JUnit Testing Book"));
        assertTrue(content.contains("Programming"));
        assertTrue(content.contains("John Doe"));
        assertTrue(content.contains("john@example.com"));
        assertTrue(content.contains("5"));
    }

    @Test
    void testIssueBookToStudent() throws IOException {
       // String simulatedInput = ;

    }

    @Test
    void testListBooksByUsn() throws IOException {
    }

    @Test
    void testAddAStudent() throws IOException {
        String content = Files.readString(TEST_SFILE_PATH);
        assertTrue(content.contains("BCN2781"));
        assertTrue(content.contains("Paquita Salas"));
    }
}