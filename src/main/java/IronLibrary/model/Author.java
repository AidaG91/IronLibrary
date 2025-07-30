package IronLibrary.model;

public class Author {// Private member variables
    private static int idCounter = 1; // Helper for auto-increment
    private final int authorId;
    private String name;
    private String email;
    private Book authorBook; // Assuming a Book class is already defined elsewhere

    // Parameterized constructor
    public Author(String name, String email, Book authorBook) {
        this.authorId = idCounter++;
        this.name = name;
        this.email = email;
        this.authorBook = authorBook;
    }

    // Getter methods
    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Book getAuthorBook() {
        return authorBook;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthorBook(Book authorBook) {
        this.authorBook = authorBook;
    }
}


