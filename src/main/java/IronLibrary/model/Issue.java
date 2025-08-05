package IronLibrary.model;

import java.time.LocalDate;
import java.util.Objects;

/* Represents a Book lending in the IronLibrary system */
public class Issue {
    private int issueId;
    private String issueDate; // "YYYY-MM-DD"
    private String returnDate; // "YYYY-MM-DD"
    private Student issueStudent;
    private Book issueBook;

    // Constructor
    public Issue(String issueDate, String returnDate, Student issueStudent, Book issueBook) {
        setIssueDate(issueDate);
        setIssueStudent(issueStudent);
        setIssueBook(issueBook);
        setReturnDate(returnDate);
    }

    public Issue(int issueId, String issueDate, String returnDate, Student issueStudent, Book issueBook) {
        this.issueId = issueId;
        setIssueDate(issueDate);
        setIssueStudent(issueStudent);
        setIssueBook(issueBook);
        setReturnDate(returnDate);
    }

    public Issue(String issueDate, Student issueStudent, Book issueBook) {
        setIssueDate(issueDate);
        setIssueStudent(issueStudent);
        setIssueBook(issueBook);
    }

    // Getters
    public int getIssueId() { return issueId; }
    public String getIssueDate() { return issueDate; }
    public String getReturnDate() { return returnDate; }
    public Student getIssueStudent() { return issueStudent; }
    public Book getIssueBook() { return issueBook; }

    // Setters
    public void setIssueId(int issueId) { this.issueId = issueId; }
    public void setIssueStudent(Student issueStudent) {
        if (issueStudent == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        this.issueStudent = issueStudent;
    }
    public void setIssueBook(Book issueBook) {
        if (issueBook == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        this.issueBook = issueBook;
    }

    public void setIssueDate(String issueDate) {
        if (issueDate == null || issueDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Issue date cannot be null or empty.");
        }
        this.issueDate = issueDate;
        // Recalculate returnDate if issueDate is changed
        this.returnDate = calculateReturnDate(issueDate);
    }

    public void setReturnDate(String returnDate) {
        // Validation: returnDate must be >= issueDate
        if (issueDate != null && returnDate != null) {
            LocalDate issue = LocalDate.parse(issueDate);
            LocalDate ret = LocalDate.parse(returnDate);
            if (ret.isBefore(issue)) { // returnDate >= issueDate
                throw new IllegalArgumentException("Return date cannot be earlier than issue date. Provide a valid date.");
            }
        }
        this.returnDate = returnDate;
    }

    // Utils Methods for future
    // Calculate returnDate (+7 days from issueDate)
    private String calculateReturnDate(String issueDate) {
        LocalDate date = LocalDate.parse(issueDate); // Parse the issue date string to LocalDate
        LocalDate returnDate = date.plusDays(7); // Add 7 days to get the due date
        return returnDate.toString(); // Convert the LocalDate back to string
    }

    // Check if the Book was returned on time (return: true or false)
    public boolean isReturnedOnTime(String actualReturnDate) {
        LocalDate actual = LocalDate.parse(actualReturnDate);
        LocalDate ret = LocalDate.parse(returnDate);
        return !actual.isAfter(ret);
    }

    // Return number of days left from NOW to returnDate (can be negative if returnDate is past already)
    public long daysUntilDue() {
        LocalDate now = LocalDate.now();
        LocalDate ret = LocalDate.parse(returnDate);
        int daysLeft = now.until(ret).getDays();
        if (daysLeft < 0) // If negative, overdue. Just a warning
            System.out.println("Warning: The book is overdue by " + Math.abs(daysLeft) + " day(s).");
        return daysLeft;
    }

    // Provides a detailed representation of Issue for info and display
    @Override
    public String toString() {
        return "Issue: " + issueBook.getTitle() + " to " + issueStudent.getName() +
                " from " + issueDate + " to " + returnDate;
    }
}