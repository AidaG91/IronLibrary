package IronLibrary.model;

// Represents an Author in the IronLibrary system
public class Author {
    private static int idCounter = 1; // Helper for auto-increment
    private final int authorId;
    private String name;
    private String email;
    private Book authorBook; // Assuming a Book class is already defined elsewhere

    // Parameterized constructor
    public Author(String name, String email, Book authorBook) {
        this.authorId = idCounter++;
        setName(name);
        setEmail(email);
        setAuthorBook(authorBook);
    }

    public Author(String name, String email) {
        this.authorId = idCounter++;
        setName(name);
        setEmail(email);
    }

    // Getters
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

    // Setters
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Author name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Author email cannot be null or empty.");
        }
        this.email = email;
    }

    public void setAuthorBook(Book authorBook) {
        if (authorBook == null) {
            throw new IllegalArgumentException("Author must be linked to a Book.");
        }
        this.authorBook = authorBook;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Email: %s, Book: %s",
                authorId, name, email, authorBook != null ? authorBook.getTitle() : "None");
    }
}


