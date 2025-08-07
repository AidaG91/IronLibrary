package IronLibrary.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class IssueTest {
    private Issue issue;
    private Student student;
    private Book book;
    private LocalDate date = LocalDate.now();
    private LocalDate returnDate = date.plusDays(7);

    @BeforeEach
    void setUp() {
        student = new Student("123", "Paco");
        book = new Book("4567gg", "Newsletter", "Comedy", 1);
        issue = new Issue(date.toString(), student, book);
    }

    @Test
    void setIssueDate() {
        assertEquals(date.toString(), issue.getIssueDate() );
    }

    @Test
    void setReturnDate() {
        assertEquals(returnDate.toString(), issue.getReturnDate() );
    }
}