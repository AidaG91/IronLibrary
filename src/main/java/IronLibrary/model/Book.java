package IronLibrary.model;

// Represents a Book in the IronLibrary system
public class Book {
private String isbn;
private String title;
private String category;
public int quantity;

    public Book(String isbn, String title, String category, int quantity) {
        setIsbn(isbn);
        setTitle(title);
        setCategory(category);
        setQuantity(quantity);
    } // Use setters in the constructor to apply validations when creating the object

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty.");
        }
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    // Prevent negative quantities
    public int setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        return this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty.");
        }
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    // Provide a readable string for debugging and printing books
    @Override
    public String toString() {
        return String.format("%-22s %-20s %-12s %-10d",
                isbn,
                title,
                category,
                quantity);
    }
}
